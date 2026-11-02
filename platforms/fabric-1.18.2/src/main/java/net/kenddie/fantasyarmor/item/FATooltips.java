package net.kenddie.fantasyarmor.item;

import net.minecraft.network.chat.Component;
import net.minecraft.network.chat.MutableComponent;
import net.minecraft.network.chat.Style;
import net.minecraft.util.StringDecomposer;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public final class FATooltips {
    private FATooltips() {}

    public static void append(Component text, int maxCharacters, Consumer<Component> output) {
        List<StyledCharacter> characters = new ArrayList<>();
        StringDecomposer.iterateFormatted(text, Style.EMPTY, (index, style, codePoint) -> {
            characters.add(new StyledCharacter(codePoint, style));
            return true;
        });

        int limit = Math.max(1, maxCharacters);
        int start = 0;
        for (int end = 0; end < characters.size(); end++) {
            if (!characters.get(end).isLineBreak()) continue;
            appendParagraph(characters, start, end, limit, output);
            if (characters.get(end).codePoint() == '\r' && end + 1 < characters.size()
                    && characters.get(end + 1).codePoint() == '\n') end++;
            start = end + 1;
        }
        appendParagraph(characters, start, characters.size(), limit, output);
    }

    private static void appendParagraph(List<StyledCharacter> characters, int start, int end,
                                        int limit, Consumer<Component> output) {
        if (start == end) {
            output.accept(new net.minecraft.network.chat.TextComponent(""));
            return;
        }
        while (start < end) {
            int lineEnd = Math.min(start + limit, end);
            if (lineEnd < end && !characters.get(lineEnd).isSpace()) {
                for (int space = lineEnd - 1; space > start; space--) {
                    if (characters.get(space).isSpace()) {
                        lineEnd = space;
                        break;
                    }
                }
            }
            output.accept(line(characters, start, lineEnd));
            start = lineEnd;
            while (start < end && characters.get(start).isSpace()) start++;
        }
    }

    private static Component line(List<StyledCharacter> characters, int start, int end) {
        MutableComponent line = new net.minecraft.network.chat.TextComponent("");
        while (start < end) {
            Style style = characters.get(start).style();
            StringBuilder run = new StringBuilder();
            do {
                run.appendCodePoint(characters.get(start++).codePoint());
            } while (start < end && characters.get(start).style().equals(style));
            line.append(new net.minecraft.network.chat.TextComponent(run.toString()).setStyle(style));
        }
        return line;
    }

    private record StyledCharacter(int codePoint, Style style) {
        private boolean isLineBreak() {
            return codePoint == '\n' || codePoint == '\r';
        }

        private boolean isSpace() {
            return !isLineBreak() && Character.isWhitespace(codePoint);
        }
    }
}
