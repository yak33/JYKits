package com.junya.core.convert.impl;

import com.junya.core.convert.AbstractConverter;

/**
 * 无泛型检查的枚举转换器
 * 
 * @author zhangchao
 * @since 2.0.3
 */
@SuppressWarnings({ "unchecked", "rawtypes" })
public class EnumConverter extends AbstractConverter<Object> {
	private static final long serialVersionUID = 1L;

	private Class enumClass;
	
	/**
	 * 构造
	 * 
	 * @param enumClass 转换成的目标Enum类
	 */
	public EnumConverter(Class enumClass) {
		this.enumClass = enumClass;
	}

	@Override
	protected Object convertInternal(Object value) {
		return Enum.valueOf(enumClass, convertToStr(value));
	}

	@Override
	public Class getTargetType() {
		return this.enumClass;
	}
}
