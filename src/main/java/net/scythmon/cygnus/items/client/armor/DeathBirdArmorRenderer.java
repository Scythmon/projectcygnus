package net.scythmon.cygnus.items.client.armor;

import net.scythmon.cygnus.items.custom.armor.ConquestArmorItem;
import net.scythmon.cygnus.items.custom.armor.DeathBirdArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DeathBirdArmorRenderer extends GeoArmorRenderer<DeathBirdArmorItem> {
    public DeathBirdArmorRenderer() {
        super(new DeathBirdArmorModel());
    }
}
