package com.company.pizzaplace.web.screens.order;

import com.company.pizzaplace.entity.Customer;
import com.company.pizzaplace.entity.DishQuantity;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.model.CollectionChangeType;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.model.CollectionPropertyContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Order;

import javax.inject.Inject;
import java.math.BigDecimal;
import java.time.LocalDateTime;

@UiController("pizzaplace_Order.edit")
@UiDescriptor("order-edit.xml")
@EditedEntityContainer("orderDc")
@LoadDataBeforeShow
public class OrderEdit extends StandardEditor<Order> {

    private BigDecimal discount = BigDecimal.ZERO;
    @Inject
    private CollectionPropertyContainer<DishQuantity> linesDc;
    @Inject
    private DateField<LocalDateTime> orderTimeField;
    @Inject
    private PickerField<Customer> customerField;
    @Inject
    private TextField<String> nameField;
    @Inject
    private TextField<BigDecimal> discountField;
    @Inject
    private TextField<BigDecimal> amountField;
    @Inject
    private TextField<BigDecimal> finalAmountField;
    @Inject
    private Notifications notifications;
    @Inject
    private Table<DishQuantity> linesTable;


    @Subscribe("customerField")
    private void onCustomerFieldValueChange(HasValue.ValueChangeEvent<Customer> event) {
        getEditedEntity().setName(customerField.getValue().getName());
        nameField.setEditable(false);
    }

    @Subscribe
    private void onInit(InitEvent event) {
        orderTimeField.setValue(null);
        orderTimeField.setEditable(false);
        orderTimeField.setVisible(false);
    }

    @Subscribe
    private void onBeforeCommitChanges(BeforeCommitChangesEvent event) {
        getEditedEntity().setOrderTime(LocalDateTime.now());
    }

    @Subscribe(id = "linesDc", target = Target.DATA_CONTAINER)

    private void onLinesDcCollectionChange(CollectionContainer.CollectionChangeEvent<DishQuantity> event) {
        getEditedEntity().setTotalAmount(BigDecimal.ZERO);
        getEditedEntity().setFinalAmount(BigDecimal.ZERO);

        if (event.getChangeType() != CollectionChangeType.REFRESH) {
            calculateAmount();
        }
        discount = getCustomerDiscount();
        getEditedEntity().setDiscount(discount.multiply(amountField.getValue()));

        discount = getDishNumberDiscount();
        getEditedEntity().setDiscount(discount.multiply(amountField.getValue()));

        getEditedEntity().setFinalAmount(amountField.getValue().subtract(discountField.getValue()));

        if(finalAmountField.getValue().equals(BigDecimal.ZERO)){
            notifications.create().withCaption("You Have have not ordered Anything").show();
        }
    }

    private void calculateAmount() {
        BigDecimal amount = BigDecimal.ZERO;
        for (DishQuantity dq : linesDc.getItems()) {
            amount = amount.add(dq.getQuantity().multiply(dq.getDish().getPrice()));
        }
        getEditedEntity().setTotalAmount(amount);
    }

    private int totalCustumerOrders() {
        if(customerField.getValue()== null)
            return 0;
        int orders = customerField.getValue().getNumberOfOrders();
        if (orders >= 50 && orders < 100)
            return 1;
        if (orders > 100)
            return 2;
        return 0;
    }

    private int numberOfDishes() {
        int counter = 0;

        for (DishQuantity dq : linesDc.getItems()) {
            counter += dq.getQuantity().intValue();
        }
        if (counter >= 3 && counter < 10)
            return 1;
        if (counter >= 10)
            return 2;
        return 0;
    }

    private BigDecimal getCustomerDiscount() {
        if (customerField != null) {
            if (totalCustumerOrders() == 1) {
                return BigDecimal.valueOf(0.15);
            }
            if (totalCustumerOrders() == 2) {
                return BigDecimal.valueOf(0.2);
            }
        }
        return BigDecimal.ZERO;
    }

    private BigDecimal getDishNumberDiscount() {
        if (numberOfDishes() == 1) {
            return BigDecimal.valueOf(0.05);
        }
        if (numberOfDishes() == 2) {
            return BigDecimal.valueOf(0.1);
        }
        return BigDecimal.ZERO;
    }
}