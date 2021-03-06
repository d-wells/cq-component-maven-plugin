package com.citytechinc.cq.component.touchuidialog.layout.maker;

import com.citytechinc.cq.component.touchuidialog.widget.registry.TouchUIWidgetRegistry;
import javassist.ClassPool;
import javassist.CtClass;

public class LayoutMakerParameters {

    private CtClass componentClass;

    private ClassLoader classLoader;

    private ClassPool classPool;

    private TouchUIWidgetRegistry widgetRegistry;

    private String touchUIDialogType;

    public CtClass getComponentClass() {
        return componentClass;
    }

    public void setComponentClass(CtClass componentClass) {
        this.componentClass = componentClass;
    }

    public ClassLoader getClassLoader() {
        return classLoader;
    }

    public void setClassLoader(ClassLoader classLoader) {
        this.classLoader = classLoader;
    }

    public ClassPool getClassPool() {
        return classPool;
    }

    public void setClassPool(ClassPool classPool) {
        this.classPool = classPool;
    }

    public TouchUIWidgetRegistry getWidgetRegistry() {
        return widgetRegistry;
    }

    public void setWidgetRegistry(TouchUIWidgetRegistry widgetRegistry) {
        this.widgetRegistry = widgetRegistry;
    }

    public String getTouchUIDialogType() {
        return touchUIDialogType;
    }

    public void setTouchUIDialogType(String touchUIDialogType) {
        this.touchUIDialogType = touchUIDialogType;
    }
}