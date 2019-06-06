package com.company.pizzaplace.web.screens.dish;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Dish;

@UiController("pizzaplace_Dish.browse")
@UiDescriptor("dish-browse.xml")
@LookupComponent("dishesTable")
@LoadDataBeforeShow
public class DishBrowse extends StandardLookup<Dish> {
}