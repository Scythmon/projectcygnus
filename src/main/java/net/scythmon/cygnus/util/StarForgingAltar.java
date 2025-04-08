package net.scythmon.cygnus.util;

import com.blakebr0.cucumber.crafting.ISpecialRecipe;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.Container;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.item.crafting.RecipeType;
import net.minecraft.world.item.crafting.ShapedRecipe;
import net.minecraft.world.level.Level;
import net.minecraftforge.items.IItemHandler;
import net.minecraftforge.items.wrapper.InvWrapper;
import net.scythmon.cygnus.init.ModRecipeTypes;

import java.util.function.BiFunction;

public class StarForgingAltar implements ISpecialRecipe, IAltarRecipe {
    public static final int RECIPE_SIZE = 9;
    private final ResourceLocation recipeID;
    private final NonNullList<Ingredient> inputs;
    private final ItemStack output;
    private final boolean transferNBT;
    //Crafttweaker
    private BiFunction<Integer, ItemStack, ItemStack> transformer;

    public StarForgingAltar(ResourceLocation recipeID, NonNullList<Ingredient> inputs, ItemStack output, boolean transferNBT) {
        this.recipeID = recipeID;
        this.inputs = inputs;
        this.output = output;
        this.transferNBT = transferNBT;
    }


    @Override
    public ItemStack assemble(IItemHandler iItemHandler, RegistryAccess registryAccess) {
        var stack = iItemHandler.getStackInSlot(0);
        var result = this.output.copy();

        if (this.transferNBT) {
            var tag = stack.getTag();

            if (tag != null) {
                result.setTag(tag.copy());

                return result;
            }
        }

        return result;
    }

    @Override
    public ItemStack assemble(Container inventory, RegistryAccess access) {
        return this.assemble(new InvWrapper(inventory), access);
    }

    @Override
    public boolean canCraftInDimensions(int i, int i1) {
        return true;
    }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) {
        return this.output;
    }

    @Override
    public ResourceLocation getId() {
        return this.recipeID;
    }

    @Override
    public RecipeSerializer<?> getSerializer() {
        return ModRecipies.ALTAR_CRAFTING_SERIALIZER.get();
    }

    @Override
    public RecipeType<?> getType() {
        return ModRecipeTypes.STAR_FORGING.get();
    }

    @Override
    public boolean matches(IItemHandler inventory) {
        var altarStack = inventory.getStackInSlot(0);
        return !this.inputs.isEmpty() && this.inputs.get(0).test(altarStack) && ISpecialRecipe.super.matches(inventory);
    }

    @Override
    public boolean matches(Container inventory, Level level) {
        return this.matches(new InvWrapper(inventory));
    }

    @Override
    public NonNullList<ItemStack> getRemainingItems(Container inventory) {
        var remaining = ISpecialRecipe.super.getRemainingItems(inventory);

        if (this.transformer != null) {
            var used = new boolean[remaining.size()];

            for (int i = 0; i < remaining.size(); i++) {
                var stack = inventory.getItem(i);

                for (int j = 0; j < this.inputs.size(); j++) {
                    var input = this.inputs.get(j);

                    if (!used[j] && input.test(stack)) {
                        var ingredient = this.transformer.apply(j, stack);

                        used[j] = true;
                        remaining.set(i, ingredient);

                        break;
                    }
                }
            }
        }
        return remaining;
    }

    public void setTransformer(BiFunction<Integer, ItemStack, ItemStack> transformer) {
        this.transformer = transformer;
    }

    public static class Serializer implements RecipeSerializer<StarForgingAltar> {
        @Override
        public StarForgingAltar fromJson(ResourceLocation recipeId, JsonObject json) {
            var inputs = NonNullList.withSize(RECIPE_SIZE, Ingredient.EMPTY);
            var input = GsonHelper.getAsJsonObject(json, "input");

            inputs.set(0, Ingredient.fromJson(input));

            var ingredients = GsonHelper.getAsJsonArray(json, "ingredients");

            for (int i = 0; i < ingredients.size(); i++) {
                inputs.set(i + 1, Ingredient.fromJson(ingredients.get(i)));
            }

            var result = ShapedRecipe.itemStackFromJson(json.getAsJsonObject("result"));
            var transferNBT = GsonHelper.getAsBoolean(json, "transfer_nbt", false);

            return new StarForgingAltar(recipeId, inputs, result, transferNBT);
        }


        @Override
        public StarForgingAltar fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            int size = buffer.readVarInt();
            var inputs = NonNullList.withSize(size, Ingredient.EMPTY);

            for (int i = 0; i < size; i++) {
                inputs.set(i, Ingredient.fromNetwork(buffer));
            }

            var output = buffer.readItem();
            var transferNBT = buffer.readBoolean();

            return new StarForgingAltar(recipeId, inputs, output, transferNBT);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, StarForgingAltar recipe) {
            buffer.writeVarInt(recipe.inputs.size());

            for (var ingredient : recipe.inputs) {
                ingredient.toNetwork(buffer);
            }

            buffer.writeItem(recipe.output);
            buffer.writeBoolean(recipe.transferNBT);
        }
    }
}
