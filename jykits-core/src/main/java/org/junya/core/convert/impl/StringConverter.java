package org.junya.core.convert.impl;

import org.junya.core.convert.AbstractConverter;

/**
 * 字符串转换器
 * @author Looly
 *
 */
public class StringConverter extends AbstractConverter<String>{
	private static final long serialVersionUID = 1L;

	@Override
	protected String convertInternal(Object value) {
		return convertToStr(value);
	}

}
