package com.cysion.okhttpdemo;

import java.lang.annotation.Retention;
import java.lang.annotation.Target;

import static java.lang.annotation.ElementType.ANNOTATION_TYPE;
import static java.lang.annotation.RetentionPolicy.SOURCE;

/**
 * Created by Cysion Liu on 2017/9/5.
 */
@Retention(SOURCE)
@Target({ANNOTATION_TYPE})
public @interface OnlyInt {
    /**
     * Defines the allowed constants for this element
     */
    long[] value() default {};

    int vi() default 0;

}
