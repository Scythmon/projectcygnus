package net.scythmon.cygnus.items.client.crowns;

import net.scythmon.cygnus.items.custom.crowns.EStarCrownArmorItem;
import net.scythmon.cygnus.items.custom.crowns.StarCrownArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EStarCrownArmorRenderer extends GeoArmorRenderer<EStarCrownArmorItem> {
    public EStarCrownArmorRenderer() {
        super(new EStarCrownArmorModel());
    }
}
