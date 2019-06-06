package com.company.pizzaplace.web.screens.ingredient;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Ingredient;

@UiController("pizzaplace_Ingredients.browse")
@UiDescriptor("ingredient-browse.xml")
@LookupComponent("ingredientsTable")
@LoadDataBeforeShow
public class IngredientBrowse extends StandardLookup<Ingredient> {
}