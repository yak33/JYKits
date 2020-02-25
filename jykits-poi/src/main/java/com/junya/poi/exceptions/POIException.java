package com.junya.poi.exceptions;

import com.junya.core.exceptions.ExceptionUtil;
import com.junya.core.util.StringUtil;

/**
 * POI异常
 * @author zhangchao
 */
public class POIException extends RuntimeException{
	private static final long serialVersionUID = 2711633732613506552L;

	public POIException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}
	
	public POIException(String message) {
		super(message);
	}
	
	public POIException(String messageTemplate, Object... params) {
		super(StringUtil.format(messageTemplate, params));
	}
	
	public POIException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public POIException(Throwable throwable, String messageTemplate, Object... params) {
		super(StringUtil.format(messageTemplate, params), throwable);
	}
}
