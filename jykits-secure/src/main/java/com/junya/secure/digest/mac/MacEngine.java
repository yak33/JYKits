package com.junya.secure.digest.mac;

import com.junya.core.io.IoUtil;

import java.io.InputStream;

/**
 * MAC（Message Authentication Code）算法引擎
 * 
 * @author zhangchao
 * @since 2.0.2
 */
public interface MacEngine {
	
	/**
	 * 生成摘要
	 * 
	 * @param data {@link InputStream} 数据流
	 * @param bufferLength 缓存长度，不足1使用 {@link IoUtil#DEFAULT_BUFFER_SIZE} 做为默认值
	 * @return 摘要bytes
	 */
	byte[] digest(InputStream data, int bufferLength);
}
