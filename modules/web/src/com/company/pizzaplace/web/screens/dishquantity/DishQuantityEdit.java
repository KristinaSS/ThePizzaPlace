package com.company.pizzaplace.web.screens.dishquantity;

import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.components.TextInputField;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.DishQuantity;

import javax.inject.Inject;
import java.math.BigDecimal;

@UiController("pizzaplace_DishQuantity.edit")
@UiDescriptor("dish-quantity-edit.xml")
@EditedEntityContainer("dishQuantityDc")
@LoadDataBeforeShow
public class DishQuantityEdit extends StandardEditor<DishQuantity> {

    @Inject
    private TextField<BigDecimal> quantityField;

    @Subscribe("quantityField")
    private void onQuantityFieldTextChange(TextInputField.TextChangeEvent event) {
        /*if(quantityField.getValue().equals(BigDecimal.ZERO)||(quantityField.getValue().compareTo(BigDecimal.ZERO)<0)){
            getEditedEntity().setQuantity(BigDecimal.ONE);
        }*/
    }


}