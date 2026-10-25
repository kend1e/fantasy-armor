package fantasy.definitions

import fantasy.gradle.resources.translations
import fantasy.gradle.resources.TranslationCatalog

val languages: TranslationCatalog = translations(namespace = mod.id) {
    language("en_us") {
        armorNames(
            helmet = "{name} Helmet",
            chestplate = "{name} Chestplate",
            leggings = "{name} Leggings",
            boots = "{name} Boots",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "Fantasy Armor")
        entry("item.${mod.id}.${moonCrystal.id}", "Moon Crystal")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "Moonlight captured in a crystal. Awakens the power of ancient armor.")

        armor("eclipse_soldier", name = "Eclipse Soldier") {
            description = "§7The armor of an infantryman who fought for the triumph of the eclipse over the sun long ago. \nIt is said that beneath the boots of the legions thousands of unfortunates have found death."
        }

        armor("golden_horns", name = "Golden Horns") {
            description = "§7A set that shines so brightly it appears to be carved from the light itself. \nHowever, its gold is not a blessing but a curse. \nThis gold has witnessed death and destruction, and its light feeds greed and bloodlust. \nThis armor serves its owner only as long as he is willing to sacrifice his enemies."
        }

        armor("dragonslayer", name = "Dragonslayer") {
            description = "§7This set is forged from the scales of defeated dragons, each one a symbol of ancient strength and fury.\nThe plates and spikes grant you the power of victory over them, but do not forget that every step taken in it bears the weight of many deaths."
        }

        armor("hero", name = "Hero") {
            description = "§7This set is the legacy of ancient warriors, each of whom fought to their last breath.\nIt holds the memory of countless battles and hardships endured in the search for justice.\nBut glory is a heavy burden.\nNot every story will endure through the ages."
        }

        armor("thief", name = "Thief") {
            description = "§7This set is the perfect companion for those who live in shadows and breathe darkness.\nThe wearer becomes one with the night.\nThe black mask conceals your face, leaving your enemies guessing."
        }

        armor("wandering_wizard", name = "Wandering Wizard") {
            description = "§7This set is infused with ancient magic.\nThe garments whisper forgotten spells and open gates to other worlds.\nEach thread of this attire binds its wearer to unknown forces, granting him the power to perform magic, but at the same time imposing the curse of eternal wandering without the right to rest."
        }

        armor("sunset_wings", name = "Sunset Wings") {
            description = "§7Sunset is both the end and the beginning at the same time.\nThe wings guide their owner through the darkness.\nWhen you don them, you become the somber messenger of eternal night."
        }

        armor("chess_board_knight", name = "Chess Board Knight") {
            description = "§7Every move is a battle, every step is a strategy.\nThis armor embodies the cold logic and ruthless power of warfare.\nWear it with the pride of a strategist, prepared to sacrifice everything for victory, even your soul."
        }

        armor("dark_lord", name = "Dark Lord") {
            description = "§7Created in the depths of another world, this set is the embodiment of the power of terror.\nIts spikes and black armor resemble broken fangs.\nWear it if you dare, but know that it demands eternal devotion to the darkness and devours those who attempt to resist it."
        }

        armor("fog_guard", name = "Fog Guard") {
            description = "§7Shrouded in ancient fog, this armor offers unmatched protection, but weakens its wearer with visions of lost realms."
        }

        armor("dark_cover", name = "Dark Cover") {
            description = "§7Enveloping its wearer in shadows, this armor grants protection from light and silence, but whispers forgotten secrets of dark forces.\nWear it, but heed the shadows' warnings."
        }

        armor("spark_of_dawn", name = "Spark of Dawn") {
            description = "§7Forged in the first light, this armor carries warmth and brightness, yet burns those not pure of heart.\nOnly the righteous may unlock its true power."
        }

        armor("golden_execution", name = "Golden Execution") {
            description = "§7Bearing the weight of the empire's wrath, this armor shines golden but is soaked in the blood of the fallen.\nWear it with pride, but never forget its cost."
        }

        armor("forgotten_trace", name = "Forgotten Trace") {
            description = "§7The memory of ancient wars lingers in this armor, haunting the wearer with echoes of battles long lost.\nOnce donned, it marks the wearer as a soul from another age."
        }

        armor("redeemer", name = "Redeemer") {
            description = "§7An armor set created by the old order. \nYour god was slain long ago, but your faith has endured. \nKnowing very well you will likely not return from your quest, you step forward bravely into the unknown."
        }

        armor("twinned", name = "Twinned") {
            description = "§7Bound to another in spirit, this armor shares both pain and triumph with its twin.\nA shared destiny awaits those who wear the full set."
        }

        armor("gilded_hunt", name = "Gilded Hunt") {
            description = "§7Worn by those who chase honor and glory, this armor reflects the wild ambition of its bearer.\nHunt with it, but beware - glory often has a steep price."
        }

        armor("lady_maria", name = "Lady Maria's") {
            description = "§7A corpse... should be left well alone. \nOh, I know very well. How the secrets beckon so sweetly. \nOnly an honest death will cure you now. \nLiberate you, from your wild curiosity."
        }

        armor("crucible_knight", name = "Crucible Knight") {
            description = "§7Hold the power of the crucible of life. \nIn time, the strength shown by these knights, and even their appearance, was seen as chaotic and deserving of scorn."
        }

        armor("evening_ghost", name = "Evening Ghost") {
            description = "§7Hidden in the night, the shadow knows its place. \nIts steps are silent, but the chill of its presence is felt on the skin."
        }

        armor("ronin", name = "Ronin") {
            description = "§7Steel bears the scars of the past, its patterns soaked with long-cooled blood."
        }

        armor("malenia", name = "Malenia") {
            description = "§7...Heed my words. I am Malenia. Blade of Miquella. And I have never known defeat."
        }

        armor("old_knight", name = "Old Knight") {
            description = "§7A set of armor once worn by a knight who survived countless battles. \nIts weight is unbearable for the weak, but those who endure shall never fall."
        }

        armor("silver_knight", name = "Silver Knight") {
            description = "§7The armor of an elite warrior who never faltered in battle. \nIts silver gleam reflects the moonlight, bringing swift death to those who dare oppose its master."
        }

        armor("dead_gladiator", name = "Dead Gladiator") {
            description = "§7Armor of a slave fallen in the arena. \nHis name is forgotten, but fury still burns beneath the steel."
        }

        armor("flesh_of_the_feaster", name = "Flesh of the Feaster") {
            description = "§7This armor reeks of blood and greed. \nIt once belonged to one who fed without end — and became what he consumed."
        }

        armor("wind_worshipper", name = "Wind Worshipper") {
            description = "§7The fabric is light as breath. \nWorn by those who know no rest, drifting wherever the wind may carry them."
        }

        armor("grave_sentinel", name = "Grave Sentinel") {
            description = "§7The armor that guards the sleep of the dead. \nOnce sworn to noble oaths, over time their duty twisted into a silent vigil among dust and silence."
        }

        armor("ornstein", name = "Ornstein") {
            description = "§7Golden plates shaped in the image of a lion.\nForged for the First Lord’s fiercest dragonslayer, the armor still hums with remnant lightning.\nThose who don the full set feel the echo of a spear strike, capable of piercing ancient stone scales."
        }

        armor("dawncrest", name = "Dawncrest") {
            description = "§7Forged for the sentinels who kept watch through the longest night, this armor bears the crest of the rising sun.\nIts faded gold remembers the first light over a silent battlefield.\nThose who wear it carry a promise: however deep the darkness, dawn will come."
        }
    }

    language("ja_jp") {
        armorNames(
            helmet = "{name}のヘルメット",
            chestplate = "{name}のチェストプレート",
            leggings = "{name}のレギンス",
            boots = "{name}のブーツ",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "Fantasy Armor")
        entry("item.${mod.id}.${moonCrystal.id}", "月の結晶")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "月光を閉じ込めた結晶。古の防具に眠る力を呼び覚ます。")

        armor("eclipse_soldier", name = "覆面兵士") {
            description = "§7太陽の勝利を掲げて戦った、かつての歩兵の鎧\n数千の不運な者たちが、軍団の足元で死を迎えたと言われている"
        }

        armor("golden_horns", name = "黄金角") {
            description = "§7まるで光そのものから削り出されたかのように、まばゆく輝く鎧\nしかしその黄金は祝福ではなく呪いである\nこの黄金は死と破壊の立ち会い人であり、その光は欲望と殺意を育む\nこの鎧が持ち主に仕えるのは、敵を生贄に捧げる意志を持つ間だけだ"
        }

        armor("dragonslayer", name = "竜殺し") {
            description = "§7打ち倒された竜の鱗から鍛え上げられたこの鎧は、その鱗の一枚一枚が古の力と猛りの象徴である\n重厚な板金と棘は竜を屠った力を授けるが、忘れるなかれ。その一歩ずつに、幾多の死が刻まれていることを"
        }

        armor("hero", name = "英雄") {
            description = "§7歴戦の勇士たちの遺産であり、その一人一人が息絶えるまで闘い抜いた証\n数え切れぬ戦いや、正義を求めて耐え抜いた苦難の記憶を宿している\nしかし、栄光とは重き荷である\nすべての物語が、時を越えて語り継がれるわけではないのだから"
        }

        armor("thief", name = "盗賊") {
            description = "§7闇に生き、影を友とする者に最適な装衣\n身につければ夜そのものと一体化する\n黒い仮面が顔を隠し、敵に正体を悟らせない"
        }

        armor("wandering_wizard", name = "放浪魔術師") {
            description = "§7この装備には古代の魔法が宿っている\nその衣は忘れられた呪文をささやき、異世界への扉を開く\nその衣の一本一本の糸が、着用者を未知の力で縛り付け、魔法を操る力を授ける。しかし同時に安らぎを奪い、永遠の放浪を強いる呪いが宿る"
        }

        armor("sunset_wings", name = "逢魔が翼") {
            description = "§7黄昏とは終わりであり、同時に始まりでもある\nその翼は、身につける者を暗闇へと導く\nこれを身につける時、あなたは常夜の薄暗き眷属となる"
        }

        armor("chess_board_knight", name = "チェス盤の騎士") {
            description = "§7すべての一手が戦いであり、すべての歩みが戦略である\nこの鎧は戦争の冷徹な論理と容赦なき力を体現する\n戦略家の誇りを胸に宿し、勝利のためには魂すら捧げる覚悟で挑むのだ"
        }

        armor("dark_lord", name = "暗黒卿") {
            description = "§7恐怖の力の具現であるこの装備は、異世界の深淵で創られた\n棘とその黒き鎧は、折れた牙を思わせる\n身に着ける者には、闇への永遠の献身が求められ、抗う者はその力に喰い尽くされる"
        }

        armor("fog_guard", name = "霧の守り人") {
            description = "§7古の霧に包まれた防具。一切に勝る防御を誇るが、失われた領域の幻影が身に着ける者の力を蝕む"
        }

        armor("dark_cover", name = "影纏い") {
            description = "§7影で身を包み、光と静寂からの保護を授けるが、暗黒の力の忘れ去られた秘密を囁き続ける\nこれを身につけるならば、影からの警告に耳を傾けよ"
        }

        armor("spark_of_dawn", name = "暁の閃光") {
            description = "§7始めの光の中で鍛えられたこの鎧は、温もりと輝きを宿し、不浄なる者を焼き払う\n正しき者のみが、その真の力を解き放つことができる"
        }

        armor("golden_execution", name = "黄金の断罪") {
            description = "§7黄金に輝きながら倒れた者の血に染まる、帝国の怒りの重みを背負う防具\n誇りを胸に身につけよ、その代償を忘れぬように"
        }

        armor("forgotten_trace", name = "忘却の痕跡") {
            description = "§7古の戦の記憶がこの防具に残り、長く失われたその残響が身に着ける者を苛む\n装備した者は、かつての時代の魂の片鱗を帯びる"
        }

        armor("redeemer", name = "救い手") {
            description = "§7古き秩序によって作られた鎧\n神は遠い昔に倒されたが、信仰はなお残る\n帰らぬことを承知で、未知へと勇敢なる一歩を踏み出す"
        }

        armor("twinned") {
            helmet = "双児の兜"
            chestplate = "双児の鎧"
            leggings = "双児の脚当て"
            boots = "双児の足甲"
            description = "§7精神で結ばれたもう一人の者と痛みも勝利も共有する鎧\n一式を身に着ける者には、共通の運命が待つ"
        }

        armor("gilded_hunt", name = "金色狩り") {
            description = "§7名誉と栄光を追い求める者の野心を映す鏡のような鎧\n狩りに臨め、だが覚悟せよ—— 栄光には高い代償が伴うだろう"
        }

        armor("lady_maria") {
            helmet = "レディ・マリアの狩帽子"
            chestplate = "レディ・マリアの狩装束"
            leggings = "レディ・マリアの狩ズボン"
            boots = "レディ・マリアの狩ブーツ"
            description = "§7死体は…そっとしておくべきもの\nああ、よく分かっているよ。秘密は甘いものだ\n今や救いは、誠実な死のみ\n好奇心の奔流から解き放たれるのだ"
        }

        armor("crucible_knight") {
            helmet = "坩堝の騎士の斧兜"
            chestplate = "坩堝の騎士の斧鎧"
            leggings = "坩堝の騎士の脚当て"
            boots = "坩堝の騎士の足甲"
            description = "§7生命の坩堝の力を宿す鎧\nその姿、そして力は、後に秩序無きものとして蔑まれた"
        }

        armor("evening_ghost") {
            helmet = "宵闇の冥人の編笠"
            chestplate = "宵闇の冥人の装束"
            leggings = "宵闇の冥人の脚当て"
            boots = "宵闇の冥人の足袋"
            description = "§7夜に潜み、影はその居場所を知る\n足取りは気取られずとも、その気配の冷たさは肌に感じられる"
        }

        armor("ronin") {
            helmet = "浪人の兜"
            chestplate = "浪人の胴当て"
            leggings = "浪人の脛当て"
            boots = "浪人の足袋"
            description = "§7鋼に刻まれた意匠ともとれるような過去の傷跡には、冷めた血が染み込んでいる"
        }

        armor("malenia") {
            helmet = "マレニアの翼兜"
            chestplate = "マレニアの鎧"
            leggings = "マレニアの脚当て"
            boots = "マレニアの足甲"
            description = "§7…貴公も、知るがよい。ミケラの刃、マレニアを。敗れを知らぬ戦いを"
        }

        armor("old_knight", name = "老騎士") {
            description = "§7数え切れぬ戦を生き抜いた騎士がかつて身に纏った鎧\n弱者には耐えられない重さだが、扱える者は決して倒れないだろう"
        }

        armor("silver_knight", name = "銀騎士") {
            description = "§7決してひるむことなく戦った精鋭たちの鎧\nその白銀たる輝きは月光を反射し、対峙する者に容赦なき死をもたらす"
        }

        armor("dead_gladiator", name = "死せる剣闘士") {
            description = "§7闘技場で倒れた奴隷の鎧\n名も忘れられたかつての主が身につけたその鋼の下には、激しい怒りが今もなお燃え続けている"
        }

        armor("flesh_of_the_feaster", name = "肉の饗宴者") {
            description = "§7この鎧は血と欲望の匂いを漂わせる\nそれはかつて、果てなき食欲に身を委ねた者のもの――そして、彼は自らが貪ったものと化した"
        }

        armor("wind_worshipper", name = "風の崇拝者") {
            description = "§7布地は息のように軽い\n休みを知らぬ者が身にまとい、風の赴くまま漂う"
        }

        armor("grave_sentinel", name = "墓所の番人") {
            description = "§7死者の眠りを守る鎧\nかつては高貴な誓いを立てたが、時とともにその務めは、塵と静寂の中で沈黙の番人へと変わった"
        }

        armor("ornstein", name = "オーンスタイン") {
            description = "§7獅子をかたどった黄金の鎧。\n最初の王に仕えた最も勇猛な竜狩りのために鍛えられ、今も雷の力を宿している。\n一式を身に纏う者は、古竜の石の鱗すら貫く槍の一撃、その残響を感じるだろう。"
        }

        armor("dawncrest", name = "暁の紋章") {
            description = "§7最も長い夜を見張り続けた番人たちのために鍛えられた、昇る太陽の紋章を宿す鎧。\n色あせた黄金は、静まり返った戦場に差した最初の光を覚えている。\nこれを纏う者は一つの約束を胸に抱く。どれほど闇が深くとも、夜明けは訪れる。"
        }
    }

    language("ru_ru") {
        armorNames(
            helmet = "Шлем {name}",
            chestplate = "Нагрудник {name}",
            leggings = "Поножи {name}",
            boots = "Ботинки {name}",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "Fantasy Armor")
        entry("item.${mod.id}.${moonCrystal.id}", "Лунный кристалл")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "Лунный свет, заключённый в кристалл. Пробуждает силу древних доспехов.")

        armor("eclipse_soldier", name = "Солдата Затмения") {
            description = "§7Доспехи пехотинца, когда-то давно сражавшегося за торжество затмения над солнцем. \nКто-то говорит, что под сапогами легионов нашли смерть тысячи несчастных."
        }

        armor("golden_horns", name = "Золотого Рога") {
            description = "§7Комплект, сияющий так ярко, что кажется, будто он вырезан из самого света. \nНо золото его — не благословение, а проклятие. \nЭто золото увидело смерть и разрушение, и его свет питает алчность и жажду крови. \nЭтот доспех служит своему хозяину до тех пор, пока тот готов приносить в жертву его врагов."
        }

        armor("dragonslayer", name = "Драконоборца") {
            description = "§7Этот комплект выкован из чешуи поверженных драконов, каждый из которых был символом древней силы и ярости. \nПластины и шипы дают мощь победы над ними, но не забудь, что каждый шаг в нем несет отпечаток многих смертей."
        }

        armor("hero", name = "Героя") {
            description = "§7Этот комплект — наследие древних воинов, каждый из которых сражался до последнего вздоха. \nОн хранит в себе память о бесчисленных битвах и тяготах, перенесенных в поисках справедливости. \nНо слава — это тяжкое бремя. \nНе каждая история сохранится в веках."
        }

        armor("thief", name = "Вора") {
            description = "§7Этот комплект — идеальный спутник для тех, кто живет в тенях и дышит темнотой. \nОблаченный в него становится частью ночи. \nЧёрная маска скрывает лицо, оставляя врагам лишь догадки."
        }

        armor("wandering_wizard", name = "Странствующего Чародея") {
            description = "§7Этот комплект пронизан древней магией. \nОдеяния шепчут забытые заклинания и открывают врата в иные миры. \nКаждая нить этой одежды связывает своего носителя с неведомыми силами, давая ему власть творить волшбу, но в то же время накладывая проклятие вечного странствия без права на покой."
        }

        armor("sunset_wings", name = "Крыльев Заката") {
            description = "§7Закат — это конец и начало одновременно. \nКрылья ведут своего хозяина сквозь мглу. \nОблачившись в него, вы становитесь мрачным вестником вечной ночи."
        }

        armor("chess_board_knight", name = "Рыцаря Шахматной Доски") {
            description = "§7Каждый ход — битва, каждый шаг — стратегия. \nЭта броня несет в себе холодную логику и безжалостную силу войн. \nНосите его с гордостью стратега, готового пожертвовать всем ради победы, даже своей душой."
        }

        armor("dark_lord", name = "Тёмного Лорда") {
            description = "§7Созданный в глубинах иного мира, этот комплект является воплощением власти ужаса. \nЕго шипы и черные доспехи подобны сломанным клыкам. \nНосите его, если осмелитесь, но знайте — он требует вечной преданности мраку и пожирает тех, кто пытается ему противостоять."
        }

        armor("fog_guard", name = "Стража Тумана") {
            description = "§7Окутанный древним туманом, этот доспех обеспечивает непревзойденную защиту, но ослабляет своего носителя видениями забытых миров."
        }

        armor("dark_cover", name = "Тёмного Покрова") {
            description = "§7Окутывая носителя в тени, этот доспех дарует защиту от света и тишину, но нашёптывает забытые секреты тёмных сил.\nНоси его, но остерегайся предупреждений теней."
        }

        armor("spark_of_dawn", name = "Искры Рассвета") {
            description = "§7Созданный на заре, этот доспех несёт тепло и свет, но обжигает тех, кто не чист сердцем.\nТолько праведные смогут раскрыть его истинную силу."
        }

        armor("golden_execution", name = "Золотой Казни") {
            description = "§7Несущий тяжесть имперского гнева, этот доспех сияет золотом, но пропитан кровью павших.\nНосите его с гордостью, но никогда не забывайте его цену."
        }

        armor("forgotten_trace", name = "Забытых Следов") {
            description = "§7Память о древних войнах остаётся в этом доспехе, преследуя носителя эхом давно проигранных битв.\nОднажды надевший его отмечен душами из другой эпохи."
        }

        armor("redeemer", name = "Искупителя") {
            description = "§7Доспех, созданный при древнем порядке.\nВаш бог был убит давно, но вера осталась.\nХоть и зная, что, шансы вернуться невелики, вы смело ступаете в неизвестность."
        }

        armor("twinned", name = "Близнецов") {
            description = "§7Связанная с другой в духе, это броня делит и боль, и триумф со своим близнецом.\nОбщая судьба ожидает тех, кто носит полный комплект."
        }

        armor("gilded_hunt", name = "Золотой Охоты") {
            description = "§7Надетая теми, кто жаждет чести и славы, это броня отражает дикое стремление своего владельца.\nОхотьтесь с ней, но будьте осторожны - слава часто имеет высокую цену."
        }

        armor("lady_maria", name = "Леди Марии") {
            description = "§7Не стоит прикасаться к телам. \nО, я-то знаю, как сладостно манят тайны. \nТеперь только честная смерть принесет тебе исцеление. \nОсвободит тебя от твоего неимоверного любопытства."
        }

        armor("crucible_knight", name = "Рыцаря Горнила") {
            description = "§7Овладейте силой горнила жизни. \nСо временем сила, демонстрируемая этими рыцарями, и даже их внешний вид стали восприниматься как хаотичные и заслуживающие презрения."
        }

        armor("evening_ghost", name = "Вечернего Призрака") {
            description = "§7Скрытая в ночи, тень знает, где её место. \nЕё шаги неслышны, но холод присутствия ощущается кожей."
        }

        armor("ronin", name = "Ронина") {
            description = "§7Сталь носит шрамы прошлого, кровь давно остывшая впиталась в её узоры."
        }

        armor("malenia", name = "Малении") {
            description = "§7...Внемлите моим словам. Я — Маления, клинок Микеллы. И я никогда не знала поражения."
        }

        armor("old_knight", name = "Старого Рыцаря") {
            description = "§7Когда-то этот доспех носил рыцарь, прошедший сотни битв. \nЕго вес невыносим для слабых, но те, кто выдержат — никогда не падут."
        }

        armor("silver_knight", name = "Серебряного Рыцаря") {
            description = "§7Доспех элитного воина, не знавшего поражений. \nЕго серебряный блеск отражает лунный свет и несёт быструю смерть врагам."
        }

        armor("dead_gladiator", name = "Мёртвого гладиатора") {
            description = "§7Броня раба, павшего на арене. \nИмя забыто, но ярость по-прежнему пылает под этой сталью."
        }

        armor("flesh_of_the_feaster", name = "Плоти Пожирателя") {
            description = "§7Эта броня источает запах крови и жадности. \nКогда-то она принадлежала тому, кто ел без остановки — и стал тем, чем он питался."
        }

        armor("wind_worshipper", name = "Поклонника ветра") {
            description = "§7Ткань легка, как дыхание. \nЕё носят те, кто не знает покоя и следует за ветром, куда бы он ни унес."
        }

        armor("grave_sentinel", name = "Стража Кладбища") {
            description = "§7Облачитесь в броню, что сторожит покой мёртвых. \nКогда-то их клятвы были благородны, но с течением веков их долг исказился в бессловесную стражу среди праха и тишины."
        }

        armor("ornstein", name = "Орнштейна") {
            description = "§7Золотые пластины, созданные в образе льва.\nКованные для яростнейшего драконоборца Первого Владыки, доспехи всё ещё гудят остаточной молнией.\nТот, кто облачится в полный комплект, ощущает отзвук копья, способного пронзить древнюю каменную чешую."
        }

        armor("dawncrest", name = "Герба Рассвета") {
            description = "§7Эта броня, выкованная для стражей, стоявших на дозоре в самую долгую ночь, несёт герб восходящего солнца.\nЕё потускневшее золото помнит первый свет над затихшим полем боя.\nТе, кто носит её, хранят обещание: как бы ни была глубока тьма, рассвет наступит."
        }
    }

    language("uk_ua") {
        armorNames(
            helmet = "Шолом {name}",
            chestplate = "Нагрудник {name}",
            leggings = "Наголінники {name}",
            boots = "Чоботи {name}",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "Fantasy Armor")
        entry("item.${mod.id}.${moonCrystal.id}", "Місячний кристал")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "Місячне світло, ув’язнене в кристалі. Пробуджує силу стародавніх обладунків.")

        armor("eclipse_soldier", name = "Солдата Затемнення") {
            description = "§7Броня піхотинця, який колись боровся за тріумф затемнення над сонцем. \nКажуть, що під черевиками легіонів знайшли смерть тисячі нещасних."
        }

        armor("golden_horns", name = "Золотого Рогу") {
            description = "§7Комплект, що сяє так яскраво, що здається, ніби вирізаний із самого світла. \nАле золото його — не благословення, а прокляття. \nЦе золото бачило смерть і руйнування, і його світло живить жадобу та жагу крові. \nЦей доспіх служить своєму власнику до тих пір, поки той готовий приносити в жертву своїх ворогів."
        }

        armor("dragonslayer", name = "Драконоборця") {
            description = "§7Цей комплект кований з луски переможених драконів, кожен з яких був символом древньої сили та люті. \nПластини і шипи надають могутність перемоги над ними, але не забувайте, що кожен крок в ньому несе відбиток багатьох смертей."
        }

        armor("hero", name = "Героя") {
            description = "§7Цей комплект — спадщина древніх воїнів, кожен з яких боровся до останнього подиху. \nВін зберігає в собі пам’ять про безліч битв і тягот, перенесених у пошуках справедливості. \nАле слава — це важке тягар. \nНе кожна історія залишиться в віках."
        }

        armor("thief", name = "Крадія") {
            description = "§7Цей комплект — ідеальний супутник для тих, хто живе в тінях і дихає темрявою. \nОдягнувшись у нього, стаєш частиною ночі. \nЧорна маска приховує обличчя, залишаючи ворогам лише здогадки."
        }

        armor("wandering_wizard", name = "Мандрівного Чаклуна") {
            description = "§7Цей комплект пронизаний стародавньою магією. \nОдягання шепоче забуті закляття і відкриває ворота в інші світи. \nКожна нитка цього одягу пов'язує свого носія з невідомими силами, надаючи йому владу творити чари, але в той же час накладаючи прокляття вічного мандрування без права на спокій."
        }

        armor("sunset_wings", name = "Крил Сутінків") {
            description = "§7Захід сонця — це кінець і початок одночасно. \nКрила ведуть свого господаря крізь мглу. \nОдягнувшись у нього, ви стаєте похмурим вісником вічної ночі."
        }

        armor("chess_board_knight", name = "Шахової Дошки") {
            description = "§7Кожен хід — це битва, кожен крок — стратегія. \nЦя броня несе в собі холодну логіку та безжальну силу війн. \nНосіть його з гордістю стратега, готового пожертвувати всім заради перемоги, навіть своєю душею."
        }

        armor("dark_lord", name = "Темного Лорда") {
            description = "§7Створений в глибинах іншого світу, цей комплект є втіленням влади жаху. \nЙого шипи і чорні лати подібні до поламаних іклів. \nНосіть його, якщо наважитеся, але знайте — він вимагає вічної відданості темряві та поглинає тих, хто намагається йому протистояти."
        }

        armor("fog_guard", name = "Старжника Туману") {
            description = "§7Охоплений давнім туманом, цей обладунок забезпечує неперевершений захист, але робить свого носія вразливи через видіння забутих світів."
        }

        armor("dark_cover", name = "Темного Покрову") {
            description = "§7Загортаючи носія у тіні, цей обладунок надає захист від світла й тишу, але нашіптує забуті секрети темних сил.\nНоси його, але стережися попереджень тіней."
        }

        armor("spark_of_dawn", name = "Іскри Світанку") {
            description = "§7Створений на зорі, цей обладунок несе тепло та світло, але обпалює тих, хто не чистий серцем.\nЛише праведні зможуть розкрити його справжню силу."
        }

        armor("golden_execution", name = "Золотої Страти") {
            description = "§7Несе вагу імперського гніву, цей обладунок сяє золотом, але просякнутий кров'ю полеглих.\nНосіть його з гордістю, але ніколи не забувайте його ціну."
        }

        armor("forgotten_trace", name = "Забутих Слідів") {
            description = "§7Пам'ять про давні війни залишається в цьому обладунку, переслідуючи носія ехом давно програних битв.\nТой, хто носив його, позначений душами з іншої епохи."
        }

        armor("redeemer", name = "Викупителя") {
            description = "§7Обладунок, створений давнім орденом.\nВаш бог був убитий давно, але віра залишилася.\nНавіть знаючи, що загине, той, хто носить цей обладунок, знайде себе."
        }

        armor("twinned", name = "Близнюків") {
            description = "§7Пов'язана з іншою духом, ця броня розділяє і біль, і тріумф зі своїм близнюком.\nСпільна доля чекає тих, хто носить повний комплект."
        }

        armor("gilded_hunt", name = "Золотого Полювання") {
            description = "§7Одягнена тими, хто прагне честі та слави, ця броня відображає дике прагнення свого власника.\nПолюйте з нею, але будьте обережні - слава часто має високу ціну."
        }

        armor("lady_maria", name = "Леді Марії") {
            description = "§7Не варто торкатися тіл. \nО, я-то знаю, як солодко ваблять таємниці. \nТепер лише чесна смерть принесе тобі зцілення. \nЗвільнить тебе від твоєї неймовірної допитливості."
        }

        armor("crucible_knight", name = "Лицаря Горнила") {
            description = "§7Опануйте силу горнила життя. \nЗ часом сила, яку демонстрували ці лицарі, та навіть їхній вигляд почав вважатися хаотичними та негідними."
        }

        armor("evening_ghost", name = "Примари Вечора") {
            description = "§7Схована в ночі, тінь знає своє місце. \nЇї кроки нечутні, але холод її присутності відчувається на шкірі."
        }

        armor("ronin", name = "Роніна") {
            description = "§7Сталь несе шрами минулого, її візерунки просякнуті давно охололою кров’ю."
        }

        armor("malenia", name = "Маленії") {
            description = "§7...Прислухайтесь до моїх слів. Я — Маленія, клинок Мікелли. І я ніколи не знала поразки."
        }

        armor("old_knight", name = "Старого Лицаря") {
            description = "§7Колись цей обладунок належав лицарю, що пережив сотні битв. \nЙого вага нестерпна для слабких, але ті, хто витримає — ніколи не впадуть."
        }

        armor("silver_knight", name = "Срібного Лицаря") {
            description = "§7Обладунок елітного воїна, що не знав поразок. \nЙого срібний блиск відображає місячне сяйво, приносячи швидку смерть ворогам."
        }

        armor("dead_gladiator", name = "Мертвого гладіатора") {
            description = "§7Броня воїна, що помер на арені. \nІм’я зникло, та лють усе ще палає під цією сталлю."
        }

        armor("flesh_of_the_feaster", name = "Пожирача") {
            description = "§7Ця броня просякнута запахом крові та жадоби. \nКолись її носив той, хто жер без зупинки, й сам став тим, що їв."
        }

        armor("wind_worshipper", name = "Шанувальника вітру") {
            description = "§7Тканина легка, мов подих. \nЇї носять ті, хто не знає спокою й мандрує за вітром, куди б він не ніс."
        }

        armor("grave_sentinel", name = "Могильного Вартового") {
            description = "§7Вдягніть броню, що стереже спокій мертвих. \nКолись їхні обітниці були шляхетними, та з роками їхній обов’язок спотворився у мовчазну варту серед попелу й тиші."
        }

        armor("ornstein", name = "Орнштейну") {
            description = "§7Золоті пластини, створені в образі лева.\nКовані для найлютішого драконоборця Першого Владики, обладунки все ще гудуть залишковою блискавкою.\nТой, хто одягнеться в повний комплект, відчуває відгук списа, здатного пронизати стародавню кам'яну луску."
        }

        armor("dawncrest", name = "Герба Світанку") {
            description = "§7Цю броню викували для вартових, які несли варту найдовшої ночі; на ній зображено герб сонця, що сходить.\nЇї потьмяніле золото пам’ятає перше світло над стихлим полем бою.\nТі, хто її носить, бережуть обіцянку: хоч якою глибокою буде темрява, світанок настане."
        }
    }

    language("zh_cn") {
        armorNames(
            helmet = "{name}头盔",
            chestplate = "{name}胸甲",
            leggings = "{name}护腿",
            boots = "{name}靴子",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "奇幻铠甲")
        entry("item.${mod.id}.${moonCrystal.id}", "皎月水晶")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "封存月光的水晶。唤醒古老铠甲的力量。")

        armor("eclipse_soldier", name = "日蚀战士") {
            description = "§7很久以前是为日蚀战胜太阳的步兵的铠甲。\n据说，在军团的铁蹄下，成千上万的不幸者败亡。"
        }

        armor("golden_horns", name = "金制角") {
            description = "§7这套装备闪烁着如此耀眼的光芒，仿佛是由光本身雕刻而成的。\n然而，上面的黄金不是祝福，而是诅咒。 \n这些黄金见证了死亡和毁灭，它的光芒助长了贪婪和嗜血。\n唯有在主人愿意献祭敌人的情况下，这件铠甲才会为其服务。"
        }

        armor("dragonslayer", name = "屠龙") {
            description = "§7用败亡之龙的鳞片所锻造而成的一套铠甲，每条巨龙都象征着远古的力量和愤怒。\n这些铁板与尖刺赋予你战胜它们的力量，但不要忘记，每一步都承载着许多死亡的重量。"
        }

        armor("hero", name = "英雄") {
            description = "§7这套装备是古代战士的遗产，他们每个人都浴血奋战至最后一刻。\n它保存着为寻求正义而经历的无数战斗与艰辛的记忆。\n但荣耀是一个沉重的负担。\n也并非每个故事，都会经久不衰。"
        }

        armor("thief", name = "盗贼") {
            helmet = "盗贼兜帽"
            description = "§7这套装备是那些生于阴影并在黑暗中呼吸之人的完美伴侣。\n穿戴者会与黑夜融为一体。\n黑色面具掩面，使敌人心怀揣测。"
        }

        armor("wandering_wizard", name = "流浪巫师") {
            helmet = "流浪巫师大帽"
            description = "§7这套装备注入了古老魔法。\n使得这些衣物低语着被遗忘的咒语，打开了通往其他世界的大门。\n这件服装的千丝万缕都将穿戴者与未知之力捆绑在一起，赋予其施放魔法的能力，但也同时降下永无止息地流浪的诅咒。"
        }

        armor("sunset_wings", name = "薄暮双翼") {
            description = "§7薄暮既是终焉，亦是开端。\n双翼引导它们的主人穿过黑暗。\n当你穿戴上它们时，就会化身永恒之夜的忧郁使者。"
        }

        armor("chess_board_knight", name = "棋盘骑士") {
            helmet = "棋盘骑士铠甲"
            description = "§7一举一动都是一场搏杀，一静一动都是一次战略。\n这件铠甲显现出战争的冷酷逻辑和无情力量。\n带着战略家的自豪穿戴它，准备好为胜利赴汤蹈火，甚至献上你的灵魂。"
        }

        armor("dark_lord", name = "黑暗之主") {
            helmet = "黑暗之主铠甲"
            description = "§7这套铠甲创造于其他世界的深渊，是可怖力量的化身。\n其上的尖刺和黑色甲胄犹如折断的獠牙。\n若有勇力，就穿上它，但记住，它需要你永世臣服于黑暗，并吞噬那些妄图抵抗它的人。"
            bootsDescription = "§7这套铠甲创造于其他世界深渊的，是可怖力量的化身。\n其上的尖刺和黑色甲胄犹如折断的獠牙。\n若有勇力，就穿上它，但记住，它需要你永世臣服于黑暗，并吞噬那些妄图抵抗它的人。"
        }

        armor("fog_guard", name = "雾卫") {
            description = "§7这件铠甲笼罩在古老的迷雾中，因而拥有无与伦比的保护性，但穿戴者会因恍惚于破败国度的幻象而遭到削弱"
        }

        armor("dark_cover", name = "暗覆") {
            description = "§7这件铠甲将佩戴者笼罩于阴影之中，使得穿戴者具有对光明和寂静的抗性，但其低语着已被遗忘的黑暗力量的秘密。\n穿上它，但要对阴影们有戒备之心。"
        }

        armor("spark_of_dawn", name = "明焰") {
            description = "§7这件铠甲于第一道光中锻造而成，承载着温暖和光明，但也会燃烧那些不纯之人。\n唯有义人才能使其显现出真正的力量"
        }

        armor("golden_execution", name = "黄金处刑") {
            description = "§7这件铠甲承受着帝国的愤怒，浸透了罪人鲜血的铠甲缝隙中，闪耀着金色的光芒\n自豪地穿戴吧，但永远不要忘记它由什么铸成。"
        }

        armor("forgotten_trace", name = "遗迹") {
            description = "§7古代战争上的记忆萦绕于这件铠甲，使得穿戴者身旁回荡着久违鏖战的回声。\n一旦穿戴，即意味着你，是来自于另一个时代的灵魂。"
            leggingsDescription = "§7古代战争上的记忆萦绕于这件铠甲，使得穿戴者身旁回荡着久违鏖战的回声。\n一旦穿戴即，意味着你，是来自于另一个时代的灵魂。"
        }

        armor("redeemer", name = "救世主") {
            description = "§7一套由古旧秩序所创造的铠甲。 \n汝神虽逝，信念长存。\n纵有身死，亦勇往之。"
        }

        armor("twinned", name = "孪生") {
            description = "§7这件铠甲在精神领域上，与另一件铠甲相连，并与它的孪生兄弟共承甘苦。\n穿着全套铠甲的人将面临共同的命运。"
        }

        armor("gilded_hunt", name = "镀金狩猎") {
            description = "§7追逐荣誉荣耀之人所穿戴的铠甲，反映了其持有者的不羁野心。\n用它去狩猎吧，但要小心——荣耀之重有千斤。"
        }

        armor("lady_maria", name = "玛丽亚女士的") {
            helmet = "玛丽亚女士的帽子"
            description = "§7应该让尸体好好安息才对。\n噢，我清楚得很，那些秘密确实令人难以抗拒。 \n看来只有让你安息，才得以治愈你了。\n使你从那失控的好奇心中解脱。"
        }

        armor("crucible_knight", name = "熔炉骑士") {
            description = "§7拥有生命熔炉的力量。 \n随着岁月流逝，这些骑士所显露的力量乃至其形象，皆被视为混沌，理应受到轻蔑。"
        }

        armor("evening_ghost", name = "夜鬼") {
            description = "§7藏匿于夜幕之中，暗影知晓其归宿。\n它的步伐悄无声息，可皮肤上确切的能感受到上面阵阵寒意的存在。"
        }

        armor("ronin", name = "浪人") {
            description = "§7钢铁承载着过往的伤痕，其上的纹理浸透了早已冷却的血迹。"
        }

        armor("malenia", name = "玛莲妮亚的") {
            description = "§7...好好感受吧。我玛莲妮亚，身为米凯拉的锋刃———战无不胜的理由。"
        }

        armor("old_knight", name = "古老骑士") {
            description = "§7这套铠甲曾经被一位在无数战斗中幸存下来的骑士所穿戴。\n它的重量，弱者难以承受，但对于那些能够承受住它的人来说，他们将屹立不倒。"
        }

        armor("silver_knight", name = "银骑士") {
            description = "§7这是一套曾历经无数战斗洗礼的精锐战士所穿戴的铠甲。 \n其银色的光泽在月光下闪烁，仿佛是夜幕中的一道寒芒，对敢于反抗其主人的敌人而言，它即是迅速降下死亡的宣告。"
        }

        armor("dead_gladiator", name = "死亡斗士") {
            description = "§7这是一位在角斗场中战败奴隶的战甲。\n他的姓名早已被遗忘，可那怒火却依旧在寒铁之下熊熊燃烧。"
        }

        armor("flesh_of_the_feaster", name = "奢欲之躯") {
            helmet = "奢宴之躯头盔"
            description = "§7这副战甲浸透着鲜血与贪婪。\n它曾为一位永不餍足的吞噬者所有——而他最终化为了他所吞食之物的化身。"
        }

        armor("wind_worshipper", name = "风崇者") {
            description = "§7风崇者之衣的布料轻若呼吸。\n它属于那些永无停歇的流浪者,他们随风漂泊，任凭风将他们带到任何地方。"
        }

        armor("grave_sentinel", name = "墓穴哨兵") {
            description = "§7守护亡者长眠的铠甲。\n它们曾立下崇高誓言，却在时光中渐次扭曲，化作尘寂之中的缄默守望。"
            bootsDescription = "§7守护亡者长眠的铠甲。 \n它们曾立下崇高誓言，却在时光中渐次扭曲，化作尘寂之中的缄默守望。"
        }

        armor("ornstein", name = "翁斯坦") {
            description = "§7以雄狮为形锻造的黄金铠甲。\n它为初始之王麾下最勇猛的猎龙者而铸，至今仍萦绕着雷电的余威。\n穿齐整套铠甲的人，能感受到足以贯穿古龙石鳞的长枪一击所留下的回响。"
        }

        armor("dawncrest", name = "曙光纹章") {
            description = "§7为在漫漫长夜中坚守的卫士锻造的铠甲，镌刻着旭日的纹章。\n黯淡的黄金仍记得寂静战场上洒落的第一缕晨光。\n身披此甲之人守护着一个承诺：无论黑暗多么深沉，黎明终将到来。"
        }
    }


    language("tr_tr") {
        armorNames(
            helmet = "{name} Miğferi",
            chestplate = "{name} Göğüslüğü",
            leggings = "{name} Tozluğu",
            boots = "{name} Çizmesi",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "Fantasy Armor")
        entry("item.${mod.id}.${moonCrystal.id}", "Ay Kristali")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "Ay ışığını içinde hapseden bir kristal. Kadim zırhların gücünü uyandırır.")

        armor("eclipse_soldier", name = "Tutulma Askeri") {
            description = "§7Çok eski zamanlarda tutulmanın güneşe karşı zaferi uğruna savaşmış bir piyadenin zırhı.\nLejyonların çizmeleri altında binlerce talihsizin ölüme kavuştuğu söylenir."
        }

        armor("golden_horns", name = "Altın Boynuz") {
            description = "§7Öylesine göz kamaştırıcıdır ki, sanki ışığın kendisinden yontulmuş gibidir.\nNe var ki altını bir lütuf değil, lanettir.\nBu altın ölüm ve yıkıma tanıklık etmiş; parıltısı açgözlülüğü ve kana susamışlığı beslemiştir.\nBu zırh, sahibine ancak düşmanlarını feda etmeye razı olduğu sürece hizmet eder."
        }

        armor("dragonslayer", name = "Ejderha Avcısı") {
            description = "§7Mağlup edilmiş ejderhaların pullarından dövülmüştür; her biri kadim güç ve öfkenin bir simgesidir.\nZırhın plakaları ve dikenleri sana ejderhalar üzerindeki zaferin kudretini bahşeder. Ancak unutma: Bu zırhla atılan her adım, sayısız ölümün ağırlığını taşır."
        }

        armor("hero", name = "Kahraman") {
            description = "§7Her biri son nefesine dek savaşmış kadim savaşçıların mirasıdır.\nAdalet uğruna göğüslenen sayısız savaşın ve cefanın hatırasını taşır.\nFakat şan ağır bir yüktür.\nHer hikâye çağların ötesine ulaşamaz."
        }

        armor("thief", name = "Hırsız") {
            description = "§7Gölgelerde yaşayan ve karanlığı soluyanlar için kusursuz bir yoldaştır.\nOnu kuşanan, geceyle bir olur.\nKara maske yüzünü gizler; düşmanlarını ise kim olduğuna dair şüphe içinde bırakır."
        }

        armor("wandering_wizard", name = "Gezgin Büyücü") {
            helmet = "Gezgin Büyücü Başlığı"
            chestplate = "Gezgin Büyücü Cübbesi"
            leggings = "Gezgin Büyücü Pantolonu"
            boots = "Gezgin Büyücü Çarığı"
            description = "§7Kadim büyüyle yoğrulmuştur.\nGiysileri unutulmuş büyüleri fısıldar, başka dünyalara açılan kapılar aralar.\nBu giysinin her bir ipliği, sahibini bilinmeyen güçlere bağlar; ona büyü yapma kudreti verirken dinlenmeye izin vermeyen ebedi bir gezginlik laneti de yükler."
        }

        armor("sunset_wings", name = "Gün Batımı Kanatları") {
            description = "§7Günbatımı, aynı anda hem son hem de başlangıçtır.\nKanatlar sahibine karanlığın içinden yol gösterir.\nOnları kuşandığında, ebedi gecenin hüzünlü habercisine dönüşürsün."
        }

        armor("chess_board_knight", name = "Satranç Şövalyesi") {
            leggings = "Satranç Şövalyesi Pantolonu"
            description = "§7Her hamle bir savaş, her adım bir stratejidir.\nBu zırh, savaşın soğuk mantığını ve acımasız kudretini cisimleştirir.\nOnu bir stratejistin gururuyla kuşan; zafer uğruna her şeyi, hatta ruhunu bile feda etmeye hazır ol."
        }

        armor("dark_lord", name = "Karanlığın Lordu") {
            description = "§7Başka bir dünyanın derinliklerinde yaratılmış bu zırh, dehşetin kudretinin vücut bulmuş halidir.\nDikenleri ve kara zırhı, kırılmış dişleri andırır.\nCesaretin varsa kuşan; lakin karanlığa ebedi sadakat istediğini ve ona direnenleri yuttuğunu bil."
        }

        armor("fog_guard", name = "Pus Muhafızı") {
            description = "§7Kadim sislerle örtülü bu zırh, eşsiz bir koruma sunar; ancak sahibini kayıp diyarların görüntüleriyle zayıflatır."
        }

        armor("dark_cover", name = "Zifiri Örtü") {
            description = "§7Sahibini gölgelere bürüyen bu zırh, ışığa karşı koruma ve sessizlik bahşeder; fakat karanlık güçlerin unutulmuş sırlarını fısıldar.\nKuşan, ama gölgelerin uyarılarına kulak ver."
        }

        armor("spark_of_dawn", name = "Şafak Kıvılcımı") {
            description = "§7İlk ışığın doğduğu anda dövülen bu zırh, sıcaklık ve aydınlık taşır; ne var ki kalbi temiz olmayanı yakar.\nGerçek kudretini yalnızca Erdemliler açığa çıkarabilir."
        }

        armor("golden_execution", name = "Altın İnfazcı") {
            description = "§7İmparatorluğun gazabının yükünü taşıyan bu zırh altın gibi parlar, fakat düşenlerin kanına bulanmıştır.\nOnu gururla kuşan; ama bedelini asla unutma."
        }

        armor("forgotten_trace", name = "Unutulmuş İz") {
            leggings = "Unutulmuş İz Pantolonu"
            description = "§7Kadim savaşların hatırası bu zırhın içinde hâlâ yankılanır; kaybedilmiş nice savaşın izleri, onu kuşananın peşini bırakmaz. Bir kez kuşanıldığında, sahibini başka bir çağdan kalmış ruh olarak damgalar."
        }

        armor("redeemer", name = "Kefaretçi") {
            leggings = "Kefaretçi Pantolonu"
            description = "§7Kadim tarikat tarafından yaratılmış bir zırh.\nTanrın çok uzun zaman önce öldürüldü, fakat inancın ayakta kaldı.\nBu görevden dönmeme ihtimalini gayet iyi bilerek, bilinmeyene cesaretle bir adım atarsın."
        }

        armor("twinned", name = "İkiz Ruh") {
            leggings = "İkiz Ruh Pantolonu"
            description = "§7Ruhen bir başkasına bağlanmış bu zırh, acıyı ve zaferi ikiziyle paylaşır.\nBu setin tamamını kuşananları ortak bir kader bekler."
        }

        armor("gilded_hunt", name = "Yaldızlı Av") {
            leggings = "Yaldızlı Av Pantolonu"
            description = "§7Onur ve şanın peşinden koşanlar tarafından kuşanılır; sahibinin dizginlenmemiş hırsını yansıtır.\nOnunla ava çık, fakat dikkat et — şanın bedeli çoğu zaman ağırdır."
        }

        armor("lady_maria", name = "Lady Maria'nın") {
            leggings = "Lady Maria'nın Pantolonu"
            description = "§7Bir ceset... olduğu yerde, huzur içinde bırakılmalı.\nAh, çok iyi biliyorum. Sırların insanı nasıl da tatlı tatlı çağırdığını.\nArtık seni yalnızca dürüst bir ölüm iyileştirebilir.\nSeni o dizginlenemez merakından özgür bırakabilir."
        }

        armor("crucible_knight", name = "Kor Ocağı Şövalyesi") {
            description = "§7Yaşam ocağının kadim gücünü barındırır. Zamanla bu şövalyelerin sergilediği kudret ve hatta heybetleri bile kaotik bulunmuş, hor görülmüştür."
        }

        armor("evening_ghost", name = "Alacakaranlık Hayaleti") {
            leggings = "Alacakaranlık Hayaleti Pantolonu"
            description = "§7Gecenin içinde gizlenen gölge, yerini bilir.\nAdımları sessizdir; fakat varlığının soğuğu teninde hissedilir."
        }

        armor("ronin", name = "Ronin") {
            leggings = "Ronin Pantolonu"
            description = "§7Çelik geçmişin izlerini taşır; üzerindeki desenler, çoktan soğumuş kanla lekelenmiştir."
        }

        armor("malenia", name = "Malenia") {
            leggings = "Malenia Pantolonu"
            description = "§7...Sözlerime kulak ver. Ben Malenia. Miquella'nın Kılıcı. Ve yenilgiyi asla tatmadım."
        }

        armor("old_knight", name = "Kadim Şövalye") {
            description = "§7Sayısız savaştan sağ çıkan bir şövalyenin bir zamanlar kuşandığı zırh.\nZayıf olanlar için ağırlığı dayanılmazdır; ancak yükünü taşıyabilenler asla yere serilmez."
        }

        armor("silver_knight", name = "Gümüş Şövalye") {
            description = "§7Savaşta asla sendelememiş seçkin bir savaşçının zırhı.\nGümüşten parıltısı ay ışığını yansıtır; sahibine karşı koymaya cüret edenleri kaçınılmaz bir ölüm bekler."
        }

        armor("dead_gladiator", name = "Ölü Gladyatör") {
            description = "§7Arenada düşen bir kölenin zırhı.\nAdı unutulmuş olsa da çeliğin altında hâlâ bir öfke yanmaktadır."
        }

        armor("flesh_of_the_feaster", name = "Yutucunun Eti") {
            leggings = "Yutucunun Eti Pantolonu"
            description = "§7Bu zırh kan ve açgözlülük kokar.\nBir zamanlar durmaksızın beslenen birine aitti — ta ki yediği şeye dönüşene dek."
        }

        armor("wind_worshipper", name = "Rüzgâr Müridi") {
            leggings = "Rüzgâr Müridi Pantolonu"
            description = "§7Kumaşı nefes kadar hafiftir.\nHuzur nedir bilmeyenlerin giydiği bu kumaş, rüzgârın götürdüğü her yere savrulur."
        }

        armor("grave_sentinel", name = "Mezarlık Muhafızı") {
            description = "§7Ölülerin ebedi uykusuna bekçilik eden zırh. Zamanında şanlı yeminlerle adanmış bu vazife, yıllar içinde tozun ve sükûtun arasında sessiz bir nöbete evrildi."
        }

        armor("ornstein", name = "Ornstein") {
            leggings = "Ornstein Pantolonu"
            description = "§7Aslan suretinde şekillendirilmiş altın levhalar.\nİlk Lord’un en azılı ejderha avcısı için dövülen bu zırh, geride kalan yıldırımın gücüyle hâlâ titreşiyor.\nSetin tamamını kuşananlar, kadim taş pulları bile delip geçebilen bir mızrak darbesinin yankısını hisseder."
        }

        armor("dawncrest", name = "Şafak Arması") {
            description = "§7En uzun gece boyunca nöbet tutan muhafızlar için dövülen bu zırh, doğan güneşin armasını taşır.\nSolmuş altını, sessiz bir savaş alanına düşen ilk ışığı hatırlar.\nOnu kuşananlar bir söz taşır: Karanlık ne kadar derin olursa olsun, şafak sökecektir."
        }
    }

    language("ko_kr") {
        armorNames(
            helmet = "{name}의 투구",
            chestplate = "{name}의 흉갑",
            leggings = "{name}의 각반",
            boots = "{name}의 장화",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "Fantasy Armor")
        entry("item.${mod.id}.${moonCrystal.id}", "달의 수정")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "달빛을 품은 결정. 고대 갑옷의 힘을 깨운다.")

        armor("eclipse_soldier", name = "일식 병사") {
            description = "§7오래전 태양을 누르고 일식의 승리를 이루기 위해 싸웠던 보병의 갑옷.\n군단의 군홧발 아래 수천 명의 불운한 이들이 죽음을 맞았다고 한다."
        }

        armor("golden_horns", name = "황금 뿔") {
            description = "§7빛 그 자체를 깎아 만든 듯 눈부시게 빛나는 갑옷.\n그러나 그 황금은 축복이 아닌 저주다.\n죽음과 파괴를 목격한 황금의 빛은 탐욕과 살육의 갈망을 키운다.\n이 갑옷은 주인이 적들을 제물로 바칠 의지가 있는 동안에만 그를 섬긴다."
        }

        armor("dragonslayer", name = "용 사냥꾼") {
            description = "§7쓰러뜨린 용들의 비늘로 벼려낸 갑옷. 비늘 하나하나가 고대의 힘과 분노를 상징한다.\n철판과 가시는 용에게 거둔 승리의 힘을 부여한다. 하지만 이 갑옷을 입고 내딛는 걸음마다 수많은 죽음의 무게가 실려 있음을 잊지 마라."
        }

        armor("hero", name = "영웅") {
            description = "§7마지막 숨을 거둘 때까지 싸웠던 고대 전사들의 유산.\n정의를 찾아 나서며 겪은 수많은 전투와 고난의 기억이 깃들어 있다.\n그러나 영광은 무거운 짐이다.\n모든 이야기가 세월을 넘어 전해지는 것은 아니다."
        }

        armor("thief", name = "도둑") {
            description = "§7그림자 속에 살며 어둠을 호흡하는 이들에게 더없이 좋은 동반자.\n착용자는 밤과 하나가 된다.\n검은 가면이 얼굴을 가려 적들이 그 정체를 알 수 없게 한다."
        }

        armor("wandering_wizard", name = "방랑 마법사") {
            description = "§7고대의 마법이 스며든 의복.\n옷자락은 잊힌 주문을 속삭이며 다른 세계로 통하는 문을 연다.\n실 한 올 한 올이 착용자를 알 수 없는 힘에 묶어 마법을 부리는 능력을 주지만, 동시에 쉴 수 없는 영원한 방랑의 저주를 내린다."
        }

        armor("sunset_wings", name = "석양의 날개") {
            description = "§7석양은 끝인 동시에 시작이다.\n날개는 주인을 어둠 속에서 인도한다.\n이를 걸치면 영원한 밤의 침울한 전령이 된다."
        }

        armor("chess_board_knight", name = "체스판 기사") {
            description = "§7모든 수는 전투이며, 모든 발걸음은 전략이다.\n이 갑옷은 전쟁의 냉혹한 논리와 무자비한 힘을 구현한다.\n전략가의 긍지로 입어라. 승리를 위해서는 영혼마저 바칠 각오를 해야 한다."
        }

        armor("dark_lord", name = "어둠의 군주") {
            description = "§7다른 세계의 깊은 곳에서 만들어진, 공포의 힘을 구현한 갑옷.\n가시와 검은 갑주는 부러진 송곳니를 닮았다.\n용기가 있다면 입어라. 그러나 어둠에 대한 영원한 충성을 요구하며, 저항하는 자들을 집어삼킨다는 것을 알아야 한다."
        }

        armor("fog_guard", name = "안개 파수꾼") {
            description = "§7고대의 안개에 싸인 이 갑옷은 비할 데 없는 보호를 제공하지만, 사라진 왕국의 환영으로 착용자를 쇠약하게 만든다."
        }

        armor("dark_cover", name = "어둠의 장막") {
            description = "§7착용자를 그림자로 감싸 빛으로부터 보호하고 고요함을 부여하는 갑옷. 그러나 어둠의 세력이 품은 잊힌 비밀을 속삭인다.\n입되, 그림자의 경고에 귀를 기울여라."
        }

        armor("spark_of_dawn", name = "새벽의 불꽃") {
            description = "§7첫 빛 속에서 벼려져 온기와 광채를 품은 갑옷. 그러나 마음이 순수하지 않은 자는 불태운다.\n오직 의로운 자만이 그 진정한 힘을 일깨울 수 있다."
        }

        armor("golden_execution", name = "황금 처형") {
            description = "§7제국의 분노를 짊어진 이 갑옷은 황금빛으로 빛나지만, 쓰러진 이들의 피에 젖어 있다.\n긍지를 품고 입되, 그 대가를 결코 잊지 마라."
        }

        armor("forgotten_trace", name = "잊힌 흔적") {
            description = "§7고대 전쟁의 기억이 깃든 갑옷. 오래전 사라진 전투의 메아리가 착용자를 따라다닌다.\n한번 입으면 다른 시대에서 온 영혼이라는 낙인이 찍힌다."
        }

        armor("redeemer", name = "구원자") {
            description = "§7옛 기사단이 만든 갑옷.\n네 신은 오래전에 살해되었으나, 신앙은 살아남았다.\n여정에서 돌아오지 못할 가능성을 알면서도, 너는 미지의 세계로 용감히 발을 내딛는다."
        }

        armor("twinned", name = "쌍둥이") {
            description = "§7영혼으로 다른 존재와 이어진 이 갑옷은 쌍둥이와 고통과 승리를 함께 나눈다.\n한 벌을 모두 갖춰 입는 자에게는 공동의 운명이 기다린다."
        }

        armor("gilded_hunt", name = "황금빛 사냥") {
            description = "§7명예와 영광을 좇는 이들이 입는 갑옷. 주인의 길들여지지 않은 야망을 비춘다.\n이를 입고 사냥하되 조심하라. 영광에는 흔히 값비싼 대가가 따른다."
        }

        armor("lady_maria", name = "레이디 마리아") {
            description = "§7시체는… 그대로 내버려 두어야 하는 법.\n아, 잘 알고 있지. 비밀이 얼마나 달콤하게 유혹하는지.\n이제 너를 치유할 것은 오직 정직한 죽음뿐.\n네 걷잡을 수 없는 호기심에서 해방해 주리라."
        }

        armor("crucible_knight", name = "도가니 기사") {
            description = "§7생명의 도가니가 지닌 힘을 품고 있다.\n시간이 흐르면서 이 기사들이 보인 힘은 물론 그 모습마저 혼돈의 산물로 여겨져 경멸받게 되었다."
        }

        armor("evening_ghost", name = "저녁의 망령") {
            description = "§7밤에 숨은 그림자는 자신의 자리를 안다.\n그 발걸음은 소리 없지만, 존재가 풍기는 냉기는 피부로 느껴진다."
        }

        armor("ronin", name = "낭인") {
            description = "§7강철에는 과거의 상처가 남아 있고, 그 무늬에는 오래전에 식어 버린 피가 배어 있다."
        }

        armor("malenia", name = "말레니아") {
            description = "§7…내 말을 새겨들어라. 나는 말레니아. 미켈라의 칼날. 그리고 나는 패배를 모른다."
        }

        armor("old_knight", name = "옛 기사") {
            description = "§7수많은 전투에서 살아남은 기사가 한때 입었던 갑옷.\n나약한 자는 그 무게를 견딜 수 없으나, 이를 감당하는 자는 결코 쓰러지지 않는다."
        }

        armor("silver_knight", name = "은빛 기사") {
            description = "§7전장에서 한 번도 흔들리지 않았던 정예 전사의 갑옷.\n은빛 광채는 달빛을 비추며, 주인에게 맞서는 자에게 신속한 죽음을 선사한다."
        }

        armor("dead_gladiator", name = "죽은 검투사") {
            description = "§7투기장에서 쓰러진 노예의 갑옷.\n그 이름은 잊혔지만, 강철 아래에서는 여전히 분노가 타오른다."
        }

        armor("flesh_of_the_feaster", name = "포식자의 살점") {
            description = "§7피와 탐욕의 악취가 풍기는 갑옷.\n끝없이 먹어 치우던 자의 것이었으나, 그는 결국 자신이 먹은 것과 같은 존재가 되었다."
        }

        armor("wind_worshipper", name = "바람 숭배자") {
            description = "§7숨결처럼 가벼운 천으로 지은 의복.\n쉼을 모르는 이들이 입고, 바람이 이끄는 곳이면 어디든 떠돈다."
        }

        armor("grave_sentinel", name = "묘지 파수꾼") {
            description = "§7죽은 이들의 잠을 지키는 갑옷.\n한때 고결한 맹세로 다짐했던 의무는 세월 속에 뒤틀려, 먼지와 정적 사이에서 이어지는 말없는 경계가 되었다."
        }

        armor("ornstein", name = "오른슈타인") {
            description = "§7사자의 형상을 본뜬 황금 갑주.\n최초의 군주를 섬긴 가장 맹렬한 용 사냥꾼을 위해 벼려졌으며, 남아 있는 번개의 힘으로 지금도 낮게 울린다.\n한 벌을 모두 갖춰 입으면 고대의 돌비늘마저 꿰뚫을 창격의 메아리를 느낄 수 있다."
        }

        armor("dawncrest", name = "새벽 문장") {
            description = "§7가장 긴 밤을 지새우며 경계하던 파수꾼들을 위해 벼려진 갑옷. 떠오르는 태양의 문장이 새겨져 있다.\n빛바랜 황금은 고요한 전장 위로 비치던 첫 햇살을 기억한다.\n이를 입는 자는 하나의 약속을 품는다. 어둠이 아무리 깊어도 새벽은 찾아온다는 것을."
        }
    }

    language("es_es") {
        armorNames(
            helmet = "Casco {name}",
            chestplate = "Peto {name}",
            leggings = "Grebas {name}",
            boots = "Botas {name}",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "Fantasy Armor")
        entry("item.${mod.id}.${moonCrystal.id}", "Cristal Lunar")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "Luz de luna encerrada en un cristal. Despierta el poder de las armaduras antiguas.")

        armor("eclipse_soldier", name = "del Soldado del Eclipse") {
            description = "§7La armadura de un infante que luchó hace mucho por el triunfo del eclipse sobre el sol.\nSe dice que miles de desdichados encontraron la muerte bajo las botas de las legiones."
        }

        armor("golden_horns", name = "de los Cuernos Dorados") {
            description = "§7Una armadura tan resplandeciente que parece tallada en la propia luz.\nSin embargo, su oro no es una bendición, sino una maldición.\nHa presenciado muerte y destrucción, y su luz alimenta la codicia y la sed de sangre.\nSolo sirve a su dueño mientras esté dispuesto a sacrificar a sus enemigos."
        }

        armor("dragonslayer", name = "del Matadragones") {
            description = "§7Forjada con las escamas de dragones vencidos, cada una símbolo de fuerza y furia ancestrales.\nSus placas y púas te otorgan el poder de la victoria sobre ellos, pero recuerda que cada paso bajo esta armadura carga con el peso de muchas muertes."
        }

        armor("hero", name = "del Héroe") {
            description = "§7El legado de antiguos guerreros que lucharon hasta su último aliento.\nGuarda el recuerdo de innumerables batallas y penurias soportadas en busca de justicia.\nPero la gloria es una carga pesada.\nNo todas las historias perduran a través de los siglos."
        }

        armor("thief", name = "del Ladrón") {
            description = "§7La compañera perfecta de quienes viven entre sombras y respiran oscuridad.\nQuien la lleva se funde con la noche.\nLa máscara negra oculta tu rostro y deja a tus enemigos en la incertidumbre."
        }

        armor("wandering_wizard", name = "del Mago Errante") {
            description = "§7Estas prendas están imbuidas de magia antigua.\nSusurran hechizos olvidados y abren puertas a otros mundos.\nCada hilo vincula a su portador con fuerzas desconocidas, otorgándole el poder de hacer magia y, a la vez, la maldición de vagar eternamente sin descanso."
        }

        armor("sunset_wings", name = "de las Alas del Ocaso") {
            description = "§7El ocaso es a la vez un final y un comienzo.\nLas alas guían a su dueño a través de la oscuridad.\nAl vestirlas, te conviertes en el sombrío mensajero de la noche eterna."
        }

        armor("chess_board_knight", name = "del Caballero del Tablero") {
            description = "§7Cada movimiento es una batalla; cada paso, una estrategia.\nEsta armadura encarna la fría lógica y el poder despiadado de la guerra.\nVístela con el orgullo de un estratega, dispuesto a sacrificarlo todo por la victoria, incluso tu alma."
        }

        armor("dark_lord", name = "del Señor Oscuro") {
            description = "§7Creada en las profundidades de otro mundo, esta armadura encarna el poder del terror.\nSus púas y placas negras recuerdan a colmillos rotos.\nVístela si te atreves, pero recuerda que exige devoción eterna a la oscuridad y devora a quienes intentan resistirse."
        }

        armor("fog_guard", name = "del Guardián de la Niebla") {
            description = "§7Envuelta en niebla ancestral, esta armadura ofrece una protección inigualable, pero debilita a su portador con visiones de reinos perdidos."
        }

        armor("dark_cover", name = "del Manto Oscuro") {
            description = "§7Esta armadura envuelve a su portador en sombras, lo protege de la luz y le concede silencio, pero susurra secretos olvidados de fuerzas oscuras.\nVístela, pero escucha las advertencias de las sombras."
        }

        armor("spark_of_dawn", name = "de la Chispa del Alba") {
            description = "§7Forjada en la primera luz, esta armadura alberga calor y claridad, pero quema a quienes no son puros de corazón.\nSolo los justos pueden despertar su verdadero poder."
        }

        armor("golden_execution", name = "de la Ejecución Dorada") {
            description = "§7Esta armadura soporta el peso de la ira del imperio y brilla como el oro, pero está empapada en la sangre de los caídos.\nVístela con orgullo, sin olvidar jamás su precio."
        }

        armor("forgotten_trace", name = "de la Huella Olvidada") {
            description = "§7El recuerdo de antiguas guerras perdura en esta armadura y acosa a su portador con ecos de batallas olvidadas.\nAl vestirla, queda marcado como un alma de otra era."
        }

        armor("redeemer", name = "del Redentor") {
            description = "§7Una armadura creada por la antigua orden.\nTu dios fue asesinado hace mucho, pero tu fe ha perdurado.\nAun sabiendo que probablemente no regresarás de tu misión, avanzas con valentía hacia lo desconocido."
        }

        armor("twinned", name = "de los Gemelos") {
            description = "§7Unida en espíritu a otro ser, esta armadura comparte el dolor y el triunfo con su gemela.\nUn destino común aguarda a quienes visten el conjunto completo."
        }

        armor("gilded_hunt", name = "de la Cacería Dorada") {
            description = "§7Vestida por quienes persiguen el honor y la gloria, esta armadura refleja la ambición indómita de su portador.\nCaza con ella, pero recuerda: la gloria suele exigir un alto precio."
        }

        armor("lady_maria", name = "de Lady Maria") {
            description = "§7Un cadáver… debería dejarse en paz.\nAh, lo sé muy bien. Con qué dulzura llaman los secretos.\nAhora solo una muerte honesta puede curarte.\nLiberarte de tu desenfrenada curiosidad."
        }

        armor("crucible_knight", name = "del Caballero del Crisol") {
            description = "§7Alberga el poder del crisol de la vida.\nCon el tiempo, la fuerza de estos caballeros, e incluso su aspecto, llegaron a considerarse caóticos y dignos de desprecio."
        }

        armor("evening_ghost", name = "del Fantasma del Anochecer") {
            description = "§7Oculta en la noche, la sombra conoce su lugar.\nSus pasos son silenciosos, pero el frío de su presencia se siente en la piel."
        }

        armor("ronin", name = "del Ronin") {
            description = "§7El acero lleva las cicatrices del pasado; sus dibujos están impregnados de sangre enfriada hace mucho."
        }

        armor("malenia", name = "de Malenia") {
            description = "§7…Escucha mis palabras. Soy Malenia. La Espada de Miquella. Y jamás he conocido la derrota."
        }

        armor("old_knight", name = "del Viejo Caballero") {
            description = "§7Una armadura que perteneció a un caballero que sobrevivió a innumerables batallas.\nSu peso es insoportable para los débiles, pero quienes lo soporten jamás caerán."
        }

        armor("silver_knight", name = "del Caballero Plateado") {
            description = "§7La armadura de un guerrero de élite que nunca flaqueó en combate.\nSu brillo plateado refleja la luz de la luna y trae una muerte rápida a quienes osan enfrentarse a su dueño."
        }

        armor("dead_gladiator", name = "del Gladiador Muerto") {
            description = "§7La armadura de un esclavo caído en la arena.\nSu nombre ha sido olvidado, pero la furia aún arde bajo el acero."
        }

        armor("flesh_of_the_feaster", name = "de la Carne del Devorador") {
            description = "§7Esta armadura apesta a sangre y codicia.\nPerteneció a alguien que comía sin cesar, hasta convertirse en aquello que consumía."
        }

        armor("wind_worshipper", name = "del Adorador del Viento") {
            description = "§7Una tela tan ligera como el aliento.\nLa visten quienes no conocen el descanso y vagan adonde los lleve el viento."
        }

        armor("grave_sentinel", name = "del Centinela del Cementerio") {
            description = "§7La armadura que vela el sueño de los muertos.\nAntaño ligada a nobles juramentos, su deber se deformó con los años hasta convertirse en una vigilia muda entre polvo y silencio."
        }

        armor("ornstein", name = "de Ornstein") {
            description = "§7Placas doradas con la forma de un león.\nForjada para el más feroz matadragones del Primer Señor, esta armadura aún vibra con vestigios del rayo.\nQuienes visten el conjunto completo sienten el eco de una estocada capaz de atravesar antiguas escamas de piedra."
        }

        armor("dawncrest", name = "del Emblema del Alba") {
            description = "§7Forjada para los centinelas que velaron durante la noche más larga, esta armadura lleva el emblema del sol naciente.\nSu oro deslucido recuerda la primera luz sobre un campo de batalla en silencio.\nQuienes la visten llevan consigo una promesa: por profunda que sea la oscuridad, llegará el alba."
        }
    }

    language("pt_br") {
        armorNames(
            helmet = "Elmo {name}",
            chestplate = "Peitoral {name}",
            leggings = "Perneiras {name}",
            boots = "Botas {name}",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "Fantasy Armor")
        entry("item.${mod.id}.${moonCrystal.id}", "Cristal Lunar")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "Luar aprisionado em um cristal. Desperta o poder de armaduras antigas.")

        armor("eclipse_soldier", name = "do Soldado do Eclipse") {
            description = "§7A armadura de um soldado de infantaria que lutou, há muito tempo, pelo triunfo do eclipse sobre o sol.\nDizem que milhares de desafortunados encontraram a morte sob as botas das legiões."
        }

        armor("golden_horns", name = "dos Chifres Dourados") {
            description = "§7Uma armadura tão resplandecente que parece esculpida na própria luz.\nSeu ouro, porém, não é uma bênção, mas uma maldição.\nEle testemunhou morte e destruição, e sua luz alimenta a ganância e a sede de sangue.\nEsta armadura só serve ao dono enquanto ele estiver disposto a sacrificar seus inimigos."
        }

        armor("dragonslayer", name = "do Matador de Dragões") {
            description = "§7Forjada com escamas de dragões derrotados, cada uma símbolo de força e fúria ancestrais.\nSuas placas e espinhos concedem o poder da vitória sobre eles, mas lembre-se: cada passo com esta armadura carrega o peso de muitas mortes."
        }

        armor("hero", name = "do Herói") {
            description = "§7O legado de antigos guerreiros que lutaram até o último suspiro.\nGuarda a memória de incontáveis batalhas e provações enfrentadas em busca de justiça.\nMas a glória é um fardo pesado.\nNem toda história atravessa as eras."
        }

        armor("thief", name = "do Ladrão") {
            description = "§7A companheira perfeita de quem vive nas sombras e respira a escuridão.\nQuem a veste se torna um com a noite.\nA máscara negra esconde seu rosto, deixando seus inimigos na dúvida."
        }

        armor("wandering_wizard", name = "do Mago Errante") {
            description = "§7Estas vestes estão imbuídas de magia antiga.\nElas sussurram feitiços esquecidos e abrem portais para outros mundos.\nCada fio liga seu portador a forças desconhecidas, concedendo o poder de realizar magia e, ao mesmo tempo, a maldição de vagar eternamente sem descanso."
        }

        armor("sunset_wings", name = "das Asas do Poente") {
            description = "§7O poente é, ao mesmo tempo, fim e começo.\nAs asas guiam seu dono pela escuridão.\nAo vesti-las, você se torna o mensageiro sombrio da noite eterna."
        }

        armor("chess_board_knight", name = "do Cavaleiro do Tabuleiro") {
            description = "§7Cada movimento é uma batalha; cada passo, uma estratégia.\nEsta armadura incorpora a lógica fria e o poder implacável da guerra.\nVista-a com o orgulho de um estrategista, pronto para sacrificar tudo pela vitória, até mesmo sua alma."
        }

        armor("dark_lord", name = "do Senhor das Trevas") {
            description = "§7Criada nas profundezas de outro mundo, esta armadura incorpora o poder do terror.\nSeus espinhos e placas negras lembram presas quebradas.\nVista-a se tiver coragem, mas saiba que ela exige devoção eterna às trevas e devora quem tenta resistir."
        }

        armor("fog_guard", name = "do Guardião da Névoa") {
            description = "§7Envolta em uma névoa ancestral, esta armadura oferece proteção inigualável, mas enfraquece seu portador com visões de reinos perdidos."
        }

        armor("dark_cover", name = "do Manto Sombrio") {
            description = "§7Esta armadura envolve seu portador em sombras, protege-o da luz e lhe concede silêncio, mas sussurra segredos esquecidos de forças obscuras.\nVista-a, mas ouça os avisos das sombras."
        }

        armor("spark_of_dawn", name = "da Centelha da Aurora") {
            description = "§7Forjada na primeira luz, esta armadura traz calor e claridade, mas queima quem não tem o coração puro.\nSomente os justos podem despertar seu verdadeiro poder."
        }

        armor("golden_execution", name = "da Execução Dourada") {
            description = "§7Carregando o peso da ira do império, esta armadura brilha como ouro, mas está encharcada com o sangue dos caídos.\nVista-a com orgulho, mas jamais esqueça seu preço."
        }

        armor("forgotten_trace", name = "do Vestígio Esquecido") {
            description = "§7A memória de guerras antigas permanece nesta armadura, assombrando seu portador com ecos de batalhas há muito esquecidas.\nAo vesti-la, ele é marcado como uma alma de outra era."
        }

        armor("redeemer", name = "do Redentor") {
            description = "§7Uma armadura criada pela antiga ordem.\nSeu deus foi morto há muito tempo, mas sua fé resistiu.\nMesmo sabendo que provavelmente não voltará de sua missão, você avança com coragem rumo ao desconhecido."
        }

        armor("twinned", name = "dos Gêmeos") {
            description = "§7Ligada em espírito a outro ser, esta armadura compartilha a dor e o triunfo com sua gêmea.\nUm destino comum aguarda quem veste o conjunto completo."
        }

        armor("gilded_hunt", name = "da Caçada Dourada") {
            description = "§7Usada por quem busca honra e glória, esta armadura reflete a ambição indomável de seu portador.\nCace com ela, mas cuidado: a glória costuma cobrar um preço alto."
        }

        armor("lady_maria", name = "de Lady Maria") {
            description = "§7Um cadáver… deve ser deixado em paz.\nAh, eu sei muito bem. Como os segredos chamam de forma tão doce.\nAgora, só uma morte honesta pode curar você.\nLibertar você dessa curiosidade desenfreada."
        }

        armor("crucible_knight", name = "do Cavaleiro do Crisol") {
            description = "§7Abriga o poder do crisol da vida.\nCom o tempo, a força desses cavaleiros, e até sua aparência, passou a ser vista como caótica e digna de desprezo."
        }

        armor("evening_ghost", name = "do Fantasma do Anoitecer") {
            description = "§7Oculta na noite, a sombra conhece seu lugar.\nSeus passos são silenciosos, mas o frio de sua presença é sentido na pele."
        }

        armor("ronin", name = "do Ronin") {
            description = "§7O aço carrega as cicatrizes do passado; seus padrões estão impregnados de sangue há muito resfriado."
        }

        armor("malenia", name = "de Malenia") {
            description = "§7…Ouça minhas palavras. Sou Malenia. A Lâmina de Miquella. E nunca conheci a derrota."
        }

        armor("old_knight", name = "do Velho Cavaleiro") {
            description = "§7Uma armadura que pertenceu a um cavaleiro que sobreviveu a incontáveis batalhas.\nSeu peso é insuportável para os fracos, mas quem o suporta jamais cairá."
        }

        armor("silver_knight", name = "do Cavaleiro Prateado") {
            description = "§7A armadura de um guerreiro de elite que jamais vacilou em batalha.\nSeu brilho prateado reflete o luar e traz morte rápida a quem ousa enfrentar seu dono."
        }

        armor("dead_gladiator", name = "do Gladiador Morto") {
            description = "§7A armadura de um escravo que tombou na arena.\nSeu nome foi esquecido, mas a fúria ainda arde sob o aço."
        }

        armor("flesh_of_the_feaster", name = "da Carne do Devorador") {
            description = "§7Esta armadura fede a sangue e ganância.\nPertenceu a alguém que se alimentava sem parar, até se tornar aquilo que consumia."
        }

        armor("wind_worshipper", name = "do Adorador do Vento") {
            description = "§7Um tecido leve como o sopro.\nUsado por quem não conhece descanso e vagueia para onde o vento levar."
        }

        armor("grave_sentinel", name = "da Sentinela do Cemitério") {
            description = "§7A armadura que guarda o sono dos mortos.\nAntes ligada a nobres juramentos, sua missão se distorceu com o tempo, tornando-se uma vigília muda em meio à poeira e ao silêncio."
        }

        armor("ornstein", name = "de Ornstein") {
            description = "§7Placas douradas moldadas à imagem de um leão.\nForjada para o mais feroz matador de dragões do Primeiro Senhor, esta armadura ainda vibra com resquícios de relâmpagos.\nQuem veste o conjunto completo sente o eco de uma estocada capaz de perfurar antigas escamas de pedra."
        }

        armor("dawncrest", name = "do Brasão da Aurora") {
            description = "§7Forjada para os sentinelas que vigiaram durante a noite mais longa, esta armadura ostenta o brasão do sol nascente.\nSeu ouro desbotado lembra a primeira luz sobre um campo de batalha silencioso.\nQuem a veste carrega uma promessa: por mais profunda que seja a escuridão, a aurora chegará."
        }
    }

    language("de_de") {
        armorNames(
            helmet = "Helm {name}",
            chestplate = "Brustpanzer {name}",
            leggings = "Beinschutz {name}",
            boots = "Stiefel {name}",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "Fantasy Armor")
        entry("item.${mod.id}.${moonCrystal.id}", "Mondkristall")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "Mondlicht, eingeschlossen in einem Kristall. Erweckt die Macht uralter Rüstungen.")

        armor("eclipse_soldier", name = "des Eklipsensoldaten") {
            description = "§7Die Rüstung eines Fußsoldaten, der vor langer Zeit für den Sieg der Finsternis über die Sonne kämpfte.\nMan sagt, unter den Stiefeln der Legionen hätten Tausende Unglückliche den Tod gefunden."
        }

        armor("golden_horns", name = "der Goldenen Hörner") {
            description = "§7Eine Rüstung, die so hell strahlt, als wäre sie aus dem Licht selbst gemeißelt.\nDoch ihr Gold ist kein Segen, sondern ein Fluch.\nEs hat Tod und Zerstörung gesehen, und sein Licht nährt Gier und Blutdurst.\nDiese Rüstung dient ihrem Träger nur, solange er bereit ist, seine Feinde zu opfern."
        }

        armor("dragonslayer", name = "des Drachentöters") {
            description = "§7Aus den Schuppen bezwungener Drachen geschmiedet, jede ein Sinnbild uralter Stärke und Wut.\nDie Platten und Stacheln verleihen dir die Macht des Sieges über sie. Vergiss jedoch nicht, dass jeder Schritt in dieser Rüstung das Gewicht vieler Tode trägt."
        }

        armor("hero", name = "des Helden") {
            description = "§7Das Erbe uralter Krieger, die bis zum letzten Atemzug kämpften.\nSie bewahrt die Erinnerung an zahllose Schlachten und Entbehrungen auf der Suche nach Gerechtigkeit.\nDoch Ruhm ist eine schwere Last.\nNicht jede Geschichte überdauert die Zeiten."
        }

        armor("thief", name = "des Diebes") {
            description = "§7Der vollkommene Begleiter für jene, die in Schatten leben und Dunkelheit atmen.\nIhr Träger wird eins mit der Nacht.\nDie schwarze Maske verbirgt dein Gesicht und lässt deine Feinde im Ungewissen."
        }

        armor("wandering_wizard", name = "des Wandernden Magiers") {
            description = "§7Diese Gewänder sind von uralter Magie durchdrungen.\nSie flüstern vergessene Zauber und öffnen Tore zu anderen Welten.\nJeder Faden bindet den Träger an unbekannte Mächte und verleiht ihm die Gabe zu zaubern, aber auch den Fluch ewiger Wanderschaft ohne Rast."
        }

        armor("sunset_wings", name = "der Abendrotschwingen") {
            description = "§7Der Sonnenuntergang ist Ende und Anfang zugleich.\nDie Schwingen führen ihren Träger durch die Dunkelheit.\nWer sie anlegt, wird zum düsteren Boten der ewigen Nacht."
        }

        armor("chess_board_knight", name = "des Schachbrettritters") {
            description = "§7Jeder Zug ist eine Schlacht, jeder Schritt eine Strategie.\nDiese Rüstung verkörpert die kalte Logik und rücksichtslose Macht des Krieges.\nTrage sie mit dem Stolz eines Strategen, bereit, für den Sieg alles zu opfern, selbst deine Seele."
        }

        armor("dark_lord", name = "des Dunklen Fürsten") {
            description = "§7In den Tiefen einer anderen Welt erschaffen, verkörpert diese Rüstung die Macht des Schreckens.\nIhre Stacheln und schwarzen Platten gleichen zerbrochenen Fangzähnen.\nTrage sie, wenn du es wagst. Doch wisse, dass sie ewige Treue zur Dunkelheit fordert und jene verschlingt, die ihr widerstehen wollen."
        }

        armor("fog_guard", name = "des Nebelwächters") {
            description = "§7Von uraltem Nebel umhüllt, gewährt diese Rüstung unvergleichlichen Schutz, schwächt ihren Träger jedoch mit Visionen verlorener Reiche."
        }

        armor("dark_cover", name = "des Dunklen Schleiers") {
            description = "§7Diese Rüstung hüllt ihren Träger in Schatten, schützt ihn vor Licht und schenkt ihm Stille, flüstert jedoch vergessene Geheimnisse dunkler Mächte.\nTrage sie, aber höre auf die Warnungen der Schatten."
        }

        armor("spark_of_dawn", name = "des Morgenfunkens") {
            description = "§7Im ersten Licht geschmiedet, birgt diese Rüstung Wärme und Helligkeit, verbrennt jedoch jene, deren Herz nicht rein ist.\nNur die Rechtschaffenen können ihre wahre Macht erwecken."
        }

        armor("golden_execution", name = "der Goldenen Hinrichtung") {
            description = "§7Diese Rüstung trägt die Last des kaiserlichen Zorns. Sie glänzt golden, ist aber vom Blut der Gefallenen getränkt.\nTrage sie mit Stolz, doch vergiss niemals ihren Preis."
        }

        armor("forgotten_trace", name = "der Vergessenen Spur") {
            description = "§7Die Erinnerung an uralte Kriege verweilt in dieser Rüstung und verfolgt ihren Träger mit dem Echo längst vergangener Schlachten.\nWer sie anlegt, trägt das Mal einer Seele aus einem anderen Zeitalter."
        }

        armor("redeemer", name = "des Erlösers") {
            description = "§7Eine Rüstung, geschaffen vom alten Orden.\nDein Gott wurde vor langer Zeit erschlagen, doch dein Glaube blieb bestehen.\nObwohl du weißt, dass du von deiner Suche wohl nicht zurückkehren wirst, schreitest du mutig ins Unbekannte."
        }

        armor("twinned", name = "der Zwillinge") {
            description = "§7Im Geist mit einem anderen verbunden, teilt diese Rüstung Schmerz und Triumph mit ihrem Zwilling.\nWer das vollständige Set trägt, den erwartet ein gemeinsames Schicksal."
        }

        armor("gilded_hunt", name = "der Vergoldeten Jagd") {
            description = "§7Diese Rüstung wird von jenen getragen, die Ehre und Ruhm suchen, und spiegelt den ungezügelten Ehrgeiz ihres Trägers wider.\nJage mit ihr, doch sei gewarnt: Ruhm hat oft einen hohen Preis."
        }

        armor("lady_maria", name = "von Lady Maria") {
            description = "§7Eine Leiche … sollte man in Frieden lassen.\nOh, ich weiß nur zu gut, wie süß Geheimnisse locken.\nNur ein ehrlicher Tod kann dich jetzt noch heilen.\nDich von deiner ungezügelten Neugier befreien."
        }

        armor("crucible_knight", name = "des Schmelztiegelritters") {
            description = "§7Sie birgt die Macht des Schmelztiegels des Lebens.\nMit der Zeit galten die Stärke dieser Ritter und sogar ihr Aussehen als chaotisch und verachtenswert."
        }

        armor("evening_ghost", name = "des Abendgeistes") {
            description = "§7In der Nacht verborgen, kennt der Schatten seinen Platz.\nSeine Schritte sind lautlos, doch die Kälte seiner Gegenwart ist auf der Haut zu spüren."
        }

        armor("ronin", name = "des Ronin") {
            description = "§7Der Stahl trägt die Narben der Vergangenheit; seine Muster sind von längst erkaltetem Blut durchtränkt."
        }

        armor("malenia", name = "von Malenia") {
            description = "§7…Höre meine Worte. Ich bin Malenia. Miquellas Klinge. Und ich habe noch nie eine Niederlage erfahren."
        }

        armor("old_knight", name = "des Alten Ritters") {
            description = "§7Die Rüstung eines Ritters, der zahllose Schlachten überlebte.\nIhr Gewicht ist für die Schwachen unerträglich, doch wer es erträgt, wird niemals fallen."
        }

        armor("silver_knight", name = "des Silberritters") {
            description = "§7Die Rüstung eines Elitekriegers, der im Kampf niemals wankte.\nIhr silberner Glanz spiegelt das Mondlicht wider und bringt jenen den raschen Tod, die sich ihrem Träger entgegenstellen."
        }

        armor("dead_gladiator", name = "des Toten Gladiators") {
            description = "§7Die Rüstung eines Sklaven, der in der Arena fiel.\nSein Name ist vergessen, doch unter dem Stahl brennt noch immer Zorn."
        }

        armor("flesh_of_the_feaster", name = "des Fleisches des Verschlingers") {
            description = "§7Diese Rüstung stinkt nach Blut und Gier.\nSie gehörte einst jemandem, der unablässig fraß, bis er zu dem wurde, was er verschlang."
        }

        armor("wind_worshipper", name = "des Windanbeters") {
            description = "§7Der Stoff ist leicht wie ein Atemzug.\nEr wird von Rastlosen getragen, die dorthin ziehen, wohin der Wind sie trägt."
        }

        armor("grave_sentinel", name = "des Grabwächters") {
            description = "§7Eine Rüstung, die den Schlaf der Toten bewacht.\nEinst edlen Eiden verpflichtet, wandelte sich ihre Pflicht mit der Zeit zu einer stummen Wache zwischen Staub und Stille."
        }

        armor("ornstein", name = "von Ornstein") {
            description = "§7Goldene Platten in der Gestalt eines Löwen.\nFür den wildesten Drachentöter des Ersten Fürsten geschmiedet, summt diese Rüstung noch immer von verbliebener Blitzkraft.\nWer das vollständige Set trägt, spürt das Echo eines Speerstoßes, der selbst uralte Steinschuppen durchdringen kann."
        }

        armor("dawncrest", name = "des Morgenwappens") {
            description = "§7Für die Wächter geschmiedet, die während der längsten Nacht Wache hielten, trägt diese Rüstung das Wappen der aufgehenden Sonne.\nIhr verblasstes Gold erinnert sich an das erste Licht über einem stillen Schlachtfeld.\nWer sie trägt, bewahrt ein Versprechen: Wie tief die Dunkelheit auch sein mag, der Morgen wird kommen."
        }
    }

    language("fr_fr") {
        armorNames(
            helmet = "Casque {name}",
            chestplate = "Plastron {name}",
            leggings = "Jambières {name}",
            boots = "Bottes {name}",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "Fantasy Armor")
        entry("item.${mod.id}.${moonCrystal.id}", "Cristal Lunaire")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "La lumière de la lune emprisonnée dans un cristal. Éveille le pouvoir des armures anciennes.")

        armor("eclipse_soldier", name = "du Soldat de l'Éclipse") {
            description = "§7L'armure d'un fantassin qui combattit jadis pour le triomphe de l'éclipse sur le soleil.\nOn raconte que des milliers de malheureux trouvèrent la mort sous les bottes des légions."
        }

        armor("golden_horns", name = "des Cornes Dorées") {
            description = "§7Une armure si éclatante qu'elle semble taillée dans la lumière elle-même.\nPourtant, son or n'est pas une bénédiction, mais une malédiction.\nIl a été témoin de mort et de destruction, et sa lumière nourrit la cupidité et la soif de sang.\nCette armure ne sert son maître que tant qu'il accepte de sacrifier ses ennemis."
        }

        armor("dragonslayer", name = "du Tueur de Dragons") {
            description = "§7Forgée dans les écailles de dragons vaincus, chacune symbole de force et de fureur ancestrales.\nSes plaques et ses pointes vous confèrent la puissance de la victoire sur eux, mais chaque pas sous cette armure porte le poids de nombreuses morts."
        }

        armor("hero", name = "du Héros") {
            description = "§7L'héritage d'anciens guerriers qui combattirent jusqu'à leur dernier souffle.\nElle garde le souvenir d'innombrables batailles et épreuves endurées au nom de la justice.\nMais la gloire est un lourd fardeau.\nToutes les histoires ne traversent pas les âges."
        }

        armor("thief", name = "du Voleur") {
            description = "§7La compagne idéale de ceux qui vivent dans les ombres et respirent les ténèbres.\nCelui qui la porte ne fait plus qu'un avec la nuit.\nLe masque noir dissimule votre visage et laisse vos ennemis dans l'incertitude."
        }

        armor("wandering_wizard", name = "du Mage Errant") {
            description = "§7Ces vêtements sont imprégnés de magie ancienne.\nIls murmurent des sortilèges oubliés et ouvrent des portes vers d'autres mondes.\nChaque fil lie son porteur à des forces inconnues, lui donnant le pouvoir de pratiquer la magie, mais aussi la malédiction d'une errance éternelle sans repos."
        }

        armor("sunset_wings", name = "des Ailes du Crépuscule") {
            description = "§7Le crépuscule est à la fois une fin et un commencement.\nLes ailes guident leur maître à travers l'obscurité.\nEn les revêtant, vous devenez le sombre messager de la nuit éternelle."
        }

        armor("chess_board_knight", name = "du Chevalier de l'Échiquier") {
            description = "§7Chaque mouvement est une bataille, chaque pas une stratégie.\nCette armure incarne la froide logique et la puissance impitoyable de la guerre.\nPortez-la avec la fierté d'un stratège, prêt à tout sacrifier pour la victoire, même votre âme."
        }

        armor("dark_lord", name = "du Seigneur des Ténèbres") {
            description = "§7Créée dans les profondeurs d'un autre monde, cette armure incarne la puissance de la terreur.\nSes pointes et ses plaques noires ressemblent à des crocs brisés.\nPortez-la si vous l'osez, mais sachez qu'elle exige une dévotion éternelle aux ténèbres et dévore ceux qui tentent de lui résister."
        }

        armor("fog_guard", name = "du Gardien de la Brume") {
            description = "§7Enveloppée d'une brume ancestrale, cette armure offre une protection inégalée, mais affaiblit son porteur par des visions de royaumes perdus."
        }

        armor("dark_cover", name = "du Voile Sombre") {
            description = "§7Cette armure enveloppe son porteur d'ombres, le protège de la lumière et lui accorde le silence, mais murmure les secrets oubliés de forces obscures.\nPortez-la, mais écoutez les avertissements des ombres."
        }

        armor("spark_of_dawn", name = "de l'étincelle de l'Aube") {
            description = "§7Forgée dans la première lumière, cette armure porte chaleur et clarté, mais brûle ceux dont le cœur n'est pas pur.\nSeuls les justes peuvent éveiller sa véritable puissance."
        }

        armor("golden_execution", name = "de l'exécution Dorée") {
            description = "§7Portant le poids du courroux de l'empire, cette armure brille comme l'or, mais est trempée du sang des morts.\nPortez-la avec fierté, sans jamais oublier son prix."
        }

        armor("forgotten_trace", name = "de la Trace Oubliée") {
            description = "§7Le souvenir des guerres anciennes demeure dans cette armure et hante son porteur des échos de batailles oubliées.\nQuiconque la revêt porte la marque d'une âme venue d'un autre âge."
        }

        armor("redeemer", name = "du Rédempteur") {
            description = "§7Une armure créée par l'ancien ordre.\nVotre dieu a été tué il y a bien longtemps, mais votre foi a perduré.\nSachant que vous ne reviendrez probablement pas de votre quête, vous avancez courageusement vers l'inconnu."
        }

        armor("twinned", name = "des Jumeaux") {
            description = "§7Liée à un autre être par l'esprit, cette armure partage la douleur et le triomphe de sa jumelle.\nUn destin commun attend ceux qui portent l'ensemble complet."
        }

        armor("gilded_hunt", name = "de la Chasse Dorée") {
            description = "§7Portée par ceux qui recherchent l'honneur et la gloire, cette armure reflète l'ambition indomptable de son porteur.\nChassez avec elle, mais prenez garde : la gloire exige souvent un lourd tribut."
        }

        armor("lady_maria", name = "de Dame Maria") {
            description = "§7Un cadavre… devrait reposer en paix.\nOh, je ne le sais que trop bien. Comme les secrets nous appellent avec douceur.\nSeule une mort honnête peut désormais vous guérir.\nVous libérer de votre curiosité effrénée."
        }

        armor("crucible_knight", name = "du Chevalier du Creuset") {
            description = "§7Elle renferme la puissance du creuset de la vie.\nAvec le temps, la force de ces chevaliers, et même leur apparence, furent jugées chaotiques et dignes de mépris."
        }

        armor("evening_ghost", name = "du Fantôme du Soir") {
            description = "§7Cachée dans la nuit, l'ombre connaît sa place.\nSes pas sont silencieux, mais le froid de sa présence se ressent sur la peau."
        }

        armor("ronin", name = "du Ronin") {
            description = "§7L'acier porte les cicatrices du passé ; ses motifs sont imprégnés d'un sang refroidi depuis longtemps."
        }

        armor("malenia", name = "de Malenia") {
            description = "§7…Écoutez mes paroles. Je suis Malenia. L'Épée de Miquella. Et je n'ai jamais connu la défaite."
        }

        armor("old_knight", name = "du Vieux Chevalier") {
            description = "§7Une armure jadis portée par un chevalier ayant survécu à d'innombrables batailles.\nSon poids est insupportable pour les faibles, mais ceux qui l'endurent ne tomberont jamais."
        }

        armor("silver_knight", name = "du Chevalier d'Argent") {
            description = "§7L'armure d'un guerrier d'élite qui ne faiblit jamais au combat.\nSon éclat argenté reflète la lune et apporte une mort rapide à ceux qui osent défier son maître."
        }

        armor("dead_gladiator", name = "du Gladiateur Mort") {
            description = "§7L'armure d'un esclave tombé dans l'arène.\nSon nom est oublié, mais la fureur brûle encore sous l'acier."
        }

        armor("flesh_of_the_feaster", name = "de la Chair du Dévoreur") {
            description = "§7Cette armure empeste le sang et la cupidité.\nElle appartenait jadis à un être qui se nourrissait sans fin, jusqu'à devenir ce qu'il dévorait."
        }

        armor("wind_worshipper", name = "de l'adorateur du Vent") {
            description = "§7Un tissu léger comme le souffle.\nIl est porté par ceux qui ne connaissent aucun repos et errent au gré du vent."
        }

        armor("grave_sentinel", name = "de la Sentinelle du Cimetière") {
            description = "§7L'armure qui veille sur le sommeil des morts.\nJadis liée à de nobles serments, sa mission s'est déformée avec le temps, devenant une veille muette parmi la poussière et le silence."
        }

        armor("ornstein", name = "d'Ornstein") {
            description = "§7Des plaques dorées façonnées à l'image d'un lion.\nForgée pour le plus féroce tueur de dragons du Premier Seigneur, cette armure vibre encore des vestiges de la foudre.\nCeux qui portent l'ensemble complet ressentent l'écho d'un coup de lance capable de percer d'antiques écailles de pierre."
        }

        armor("dawncrest", name = "de l'Emblème de l'Aube") {
            description = "§7Forgée pour les sentinelles qui veillèrent durant la nuit la plus longue, cette armure porte l'emblème du soleil levant.\nSon or terni se souvient de la première lumière sur un champ de bataille silencieux.\nCeux qui la portent gardent une promesse : aussi profondes que soient les ténèbres, l'aube viendra."
        }
    }

    language("pl_pl") {
        armorNames(
            helmet = "Hełm {name}",
            chestplate = "Napierśnik {name}",
            leggings = "Nogawice {name}",
            boots = "Buty {name}",
        )
        entry("itemGroup.fantasy_armor.fa_tab", "Fantasy Armor")
        entry("item.${mod.id}.${moonCrystal.id}", "Księżycowy Kryształ")
        entry("item.${mod.id}.${moonCrystal.id}.tooltip", "Blask księżyca zamknięty w krysztale. Budzi moc pradawnych zbroi.")

        armor("eclipse_soldier", name = "Żołnierza Zaćmienia") {
            description = "§7Zbroja piechura, który dawno temu walczył o triumf zaćmienia nad słońcem.\nPowiadają, że pod butami legionów śmierć znalazły tysiące nieszczęśników."
        }

        armor("golden_horns", name = "Złotych Rogów") {
            description = "§7Zbroja tak olśniewająca, jakby wyrzeźbiono ją z samego światła.\nJej złoto nie jest jednak błogosławieństwem, lecz klątwą.\nByło świadkiem śmierci i zniszczenia, a jego blask podsyca chciwość i żądzę krwi.\nZbroja służy właścicielowi tylko tak długo, jak długo jest gotów składać w ofierze swoich wrogów."
        }

        armor("dragonslayer", name = "Zabójcy Smoków") {
            description = "§7Wykuta z łusek pokonanych smoków, z których każda symbolizuje pradawną siłę i gniew.\nPłyty i kolce dają ci moc zwycięstwa nad nimi, lecz pamiętaj, że każdy krok w tej zbroi niesie ciężar wielu śmierci."
        }

        armor("hero", name = "Bohatera") {
            description = "§7Dziedzictwo dawnych wojowników, którzy walczyli do ostatniego tchu.\nPrzechowuje pamięć niezliczonych bitew i trudów znoszonych w poszukiwaniu sprawiedliwości.\nLecz chwała to ciężkie brzemię.\nNie każda opowieść przetrwa wieki."
        }

        armor("thief", name = "Złodzieja") {
            description = "§7Doskonała towarzyszka tych, którzy żyją w cieniu i oddychają mrokiem.\nNoszący ją staje się jednością z nocą.\nCzarna maska skrywa twoją twarz, pozostawiając wrogów w niepewności."
        }

        armor("wandering_wizard", name = "Wędrownego Maga") {
            description = "§7Szaty przesycone pradawną magią.\nSzepczą zapomniane zaklęcia i otwierają bramy do innych światów.\nKażda nić wiąże noszącego z nieznanymi siłami, dając mu moc czarowania, lecz także klątwę wiecznej tułaczki bez prawa do odpoczynku."
        }

        armor("sunset_wings", name = "Skrzydeł Zmierzchu") {
            description = "§7Zachód słońca jest zarazem końcem i początkiem.\nSkrzydła prowadzą swego właściciela przez ciemność.\nGdy je przywdziejesz, staniesz się posępnym zwiastunem wiecznej nocy."
        }

        armor("chess_board_knight", name = "Rycerza Szachownicy") {
            description = "§7Każdy ruch to bitwa, każdy krok to strategia.\nTa zbroja ucieleśnia chłodną logikę i bezlitosną potęgę wojny.\nNoś ją z dumą stratega, gotów poświęcić dla zwycięstwa wszystko, nawet własną duszę."
        }

        armor("dark_lord", name = "Mrocznego Władcy") {
            description = "§7Stworzona w głębinach innego świata zbroja ucieleśnia potęgę grozy.\nJej kolce i czarne płyty przypominają połamane kły.\nPrzywdziej ją, jeśli się odważysz, lecz wiedz, że wymaga wiecznej wierności ciemności i pożera tych, którzy próbują się jej oprzeć."
        }

        armor("fog_guard", name = "Strażnika Mgły") {
            description = "§7Spowita pradawną mgłą zbroja daje niezrównaną ochronę, lecz osłabia noszącego wizjami zaginionych krain."
        }

        armor("dark_cover", name = "Mrocznej Zasłony") {
            description = "§7Ta zbroja otula noszącego cieniem, chroni przed światłem i obdarza ciszą, lecz szepcze zapomniane sekrety mrocznych sił.\nNoś ją, ale słuchaj ostrzeżeń cieni."
        }

        armor("spark_of_dawn", name = "Iskry Świtu") {
            description = "§7Wykuta w pierwszym świetle zbroja niesie ciepło i blask, lecz parzy tych, których serca nie są czyste.\nTylko prawi mogą przebudzić jej prawdziwą moc."
        }

        armor("golden_execution", name = "Złotej Egzekucji") {
            description = "§7Dźwigająca ciężar gniewu imperium zbroja lśni złotem, lecz jest przesiąknięta krwią poległych.\nNoś ją z dumą, ale nigdy nie zapominaj o jej cenie."
        }

        armor("forgotten_trace", name = "Zapomnianego Śladu") {
            description = "§7Pamięć pradawnych wojen trwa w tej zbroi, nawiedzając noszącego echem dawno zapomnianych bitew.\nKto ją przywdzieje, zostaje naznaczony jako dusza z innej epoki."
        }

        armor("redeemer", name = "Odkupiciela") {
            description = "§7Zbroja stworzona przez dawny zakon.\nTwój bóg został zabity dawno temu, lecz twoja wiara przetrwała.\nWiedząc, że zapewne nie wrócisz z wyprawy, odważnie kroczysz w nieznane."
        }

        armor("twinned", name = "Bliźniąt") {
            description = "§7Związana duchem z inną istotą zbroja dzieli ból i triumf ze swą bliźniaczką.\nWspólny los czeka tych, którzy przywdzieją cały zestaw."
        }

        armor("gilded_hunt", name = "Złoconych Łowów") {
            description = "§7Noszona przez tych, którzy ścigają honor i chwałę, zbroja odzwierciedla nieposkromioną ambicję właściciela.\nPoluj w niej, lecz uważaj: chwała często ma wysoką cenę."
        }

        armor("lady_maria", name = "Lady Marii") {
            description = "§7Zwłoki… należy pozostawić w spokoju.\nOch, wiem aż za dobrze, jak słodko kuszą tajemnice.\nTeraz tylko uczciwa śmierć może cię uleczyć.\nUwolnić cię od nieposkromionej ciekawości."
        }

        armor("crucible_knight", name = "Rycerza Tygla") {
            description = "§7Skrywa potęgę tygla życia.\nZ czasem siłę tych rycerzy, a nawet ich wygląd, uznano za chaotyczne i godne pogardy."
        }

        armor("evening_ghost", name = "Wieczornego Widma") {
            description = "§7Ukryty w nocy cień zna swoje miejsce.\nJego kroki są bezgłośne, lecz chłód jego obecności czuć na skórze."
        }

        armor("ronin", name = "Ronina") {
            description = "§7Stal nosi blizny przeszłości, a jej wzory są przesiąknięte dawno ostygłą krwią."
        }

        armor("malenia", name = "Malenii") {
            description = "§7…Zapamiętaj moje słowa. Jestem Malenia. Ostrze Miquelli. I nigdy nie zaznałam porażki."
        }

        armor("old_knight", name = "Starego Rycerza") {
            description = "§7Zbroja noszona niegdyś przez rycerza, który przeżył niezliczone bitwy.\nJej ciężar jest nie do zniesienia dla słabych, lecz ci, którzy go udźwigną, nigdy nie upadną."
        }

        armor("silver_knight", name = "Srebrnego Rycerza") {
            description = "§7Zbroja elitarnego wojownika, który nigdy nie zachwiał się w boju.\nJej srebrny blask odbija światło księżyca i niesie szybką śmierć tym, którzy ośmielą się sprzeciwić jej panu."
        }

        armor("dead_gladiator", name = "Martwego Gladiatora") {
            description = "§7Zbroja niewolnika poległego na arenie.\nJego imię zapomniano, lecz pod stalą wciąż płonie gniew."
        }

        armor("flesh_of_the_feaster", name = "Ciała Pożeracza") {
            description = "§7Ta zbroja cuchnie krwią i chciwością.\nNależała do kogoś, kto pożerał bez końca, aż stał się tym, co pochłaniał."
        }

        armor("wind_worshipper", name = "Czciciela Wiatru") {
            description = "§7Tkanina lekka jak oddech.\nNoszą ją ci, którzy nie znają spoczynku i wędrują tam, dokąd poniesie ich wiatr."
        }

        armor("grave_sentinel", name = "Strażnika Cmentarza") {
            description = "§7Zbroja strzegąca snu zmarłych.\nNiegdyś związana szlachetnymi przysięgami, z czasem jej służba wypaczyła się w niemą wartę pośród pyłu i ciszy."
        }

        armor("ornstein", name = "Ornsteina") {
            description = "§7Złote płyty ukształtowane na podobieństwo lwa.\nWykuta dla najzacieklejszego zabójcy smoków Pierwszego Władcy zbroja wciąż drży od resztek mocy błyskawic.\nNoszący cały zestaw czują echo pchnięcia włócznią zdolnego przebić pradawne kamienne łuski."
        }

        armor("dawncrest", name = "Herbu Świtu") {
            description = "§7Wykuta dla strażników pełniących wartę podczas najdłuższej nocy zbroja nosi herb wschodzącego słońca.\nJej przygasłe złoto pamięta pierwsze światło nad ucichłym polem bitwy.\nCi, którzy ją noszą, strzegą obietnicy: choćby mrok był najgłębszy, świt nadejdzie."
        }
    }
}
