package com.company.pizzaplace.web.screens.dish;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.*;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
import com.haulmont.cuba.gui.model.InstancePropertyContainer;
import com.haulmont.cuba.gui.screen.*;
import com.company.pizzaplace.entity.Dish;
import com.haulmont.cuba.gui.upload.FileUploadingAPI;

import javax.inject.Inject;

@UiController("pizzaplace_Dish.edit")
@UiDescriptor("dish-edit.xml")
@EditedEntityContainer("dishDc")
@LoadDataBeforeShow
public class DishEdit extends StandardEditor<Dish> {
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private InstancePropertyContainer<FileDescriptor> pictureDC;
    @Inject
    private Image dishPic;
    @Inject
    private Button clearBtn;
    @Inject
    private FileUploadField upload;

    @Subscribe("upload")
    private void onUploadFileUploadSucceed(FileUploadField.FileUploadSucceedEvent event) {
        try {
            FileDescriptor fileDescriptor = upload.getFileDescriptor();
            fileUploadingAPI.putFileIntoStorage(upload.getFileId(),fileDescriptor);
            FileDescriptor savedFile = dataManager.commit(fileDescriptor);
            getEditedEntity().setDishPhoto(savedFile);
        }catch (FileStorageException e){
            notifications.create(Notifications.NotificationType.ERROR).withCaption(e.getMessage()).show();
        }
        refreshPhoto();
    }
    private void refreshPhoto(){
        boolean hasPhoto = getEditedEntity().getDishPhoto() != null;
        if(hasPhoto){
            dishPic.setScaleMode(Image.ScaleMode.CONTAIN);
            dishPic.setHeight("400px");
            dishPic.setWidth("400px");
            dishPic.setSource(FileDescriptorResource.class)
                    .setFileDescriptor(getEditedEntity().getDishPhoto());

        }
        dishPic.setVisible(hasPhoto);
        clearBtn.setEnabled(hasPhoto);
    }

    @Subscribe("clearBtn")
    private void onClearBtnClick(Button.ClickEvent event) {
        getEditedEntity().setDishPhoto(null);
        refreshPhoto();
    }

    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        refreshPhoto();
    }

}