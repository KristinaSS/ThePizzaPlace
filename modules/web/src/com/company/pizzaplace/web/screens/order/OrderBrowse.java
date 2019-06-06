package com.company.pizzaplace.web.screens.order;

import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Order;

import javax.inject.Inject;

@UiController("pizzaplace_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {

}