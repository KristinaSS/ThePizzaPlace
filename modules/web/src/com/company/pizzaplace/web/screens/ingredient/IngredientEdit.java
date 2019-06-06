package com.company.pizzaplace.web.screens.ingredient;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Ingredient;

@UiController("pizzaplace_Ingredients.edit")
@UiDescriptor("ingredient-edit.xml")
@EditedEntityContainer("ingredientDc")
@LoadDataBeforeShow
public class IngredientEdit extends StandardEditor<Ingredient> {
}