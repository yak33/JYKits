package com.junya.json;

import com.junya.core.exceptions.ExceptionUtil;
import com.junya.core.util.StrUtil;

/**
 * JSON异常
 *
 * @author looly
 * @since 3.0.2
 */
public class JSONException extends RuntimeException {
	private static final long serialVersionUID = 0;
	
	public JSONException(Throwable e) {
		super(ExceptionUtil.getMessage(e), e);
	}

	public JSONException(String message) {
		super(message);
	}
	
	public JSONException(String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params));
	}

	public JSONException(String message, Throwable cause) {
		super(message, cause);
	}

	public JSONException(Throwable throwable, String messageTemplate, Object... params) {
		super(StrUtil.format(messageTemplate, params), throwable);
	}
}
