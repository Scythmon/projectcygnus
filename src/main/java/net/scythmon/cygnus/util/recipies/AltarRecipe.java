package net.scythmon.cygnus.util.recipies;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.core.NonNullList;
import net.minecraft.core.RegistryAccess;
import net.minecraft.network.FriendlyByteBuf;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.util.GsonHelper;
import net.minecraft.world.SimpleContainer;
import net.minecraft.world.item.ItemStack;
import net.minecraft.world.item.crafting.*;
import net.minecraft.world.level.Level;
import net.scythmon.cygnus.ProjectCygnus;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;

public class AltarRecipe implements Recipe<SimpleContainer> {
    private final ResourceLocation id;
    private final ItemStack output;
    private final NonNullList<Ingredient> recipeItems;
    private final boolean exact; // New condition flag

    public AltarRecipe(ResourceLocation id, ItemStack output, NonNullList<Ingredient> recipeItems, boolean exact) {
        this.id = id;
        this.output = output;
        this.recipeItems = recipeItems;
        this.exact = exact;
    }

    @Override
    public boolean matches(SimpleContainer container, Level level) {
        if (level.isClientSide()) return false;

        List<ItemStack> inputs = new ArrayList<>();
        for (int i = 0; i < container.getContainerSize(); i++) {
            ItemStack stack = container.getItem(i);
            if (!stack.isEmpty()) inputs.add(stack);
        }

        if (exact) {
            if (container.getContainerSize() < recipeItems.size()) return false;

            for (int i = 0; i < recipeItems.size(); i++) {
                Ingredient ingredient = recipeItems.get(i);
                ItemStack actualItem = container.getItem(i);

                if (!ingredient.test(actualItem)) {
                    return false;
                }
            }
            return true;
        }

        if (inputs.size() != recipeItems.size()) return false;

        List<ItemStack> copyInputs = new ArrayList<>(inputs);
        for (Ingredient ingredient : recipeItems) {
            boolean matched = false;
            for (int i = 0; i < copyInputs.size(); i++) {
                if (ingredient.test(copyInputs.get(i))) {
                    copyInputs.remove(i);
                    matched = true;
                    break;
                }
            }
            if (!matched) return false;
        }
        return true;
    }

    @Override
    public ItemStack assemble(SimpleContainer container, RegistryAccess registryAccess) {
        return output.copy();
    }

    @Override
    public boolean canCraftInDimensions(int width, int height) { return true; }

    @Override
    public ItemStack getResultItem(RegistryAccess registryAccess) { return output; }

    @Override
    public ResourceLocation getId() { return id; }

    @Override
    public RecipeSerializer<?> getSerializer() { return Serializer.INSTANCE; }

    @Override
    public RecipeType<?> getType() { return Type.INSTANCE; }

    public NonNullList<Ingredient> getIngredients() { return this.recipeItems; }

    public boolean isExact() { return this.exact; }

    public static class Type implements RecipeType<AltarRecipe> {
        public static final Type INSTANCE = new Type();
        public static final String ID = "altar_crafting";
    }

    public static class Serializer implements RecipeSerializer<AltarRecipe> {
        public static final Serializer INSTANCE = new Serializer();
        public static final ResourceLocation ID = new ResourceLocation(ProjectCygnus.MOD_ID, "altar_crafting");

        @Override
        public AltarRecipe fromJson(ResourceLocation recipeId, JsonObject json) {
            ItemStack output = ShapedRecipe.itemStackFromJson(GsonHelper.getAsJsonObject(json, "output"));
            boolean exact = GsonHelper.getAsBoolean(json, "exact", false); // Reads exact token flag

            JsonArray ingredients = GsonHelper.getAsJsonArray(json, "ingredients");
            NonNullList<Ingredient> inputs = NonNullList.withSize(ingredients.size(), Ingredient.EMPTY);

            for (int i = 0; i < ingredients.size(); i++) {
                inputs.set(i, Ingredient.fromJson(ingredients.get(i)));
            }

            return new AltarRecipe(recipeId, output, inputs, exact);
        }

        @Override
        public @Nullable AltarRecipe fromNetwork(ResourceLocation recipeId, FriendlyByteBuf buffer) {
            boolean exact = buffer.readBoolean();
            NonNullList<Ingredient> inputs = NonNullList.withSize(buffer.readInt(), Ingredient.EMPTY);
            for (int i = 0; i < inputs.size(); i++) {
                inputs.set(i, Ingredient.fromNetwork(buffer));
            }
            ItemStack output = buffer.readItem();
            return new AltarRecipe(recipeId, output, inputs, exact);
        }

        @Override
        public void toNetwork(FriendlyByteBuf buffer, AltarRecipe recipe) {
            buffer.writeBoolean(recipe.isExact());
            buffer.writeInt(recipe.getIngredients().size());
            for (Ingredient ing : recipe.getIngredients()) {
                ing.toNetwork(buffer);
            }
            buffer.writeItem(recipe.output);
        }
    }
}
