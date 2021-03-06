package com.citytechinc.cq.component.annotations.widgets;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * Represents a Widget of type CQ.Ext.form.DateField in Classic UI
 * <p>
 * Represents a Widget of type granite/ui/components/foundation/form/datepicker
 * in Touch UI
 */
@Retention(RetentionPolicy.CLASS)
@Target({ ElementType.FIELD, ElementType.METHOD })
public @interface DateField {

    /**
     * Used for Classic UI only
     * <p>
     * Day index at which the week should begin, 0-based
     *
     * @return int
     */
    int startDay() default 0;

    /**
     * Used for Classic UI only
     * <p>
     * false to hide the footer area of the DatePicker containing the Today
     * button and disable the keyboard handler for spacebar that selects the
     * current date
     *
     * @return boolean
     */
    boolean showToday() default true;

    /**
     * Used for Classic UI only
     * <p>
     * The default date format string which can be overriden for localization
     * support. The format must be valid according to <a href=
     * "http://dev.day.com/docs/en/cq/5-6/widgets-api/output/Date.html#parseDate"
     * >Date.parseDate</a>
     *
     * @return String
     */
    String format() default "m/d/Y";

    /**
     * For Touch-UI only
     * <p>
     * Similar to format but uses a different standard for specifying date
     * formats.
     *
     * @return String
     */
    String storedFormat() default "YYYY-MM-DD[T]HH:mm:ss.000Z";

    /**
     * For Touch-UI Coral3 only
     * <p>
     * Similar to format but uses a different standard for specifying date
     * formats.
     *
     * @return String
     */
    String valueFormat() default "YYYY-MM-DD[T]HH:mm:ss.000Z";

    /**
     * For Touch-UI only
     * <p>
     * Display format for the date selected
     *
     * @return String
     */
    String displayedFormat() default "MM/DD/YYYY";

    /**
     * For Touch-UI only
     * <p>
     * The minimum selectable date
     *
     * @return String
     */
    String minDate() default "";

    /**
     * For Touch-UI only
     * <p>
     * The maximum selectable date
     *
     * @return String
     */
    String maxDate() default "";
}