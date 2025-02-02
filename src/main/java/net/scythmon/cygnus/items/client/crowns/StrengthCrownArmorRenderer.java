package net.scythmon.cygnus.items.client.crowns;

import net.scythmon.cygnus.items.client.masks.AVitMaskArmorModel;
import net.scythmon.cygnus.items.custom.crowns.StrengthCrownArmorItem;
import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class StrengthCrownArmorRenderer extends GeoArmorRenderer<StrengthCrownArmorItem> {
    public StrengthCrownArmorRenderer() {
        super(new StrengthCrownArmorModel());
    }
}
