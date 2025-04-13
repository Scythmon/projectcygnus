package net.scythmon.cygnus.items.client.masks;

import net.scythmon.cygnus.items.custom.masks.ADamMaskArmorItem;
import net.scythmon.cygnus.items.custom.masks.AVitMaskArmorItem;
import software.bernie.geckolib.renderer.GeoArmorRenderer;

public class ADamMaskArmorRenderer extends GeoArmorRenderer<ADamMaskArmorItem> {
    public ADamMaskArmorRenderer() {
        super(new ADamMaskArmorModel());
    }
}
