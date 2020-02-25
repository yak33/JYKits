package com.junya.http;

import java.io.Serializable;
import java.net.CookieManager;

import com.junya.http.cookie.GlobalCookieManager;

/**
 * HTTP 全局参数配置
 * 
 * @author zhangchao
 * @since 2.0.3
 */
public class HttpGlobalConfig implements Serializable {
	private static final long serialVersionUID = 1L;

	protected static int timeout = -1;

	/**
	 * 获取全局默认的超时时长
	 * 
	 * @return 全局默认的超时时长
	 */
	public static int getTimeout() {
		return timeout;
	}

	/**
	 * 设置默认的连接和读取超时时长
	 * 
	 * @param customTimeout 超时时长
	 */
	public static void setTimeout(int customTimeout) {
		timeout = customTimeout;
	}
	
	/**
	 * 获取Cookie管理器，用于自定义Cookie管理
	 * 
	 * @return {@link CookieManager}
	 * @since 2.0.3
	 * @see GlobalCookieManager#getCookieManager()
	 */
	public static CookieManager getCookieManager() {
		return GlobalCookieManager.getCookieManager();
	}

	/**
	 * 自定义{@link CookieManager}
	 * 
	 * @param customCookieManager 自定义的{@link CookieManager}
	 * @since 2.0.3
	 * @see GlobalCookieManager#setCookieManager(CookieManager)
	 */
	public static void setCookieManager(CookieManager customCookieManager) {
		GlobalCookieManager.setCookieManager(customCookieManager);
	}
	
	/**
	 * 关闭Cookie
	 * 
	 * @since 2.0.3
	 * @see GlobalCookieManager#setCookieManager(CookieManager)
	 */
	public static void closeCookie() {
		GlobalCookieManager.setCookieManager(null);
	}
}
