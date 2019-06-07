package com.company.pizzaplace.web.screens.dish;

import com.company.pizzaplace.entity.Ingredient;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.GroupTable;
import com.haulmont.cuba.gui.components.actions.BaseAction;
import com.haulmont.cuba.gui.model.CollectionContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Dish;

import javax.inject.Inject;
import java.util.ArrayList;
import java.util.List;

@UiController("pizzaplace_Dish.browse")
@UiDescriptor("dish-browse.xml")
@LookupComponent("dishesTable")
@LoadDataBeforeShow
public class DishBrowse extends StandardLookup<Dish> {


    @Inject
    private GroupTable<Dish> dishesTable;
    @Inject
    private Notifications notifications;


    @Subscribe
    private void onInit(InitEvent event) {
        dishesTable.setItemClickAction(new BaseAction("seeIngredients").withHandler(actionPerformedEvent ->
        {
            Dish dish = dishesTable.getSingleSelected();
            assert dish != null;
            List<String> stringList = new ArrayList<>();
            for(Ingredient ingredient : dish.getIngredients()){
                stringList.add(ingredient.toString());
            }
            notifications.create().withCaption("Ingedients: " + stringList).show();
        }));
    }


}