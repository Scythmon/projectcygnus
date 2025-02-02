package net.scythmon.cygnus.items.client.armor;

import net.scythmon.cygnus.items.custom.armor.ConquestArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ConquestArmorRenderer extends GeoArmorRenderer<ConquestArmorItem> {
    public ConquestArmorRenderer() {
        super(new ConquestArmorModel());
    }
}
