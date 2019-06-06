package com.company.pizzaplace.web.screens.customer;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Customer;

@UiController("pizzaplace_Customer.browse")
@UiDescriptor("customer-browse.xml")
@LookupComponent("customersTable")
@LoadDataBeforeShow
public class CustomerBrowse extends StandardLookup<Customer> {
}