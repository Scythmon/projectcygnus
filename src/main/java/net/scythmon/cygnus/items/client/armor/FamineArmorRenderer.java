package net.scythmon.cygnus.items.client.armor;

import net.scythmon.cygnus.items.custom.armor.FamineArmorItem;
import net.scythmon.cygnus.items.custom.armor.PlagueLordArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class FamineArmorRenderer extends GeoArmorRenderer<FamineArmorItem> {
    public FamineArmorRenderer() {
        super(new FamineArmorModel());
    }
}
