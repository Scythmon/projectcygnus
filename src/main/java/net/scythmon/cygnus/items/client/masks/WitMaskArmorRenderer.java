package net.scythmon.cygnus.items.client.masks;

import net.scythmon.cygnus.items.custom.masks.WitMaskArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class WitMaskArmorRenderer extends GeoArmorRenderer<WitMaskArmorItem> {
    public WitMaskArmorRenderer() {
        super(new WitMaskArmorModel());
    }
}
