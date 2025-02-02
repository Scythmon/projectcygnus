package net.scythmon.cygnus.items.client.crowns;

import net.scythmon.cygnus.items.client.masks.AVitMaskArmorModel;
import net.scythmon.cygnus.items.custom.crowns.StarCrownArmorItem;
import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class StarCrownArmorRenderer extends GeoArmorRenderer<StarCrownArmorItem> {
    public StarCrownArmorRenderer() {
        super(new StarCrownArmorModel());
    }
}
