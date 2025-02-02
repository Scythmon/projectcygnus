package net.scythmon.cygnus.items.client;

import net.scythmon.cygnus.items.custom.ConquestArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FamineArmorRenderer extends GeoArmorRenderer<ConquestArmorItem> {
    public FamineArmorRenderer() {
        super(new ConquestArmorModel());
    }
}
