package com.junya.core.convert.impl;

import java.util.concurrent.atomic.AtomicBoolean;

import com.junya.core.convert.AbstractConverter;
import com.junya.core.util.BooleanUtil;

/**
 * {@link AtomicBoolean}转换器
 * 
 * @author zhangchao
 * @since 2.0.3
 */
public class AtomicBooleanConverter extends AbstractConverter<AtomicBoolean> {
	private static final long serialVersionUID = 1L;

	@Override
	protected AtomicBoolean convertInternal(Object value) {
		if (boolean.class == value.getClass()) {
			return new AtomicBoolean((boolean) value);
		}
		if (value instanceof Boolean) {
			return new AtomicBoolean((Boolean) value);
		}
		final String valueStr = convertToStr(value);
		return new AtomicBoolean(BooleanUtil.toBoolean(valueStr));
	}

}
