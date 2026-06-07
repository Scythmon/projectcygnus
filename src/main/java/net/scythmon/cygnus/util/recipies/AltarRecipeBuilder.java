package net.scythmon.cygnus.util.recipies;

import com.google.gson.JsonArray;
import com.google.gson.JsonObject;
import net.minecraft.data.recipes.FinishedRecipe;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.Item;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeSerializer;
import net.minecraft.world.level.ItemLike;
import net.minecraftforge.registries.ForgeRegistries;

import javax.annotation.Nullable;
import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;

public class AltarRecipeBuilder {
    private final Item result;
    private final int count;
    private final List<Ingredient> ingredients = new ArrayList<>();
    private final boolean exact;

    private AltarRecipeBuilder(ItemLike result, int count, boolean exact) {
        this.result = result.asItem();
        this.count = count;
        this.exact = exact;
    }

    public static AltarRecipeBuilder altarRecipe(ItemLike result, boolean exact) {
        return new AltarRecipeBuilder(result, 1, exact);
    }

    public static AltarRecipeBuilder altarRecipe(ItemLike result, int count, boolean exact) {
        return new AltarRecipeBuilder(result, count, exact);
    }

    public AltarRecipeBuilder requires(ItemLike item) {
        return this.requires(Ingredient.of(item));
    }

    public AltarRecipeBuilder requires(Ingredient ingredient) {
        this.ingredients.add(ingredient);
        return this;
    }

    public void save(Consumer<FinishedRecipe> consumer, ResourceLocation id) {
        consumer.accept(new Result(id, this.result, this.count, this.ingredients, this.exact));
    }

    public void save(Consumer<FinishedRecipe> consumer, String saveName) {
        ResourceLocation mainId = ForgeRegistries.ITEMS.getKey(this.result);
        save(consumer, new ResourceLocation(mainId.getNamespace(), "altar_crafting/" + saveName));
    }

    // Dynamic inner class that compiles the data properties into structured JSON fields
    private static class Result implements FinishedRecipe {
        private final ResourceLocation id;
        private final Item result;
        private final int count;
        private final List<Ingredient> ingredients;
        private final boolean exact;

        public Result(ResourceLocation id, Item result, int count, List<Ingredient> ingredients, boolean exact) {
            this.id = id;
            this.result = result;
            this.count = count;
            this.ingredients = ingredients;
            this.exact = exact;
        }

        @Override
        public void serializeRecipeData(JsonObject json) {
            json.addProperty("exact", this.exact);

            JsonArray jsonIngredients = new JsonArray();
            for (Ingredient ingredient : this.ingredients) {
                jsonIngredients.add(ingredient.toJson());
            }
            json.add("ingredients", jsonIngredients);

            JsonObject jsonOutput = new JsonObject();
            jsonOutput.addProperty("item", ForgeRegistries.ITEMS.getKey(this.result).toString());
            if (this.count > 1) {
                jsonOutput.addProperty("count", this.count);
            }
            json.add("output", jsonOutput);
        }

        @Override
        public ResourceLocation getId() {
            return this.id;
        }

        @Override
        public RecipeSerializer<?> getType() {
            return AltarRecipe.Serializer.INSTANCE;
        }

        @Nullable
        @Override
        public JsonObject serializeAdvancement() {
            return null; // Opting out of mandatory advancement unlocking criteria for simplicity
        }

        @Nullable
        @Override
        public ResourceLocation getAdvancementId() {
            return null;
        }
    }
}
