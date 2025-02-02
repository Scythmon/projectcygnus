package net.scythmon.cygnus.items.client;

import net.scythmon.cygnus.items.custom.ConquestArmorItem;
import software.bernie.geckolib.model.GeoModel;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ConquestArmorRenderer extends GeoArmorRenderer<ConquestArmorItem> {
    public ConquestArmorRenderer() {
        super(new ConquestArmorModel());
    }
}
