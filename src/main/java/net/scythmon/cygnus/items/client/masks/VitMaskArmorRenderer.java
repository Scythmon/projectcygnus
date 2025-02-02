package net.scythmon.cygnus.items.client.masks;

import net.scythmon.cygnus.items.custom.masks.VitMaskArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class VitMaskArmorRenderer extends GeoArmorRenderer<VitMaskArmorItem> {
    public VitMaskArmorRenderer() {
        super(new VitMaskArmorModel());
    }
}
