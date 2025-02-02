package net.scythmon.cygnus.items.client.crowns;

import net.scythmon.cygnus.items.client.masks.AVitMaskArmorModel;
import net.scythmon.cygnus.items.custom.crowns.SpeedCrownArmorItem;
import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class SpeedCrownArmorRenderer extends GeoArmorRenderer<SpeedCrownArmorItem> {
    public SpeedCrownArmorRenderer() {
        super(new SpeedCrownArmorModel());
    }
}
