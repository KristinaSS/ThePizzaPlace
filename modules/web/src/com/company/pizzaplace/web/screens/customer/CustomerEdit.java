package com.company.pizzaplace.web.screens.customer;

import com.haulmont.cuba.gui.components.TextField;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Customer;

import javax.inject.Inject;

@UiController("pizzaplace_Customer.edit")
@UiDescriptor("customer-edit.xml")
@EditedEntityContainer("customerDc")
@LoadDataBeforeShow
public class CustomerEdit extends StandardEditor<Customer> {

    @Inject
    private TextField<Integer> numberOfOrdersField;

    @Subscribe
    private void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        if(numberOfOrdersField.getValue() == null){
            getEditedEntity().setNumberOfOrders(0);
        }
    }

}