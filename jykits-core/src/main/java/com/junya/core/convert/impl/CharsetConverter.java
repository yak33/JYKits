package com.junya.core.convert.impl;

import java.nio.charset.Charset;

import com.junya.core.convert.AbstractConverter;
import com.junya.core.util.CharsetUtil;

/**
 * 编码对象转换器
 * @author zhangchao
 *
 */
public class CharsetConverter extends AbstractConverter<Charset>{
	private static final long serialVersionUID = 1L;

	@Override
	protected Charset convertInternal(Object value) {
		return CharsetUtil.charset(convertToStr(value));
	}

}
