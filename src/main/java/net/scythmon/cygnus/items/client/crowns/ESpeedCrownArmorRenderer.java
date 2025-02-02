package net.scythmon.cygnus.items.client.crowns;

import net.scythmon.cygnus.items.custom.crowns.ESpeedCrownArmorItem;
import net.scythmon.cygnus.items.custom.crowns.SpeedCrownArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ESpeedCrownArmorRenderer extends GeoArmorRenderer<ESpeedCrownArmorItem> {
    public ESpeedCrownArmorRenderer() {
        super(new ESpeedCrownArmorModel());
    }
}
