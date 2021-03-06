package com.junya.core.convert.impl;

import com.junya.core.convert.AbstractConverter;

import java.util.Optional;

/**
 * 
 * {@link Optional}对象转换器
 * 
 * @author zhangchao
 * @since 2.0.3
 */
public class OptionalConverter extends AbstractConverter<Optional<?>> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Optional<?> convertInternal(Object value) {
		return Optional.ofNullable(value);
	}

}
