package net.scythmon.cygnus.items.client.masks;

import net.scythmon.cygnus.items.custom.masks.AWitMaskArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class AWitMaskArmorRenderer extends GeoArmorRenderer<AWitMaskArmorItem> {
    public AWitMaskArmorRenderer() {
        super(new AWitMaskArmorModel());
    }
}
