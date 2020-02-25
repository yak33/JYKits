package com.junya.core.convert.impl;

import java.util.Currency;

import com.junya.core.convert.AbstractConverter;

/**
 * 货币{@link Currency} 转换器
 * 
 * @author zhangchao
 * @since 2.0.3
 */
public class CurrencyConverter extends AbstractConverter<Currency> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Currency convertInternal(Object value) {
		return Currency.getInstance(convertToStr(value));
	}

}
