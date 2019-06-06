package com.company.pizzaplace.web.screens.order;

import com.company.pizzaplace.entity.Delivered;
import com.company.pizzaplace.web.screens.delivered.DeliveredEdit;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.gui.*;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Order;
import com.haulmont.cuba.gui.screen.LookupComponent;
import com.vaadin.event.dd.acceptcriteria.Or;

import javax.inject.Inject;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@UiController("pizzaplace_Order.browse")
@UiDescriptor("order-browse.xml")
@LookupComponent("ordersTable")
@LoadDataBeforeShow
public class OrderBrowse extends StandardLookup<Order> {
    @Inject
    private Button deliveryBtn;
    @Inject
    private Screens screens;
    @Inject
    private Notifications notifications;
    @Inject
    private ScreenBuilders screenBuilders;
    @Inject
    private GroupTable<Order> ordersTable;
    @Inject
    private DataManager dataManager;


    @Subscribe("deliveryBtn")
    private void onDeliveryBtnClick(Button.ClickEvent event) {

        Delivered delivered = new Delivered();
        editSelectedEntity(delivered);
    }

    @Subscribe
    private void onInit(InitEvent event) {
        ordersTable.setItemClickAction(new BaseAction("clickItem")
        .withHandler(actionPerformedEvent -> {
            actionOrder();
        }));
        ordersTable.setEnterPressAction(new BaseAction("clickItem1")
                .withHandler(actionPerformedEvent -> {
                    actionOrder();
                }));
    }

    private void editSelectedEntity(Delivered entity) {
        screenBuilders.editor(Delivered.class, this)
                .editEntity(entity)
                .build()
                .show();
    }
    private void actionOrder(){
        Delivered delivered = new Delivered();
        Order order = ordersTable.getSingleSelected();
        delivered.setOrder(order);
        assert order != null;
        if(order.getCustomer()!= null)
            order.getCustomer().setNumberOfOrders(order.getCustomer().getNumberOfOrders()+1);
        order.setIsDelivered(true);
        order.setDeliveryTime(LocalDateTime.now());
        order.setFinalAmount(order.getFinalAmount());
        dataManager.commit(delivered);
        dataManager.commit(order);
        dataManager.commit(order.getCustomer());
        notifications.create().withCaption("Order has been delivered!").show();
    }

}