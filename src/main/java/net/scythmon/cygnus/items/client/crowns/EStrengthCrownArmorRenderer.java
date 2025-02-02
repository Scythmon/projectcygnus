package net.scythmon.cygnus.items.client.crowns;

import net.scythmon.cygnus.items.custom.crowns.EStrengthCrownArmorItem;
import net.scythmon.cygnus.items.custom.crowns.StrengthCrownArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class EStrengthCrownArmorRenderer extends GeoArmorRenderer<EStrengthCrownArmorItem> {
    public EStrengthCrownArmorRenderer() {
        super(new EStrengthCrownArmorModel());
    }
}
