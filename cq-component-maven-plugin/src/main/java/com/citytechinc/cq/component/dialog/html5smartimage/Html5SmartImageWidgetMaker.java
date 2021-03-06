package com.citytechinc.cq.component.dialog.html5smartimage;

import com.citytechinc.cq.component.AspectRatioParameters;
import com.citytechinc.cq.component.AspectRatios;
import com.citytechinc.cq.component.AspectRatiosParameters;
import com.citytechinc.cq.component.annotations.AspectRatio;
import com.citytechinc.cq.component.annotations.widgets.Html5SmartImage;
import com.citytechinc.cq.component.dialog.DialogElement;
import com.citytechinc.cq.component.dialog.maker.AbstractWidgetMaker;
import com.citytechinc.cq.component.dialog.maker.WidgetMakerParameters;
import org.codehaus.plexus.util.StringUtils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Html5SmartImageWidgetMaker extends AbstractWidgetMaker<Html5SmartImageWidgetParameters> {

    public static final String ASPECT_RATIO_PREFIX = "aspectRatio";

    public static final String DEFAULT_CROP_PARAMETER = "imageCrop";

    public static final String DEFAULT_ROTATE_PARAMETER = "imageRotate";

    public static final String DEFAULT_MAP_PARAMETER = "imageMap";

    public static final String FILE_REFERENCE_PARAMETER = "fileReference";

    public static final String FILE_NAME_PARAMETER = "fileName";

    public Html5SmartImageWidgetMaker(WidgetMakerParameters parameters) {
        super(parameters);
    }

    @Override
    public DialogElement make(Html5SmartImageWidgetParameters parameters) throws ClassNotFoundException {

        Html5SmartImage smartImageAnnotation = getAnnotation(Html5SmartImage.class);

        parameters.setName(getNameForField(smartImageAnnotation));
        parameters.setIsSelf(getIsSelfForField(smartImageAnnotation));
        parameters.setDisableFlush(getDisableFlushForField(smartImageAnnotation));
        parameters.setDisableInfo(getDisableInfoForField(smartImageAnnotation));
        parameters.setDisableZoom(getDisableZoomForField(smartImageAnnotation));
        parameters.setCropParameter(getCropParameterForField(smartImageAnnotation));
        parameters.setFileNameParameter(FILE_NAME_PARAMETER);
        parameters.setFileReferenceParameter(FILE_REFERENCE_PARAMETER);
        parameters.setMapParameter(getMapParameterForField(smartImageAnnotation));
        parameters.setRotateParameter(getRotateParameterForField(smartImageAnnotation));
        parameters.setUploadUrl(getUploadUrlForField(smartImageAnnotation));
        parameters.setDdGroups(getDdGroupsForField(smartImageAnnotation));
        parameters.setAllowUpload(getAllowUploadForField(smartImageAnnotation));
        parameters.setHeight(getHeightForField(smartImageAnnotation));
        parameters.setTab(smartImageAnnotation.tab());

        List<DialogElement> children = new ArrayList<DialogElement>();

        if (smartImageAnnotation.cropAspectRatios().length > 0) {
            children.add(buildCropConfig(smartImageAnnotation.cropAspectRatios()));
        }

        parameters.setContainedElements(children);

        return new Html5SmartImageWidget(parameters);

    }

    protected String getNameForField(Html5SmartImage smartImageAnnotation) {
        if (smartImageAnnotation.isSelf()) {
            if (parameters.isUseDotSlashInName()) {
                return "./";
            }
            return "";
        } else {
            return getNameForField();
        }
    }

    protected String getCropParameterForField(Html5SmartImage smartImageAnnotation) {
        if (smartImageAnnotation.allowCrop()) {
            return DEFAULT_CROP_PARAMETER;
        }

        return null;
    }

    protected String getMapParameterForField(Html5SmartImage smartImageAnnotation) {
        if (smartImageAnnotation.allowMap()) {
            return DEFAULT_MAP_PARAMETER;
        }

        return null;
    }

    protected String getRotateParameterForField(Html5SmartImage smartImageAnnotation) {
        if (smartImageAnnotation.allowRotate()) {
            return DEFAULT_ROTATE_PARAMETER;
        }

        return null;
    }

    protected String getUploadUrlForField(Html5SmartImage smartImageAnnotation) {
        String uploadUrl = smartImageAnnotation.uploadUrl();
        if (StringUtils.isNotEmpty(uploadUrl)) {
            return uploadUrl;
        }

        return null;
    }

    protected String getDdGroupsForField(Html5SmartImage smartImageAnnotation) {

        if (smartImageAnnotation.ddGroups().length != 0) {
            return "[" + StringUtils.join(smartImageAnnotation.ddGroups(), ",") + "]";
        }

        return null;

    }

    protected Integer getHeightForField(Html5SmartImage smartImageAnnotation) {
        Integer height = smartImageAnnotation.height();

        if (height != 0) {
            return height;
        }

        return null;
    }

    protected boolean getIsSelfForField(Html5SmartImage smartImageAnnotation) {
        return smartImageAnnotation.isSelf();
    }

    protected boolean getDisableFlushForField(Html5SmartImage smartImageAnnotation) {
        return smartImageAnnotation.disableFlush();
    }

    protected boolean getDisableInfoForField(Html5SmartImage smartImageAnnotation) {
        return smartImageAnnotation.disableInfo();
    }

    protected boolean getDisableZoomForField(Html5SmartImage smartImageAnnotation) {
        return smartImageAnnotation.disableZoom();
    }

    protected boolean getAllowUploadForField(Html5SmartImage smartImageAnnotation) {
        return smartImageAnnotation.allowUpload();
    }

    protected CropConfig buildCropConfig(AspectRatio[] cropAspectRatios) {
        List<com.citytechinc.cq.component.AspectRatio> aspectRatioList =
            new ArrayList<com.citytechinc.cq.component.AspectRatio>();
        int count = 0;
        for (AspectRatio cropAspectRatio : cropAspectRatios) {
            AspectRatioParameters arp = new AspectRatioParameters();
            arp.setText(cropAspectRatio.text());
            arp.setWidth(cropAspectRatio.width());
            arp.setHeight(cropAspectRatio.height());
            arp.setFieldName(ASPECT_RATIO_PREFIX + count++);
            com.citytechinc.cq.component.AspectRatio aspectRatio =
                new com.citytechinc.cq.component.AspectRatio(arp);
            aspectRatioList.add(aspectRatio);
        }

        AspectRatiosParameters arp = new AspectRatiosParameters();
        arp.setContainedElements(aspectRatioList);
        AspectRatios aspectRatios = new AspectRatios(arp);

        CropConfigParameters ccp = new CropConfigParameters();
        ccp.setContainedElements(Arrays.asList(aspectRatios));

        return new CropConfig(ccp);
    }
}
