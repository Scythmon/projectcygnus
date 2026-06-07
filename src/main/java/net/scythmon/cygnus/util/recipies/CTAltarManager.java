package net.scythmon.cygnus.util.recipies;

import com.blamejared.crafttweaker.api.CraftTweakerAPI;
import com.blamejared.crafttweaker.api.action.recipe.ActionAddRecipe;
import com.blamejared.crafttweaker.api.annotation.ZenRegister;
import com.blamejared.crafttweaker.api.ingredient.IIngredient;
import com.blamejared.crafttweaker.api.item.IItemStack;
import com.blamejared.crafttweaker.api.recipe.manager.base.IRecipeManager;
import net.minecraft.core.NonNullList;
import net.minecraft.resources.ResourceLocation;
import net.minecraft.world.item.crafting.Ingredient;
import net.minecraft.world.item.crafting.RecipeType;
import org.openzen.zencode.java.ZenCodeType;

@ZenRegister
@ZenCodeType.Name("mods.projectcygnus.Altar")
public class CTAltarManager implements IRecipeManager<AltarRecipe> {

    public static final CTAltarManager INSTANCE = new CTAltarManager();

    private CTAltarManager() {}

    /**
     * Exposes the addRecipe method to ZenScript.
     * Usage in script: mods.projectcygnus.Altar.addRecipe("recipe_name", output, [ingredients], exact);
     */
    @ZenCodeType.Method
    public void addRecipe(String name, IItemStack output, IIngredient[] ingredients, boolean exact) {
        String fixedName = fixRecipeName(name);
        ResourceLocation recipeId = new ResourceLocation("crafttweaker", fixedName);

        NonNullList<Ingredient> convertedIngredients = NonNullList.create();
        for (IIngredient ing : ingredients) {
            convertedIngredients.add(ing.asVanillaIngredient());
        }

        AltarRecipe recipe = new AltarRecipe(recipeId, output.getInternal(), convertedIngredients, exact);

        CraftTweakerAPI.apply(new ActionAddRecipe<>(this, recipe));
    }

    @Override
    public RecipeType<AltarRecipe> getRecipeType() {
        return AltarRecipe.Type.INSTANCE;
    }
}
