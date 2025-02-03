package net.scythmon.cygnus.items.client.armor;

import net.scythmon.cygnus.items.custom.armor.ConquestArmorItem;
import net.scythmon.cygnus.items.custom.armor.PlagueLordArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class PlagueLordArmorRenderer extends GeoArmorRenderer<PlagueLordArmorItem> {
    public PlagueLordArmorRenderer() {
        super(new PlagueLordArmorModel());
    }
}
