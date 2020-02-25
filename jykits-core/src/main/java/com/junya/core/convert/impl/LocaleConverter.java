package com.junya.core.convert.impl;

import java.util.Locale;

import com.junya.core.convert.AbstractConverter;
import com.junya.core.util.StringUtil;

/**
 * 
 * {@link Locale}对象转换器<br>
 * 只提供String转换支持
 * 
 * @author zhangchao
 * @since 2.0.3
 */
public class LocaleConverter extends AbstractConverter<Locale> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Locale convertInternal(Object value) {
		try {
			String str = convertToStr(value);
			if (StringUtil.isEmpty(str)) {
				return null;
			}

			final String[] items = str.split("_");
			if (items.length == 1) {
				return new Locale(items[0]);
			}
			if (items.length == 2) {
				return new Locale(items[0], items[1]);
			}
			return new Locale(items[0], items[1], items[2]);
		} catch (Exception e) {
			// Ignore Exception
		}
		return null;
	}

}
