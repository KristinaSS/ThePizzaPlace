package com.company.pizzaplace.web.screens.delivered;

import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Delivered;

import javax.inject.Inject;
import java.time.LocalDateTime;

@UiController("pizzaplace_Delivered.edit")
@UiDescriptor("delivered-edit.xml")
@EditedEntityContainer("deliveredDc")
@LoadDataBeforeShow
public class DeliveredEdit extends StandardEditor<Delivered> {
    @Inject
    private DataManager dataManager;

    @Subscribe
        private void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
            getEditedEntity().getOrder().setDeliveryTime(LocalDateTime.now());
            getEditedEntity().getOrder().setIsDelivered(true);
            if(getEditedEntity().getOrder().getCustomer()!= null)
                getEditedEntity().getOrder().getCustomer().setNumberOfOrders(getEditedEntity().getOrder().getCustomer().getNumberOfOrders()+1);
            getScreenData().getDataContext().commit();
            dataManager.commit(getEditedEntity().getOrder().getCustomer());
            dataManager.commit(getEditedEntity().getOrder());
            dataManager.commit(getEditedEntity());
        }
}