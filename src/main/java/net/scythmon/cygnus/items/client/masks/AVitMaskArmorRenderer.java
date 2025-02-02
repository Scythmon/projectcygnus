package net.scythmon.cygnus.items.client.masks;

import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class AVitMaskArmorRenderer extends GeoArmorRenderer<AVitMaskArmorItem> {
    public AVitMaskArmorRenderer() {
        super(new AVitMaskArmorModel());
    }
}
