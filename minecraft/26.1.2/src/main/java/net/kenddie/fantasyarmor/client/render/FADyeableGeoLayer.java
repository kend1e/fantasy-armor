package net.kenddie.fantasyarmor.client.render;

import net.kenddie.fantasyarmor.item.armor.FAArmorItem;
import net.minecraft.client.renderer.SubmitNodeCollector;
import net.minecraft.client.renderer.entity.state.HumanoidRenderState;
import net.minecraft.client.renderer.rendertype.RenderTypes;
import net.minecraft.resources.Identifier;
import com.geckolib.constant.dataticket.DataTicket;
import com.geckolib.renderer.GeoArmorRenderer;
import com.geckolib.renderer.base.GeoRenderState;
import com.geckolib.renderer.base.RenderPassInfo;
import com.geckolib.renderer.layer.GeoRenderLayer;

public final class FADyeableGeoLayer<T extends FAArmorItem, R extends HumanoidRenderState & GeoRenderState>
        extends GeoRenderLayer<T, GeoArmorRenderer.RenderData, R> {
    public static final DataTicket<Boolean> HAS_DYE_TICKET = DataTicket.create("fantasyarmor_has_dye", Boolean.class);
    public static final DataTicket<Integer> DYE_COLOR_TICKET = DataTicket.create("fantasyarmor_dye_color", Integer.class);
    public static final DataTicket<Identifier> OVERLAY_TEX_TICKET = DataTicket.create("fantasyarmor_overlay_tex", Identifier.class);
    private final FAArmorRenderer<T, R> armorRenderer;

    public FADyeableGeoLayer(FAArmorRenderer<T, R> renderer) {
        super(renderer);
        this.armorRenderer = renderer;
    }

    @Override
    public void submitRenderTask(RenderPassInfo<R> pass, SubmitNodeCollector tasks) {
        if (!pass.willRender() || !pass.getOrDefaultGeckolibData(HAS_DYE_TICKET, false)) return;
        Identifier texture = pass.getGeckolibData(OVERLAY_TEX_TICKET);
        if (texture == null) return;
        armorRenderer.submitArmorGeometry(pass, tasks.order(1), RenderTypes.armorCutoutNoCull(texture),
                pass.getOrDefaultGeckolibData(DYE_COLOR_TICKET, 0xFFFFFFFF));
    }
}
