package net.scythmon.cygnus.items.custom;


import net.minecraft.world.item.Item;
import net.minecraft.world.item.ItemStack;


public class TarotDeck extends Item {
    public TarotDeck(Properties pProperties) {super(pProperties);}

    @Override
    public boolean hasCraftingRemainingItem(ItemStack stack) {
        return stack.getDamageValue() < this.getMaxDamage(stack);
    }

    @Override
    public ItemStack getCraftingRemainingItem(ItemStack itemStack) {
        ItemStack old = itemStack.copy();
        old.setDamageValue(old.getDamageValue()+0);
        return old;
    }
}
