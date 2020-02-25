package com.junya.core.clone;

import com.junya.core.exceptions.ExceptionUtil;
import com.junya.core.util.StringUtil;

/**
 * 克隆异常
 * @author zhangchao
 */
public class CloneRuntimeException extends RuntimeException{
	private static final long serialVersionUID = 6774837422188798989L;

	public CloneRuntimeException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}
	
	public CloneRuntimeException(String message) {
		super(message);
	}
	
	public CloneRuntimeException(String messageTemplate, Object... params) {
		super(StringUtil.format(messageTemplate, params));
	}
	
	public CloneRuntimeException(String message, Throwable throwable) {
		super(message, throwable);
	}
	
	public CloneRuntimeException(Throwable throwable, String messageTemplate, Object... params) {
		super(StringUtil.format(messageTemplate, params), throwable);
	}
}
