package com.company.pizzaplace.web.screens.dish;

import com.haulmont.cuba.core.entity.FileDescriptor;
import com.haulmont.cuba.core.global.DataManager;
import com.haulmont.cuba.core.global.FileStorageException;
import com.haulmont.cuba.gui.Notifications;
import com.haulmont.cuba.gui.components.Button;
import com.haulmont.cuba.gui.components.FileDescriptorResource;
import com.haulmont.cuba.gui.components.FileUploadField;
import com.haulmont.cuba.gui.components.Image;
import com.haulmont.cuba.gui.export.ExportDisplay;
import com.haulmont.cuba.gui.export.ExportFormat;
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
    private Button clearFile;
    @Inject
    private Button downloadFile;
    @Inject
    private FileUploadingAPI fileUploadingAPI;
    @Inject
    private DataManager dataManager;
    @Inject
    private Notifications notifications;
    @Inject
    private ExportDisplay exportDisplay;
    @Inject
    private FileUploadField uploadField;
    @Inject
    private Image dishPhoto;

    @Subscribe("uploadField")
    private void onUploadFieldFileUploadSucceed(FileUploadField.FileUploadSucceedEvent event) {
        try {
            FileDescriptor fileDescriptor = uploadField.getFileDescriptor();
            fileUploadingAPI.putFileIntoStorage(uploadField.getFileId(),fileDescriptor);
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
            dishPhoto.setSource(FileDescriptorResource.class).setFileDescriptor(getEditedEntity().getDishPhoto());
        }
        dishPhoto.setVisible(hasPhoto);
        clearFile.setEnabled(hasPhoto);
        downloadFile.setEnabled(hasPhoto);
    }

    @Subscribe("clearFile")
    private void onClearFileClick(Button.ClickEvent event) {
        getEditedEntity().setDishPhoto(null);
        refreshPhoto();
    }

    @Subscribe
    private void onAfterShow(AfterShowEvent event) {
        refreshPhoto();
    }

    @Subscribe("downloadFile")
    private void onDownloadFileClick(Button.ClickEvent event) {
        exportDisplay.show(getEditedEntity().getDishPhoto(), ExportFormat.OCTET_STREAM);
    }
}