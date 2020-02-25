package com.junya.core.convert.impl;

import com.junya.core.convert.AbstractConverter;

/**
 * 泛型枚举转换器
 * 
 * @param <E> 枚举类类型
 * @author zhangchao
 * @since 2.0.3
 */
public class GenericEnumConverter<E extends Enum<E>> extends AbstractConverter<E> {
	private static final long serialVersionUID = 1L;

	private Class<E> enumClass;
	
	/**
	 * 构造
	 * 
	 * @param enumClass 转换成的目标Enum类
	 */
	public GenericEnumConverter(Class<E> enumClass) {
		this.enumClass = enumClass;
	}

	@Override
	protected E convertInternal(Object value) {
		return Enum.valueOf(enumClass, convertToStr(value));
	}

	@Override
	public Class<E> getTargetType() {
		return this.enumClass;
	}
}
