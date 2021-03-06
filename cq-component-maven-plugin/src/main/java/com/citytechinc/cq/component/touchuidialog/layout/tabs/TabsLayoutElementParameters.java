package com.citytechinc.cq.component.touchuidialog.layout.tabs;

import com.citytechinc.cq.component.touchuidialog.TouchUIDialogType;
import com.citytechinc.cq.component.touchuidialog.layout.LayoutElementParameters;

public class TabsLayoutElementParameters extends LayoutElementParameters {

    private String type;

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public String getResourceType() {
        if (TouchUIDialogType.CORAL3.isOfType(getTouchUIDialogType())) {
            return TabsLayoutElement.RESOURCE_TYPE_CORAL3;
        }
        return TabsLayoutElement.RESOURCE_TYPE;
    }

    @Override
    public void setResourceType(String resourceType) {
        throw new UnsupportedOperationException("resource type is Static for Tabs Layout Element");
    }

}
