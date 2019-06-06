package com.company.pizzaplace.web.screens.dish;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Dish;

@UiController("pizzaplace_Dish.edit")
@UiDescriptor("dish-edit.xml")
@EditedEntityContainer("dishDc")
@LoadDataBeforeShow
public class DishEdit extends StandardEditor<Dish> {
}