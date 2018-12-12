package com.citytechinc.cq.component.annotations.widgets;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents a Widget of type CQ.Ext.form.TextArea in Classic UI
 *
 * Represents a Widget of type granite/ui/components/foundation/form/textarea in
 * Touch UI
 */
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface TextArea {

	public static final String RESIZE_NONE = "none";
	public static final String RESIZE_BOTH = "both";
	public static final String RESIZE_HORIZONTAL = "horizontal";
	public static final String RESIZE_VERTICAL = "vertical";

	/**
	 * Used for Touch UI only
	 *
	 * Dictates the number of columns to initially present for this text area.
	 *
	 * @return int
	 */
	int cols() default -1;

	/**
	 * Used for Touch UI only
	 *
	 * Dictates the number of rows to initially present for this text area.
	 *
	 * @return int
	 */
	int rows() default 5;

	/**
	 * Used for Touch UI only
	 *
	 * Dictates the type of resizing used for this Widget. Valid types are
	 * "none", "both", "horizontal" and "vertical".
	 *
	 * @return String
	 */
	String resize() default RESIZE_NONE;

}
