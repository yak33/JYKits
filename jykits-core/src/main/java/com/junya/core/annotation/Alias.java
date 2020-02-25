package com.junya.core.annotation;

import java.lang.annotation.*;

/**
 * 别名注解，使用此注解的字段、方法、参数等会有一个别名，用于Bean拷贝、Bean转Map等
 *
 * @author zhangchao
 * @since 2.1.3
 */
@Documented
@Retention(RetentionPolicy.RUNTIME)
@Target({ElementType.METHOD, ElementType.FIELD, ElementType.PARAMETER})
public @interface Alias {
	String value();
}
