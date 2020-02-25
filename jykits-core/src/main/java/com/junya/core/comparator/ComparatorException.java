package com.junya.core.comparator;

import com.junya.core.exceptions.ExceptionUtil;
import com.junya.core.util.StringUtil;

/**
 * 比较异常
 * @author zhangchao
 */
public class ComparatorException extends RuntimeException{
	private static final long serialVersionUID = 4475602435485521971L;

	public ComparatorException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}
	
	public ComparatorException(String message) {
		super(message);
	}
	
	public ComparatorException(String messageTemplate, Object... params) {
		super(StringUtil.format(messageTemplate, params));
	}
	
	public ComparatorException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public ComparatorException(Throwable throwable, String messageTemplate, Object... params) {
		super(StringUtil.format(messageTemplate, params), throwable);
	}
}
