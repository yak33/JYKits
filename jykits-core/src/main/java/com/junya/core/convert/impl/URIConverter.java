package com.junya.core.convert.impl;

import java.io.File;
import java.net.URI;
import java.net.URL;

import com.junya.core.convert.AbstractConverter;

/**
 * URI对象转换器
 * @author zhangchao
 *
 */
public class URIConverter extends AbstractConverter<URI>{
	private static final long serialVersionUID = 1L;

	@Override
	protected URI convertInternal(Object value) {
		try {
			if(value instanceof File){
				return ((File)value).toURI();
			}
			
			if(value instanceof URL){
				return ((URL)value).toURI();
			}
			return new URI(convertToStr(value));
		} catch (Exception e) {
			// Ignore Exception
		}
		return null;
	}

}
