package com.company.pizzaplace.web.screens.delivered;

import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Delivered;

@UiController("pizzaplace_Delivered.browse")
@UiDescriptor("delivered-browse.xml")
@LookupComponent("deliveredsTable")
@LoadDataBeforeShow
public class DeliveredBrowse extends StandardLookup<Delivered> {
}