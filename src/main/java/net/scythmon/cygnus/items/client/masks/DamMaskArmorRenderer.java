package net.scythmon.cygnus.items.client.masks;

import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import net.scythmon.cygnus.items.custom.masks.DamMaskArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class DamMaskArmorRenderer extends GeoArmorRenderer<DamMaskArmorItem> {
    public DamMaskArmorRenderer() {
        super(new DamMaskArmorModel());
    }
}
