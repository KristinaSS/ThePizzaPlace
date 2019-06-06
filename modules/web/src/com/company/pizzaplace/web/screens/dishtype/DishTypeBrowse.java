package com.company.pizzaplace.web.screens.dishtype;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.DishType;

@UiController("pizzaplace_DishType.browse")
@UiDescriptor("dish-type-browse.xml")
@LookupComponent("dishTypesTable")
@LoadDataBeforeShow
public class DishTypeBrowse extends StandardLookup<DishType> {
}