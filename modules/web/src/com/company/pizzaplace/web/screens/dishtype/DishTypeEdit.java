package com.company.pizzaplace.web.screens.dishtype;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.DishType;

@UiController("pizzaplace_DishType.edit")
@UiDescriptor("dish-type-edit.xml")
@EditedEntityContainer("dishTypeDc")
@LoadDataBeforeShow
public class DishTypeEdit extends StandardEditor<DishType> {
}