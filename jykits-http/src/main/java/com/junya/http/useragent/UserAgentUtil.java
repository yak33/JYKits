package com.junya.http.useragent;

/**
 * User-Agent工具类
 * 
 * @author zhangchao
 *
 */
public class UserAgentUtil {

	/**
	 * 解析User-Agent
	 * 
	 * @param userAgentString User-Agent字符串
	 * @return {@link UserAgent}
	 */
	public static UserAgent parse(String userAgentString) {
		return UserAgentParser.parse(userAgentString);
	}
}
