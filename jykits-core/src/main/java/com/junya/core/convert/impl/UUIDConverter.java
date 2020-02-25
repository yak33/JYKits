package com.junya.core.convert.impl;

import java.util.UUID;

import com.junya.core.convert.AbstractConverter;

/**
 * UUID对象转换器转换器
 * 
 * @author zhangchao
 * @since 2.0.3
 *
 */
public class UUIDConverter extends AbstractConverter<UUID> {
	private static final long serialVersionUID = 1L;

	@Override
	protected UUID convertInternal(Object value) {
		return UUID.fromString(convertToStr(value));
	}

}
