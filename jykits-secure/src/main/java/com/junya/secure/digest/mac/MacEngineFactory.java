package com.junya.secure.digest.mac;

import com.junya.secure.SmUtil;
import com.junya.secure.digest.HmacAlgorithm;

import javax.crypto.SecretKey;

/**
 * {@link MacEngine} 实现工厂类
 * 
 * @author zhangchao
 * @since 2.0.2
 */
public class MacEngineFactory {
	
	/**
	 * 根据给定算法和密钥生成对应的{@link MacEngine}
	 * @param algorithm 算法，见{@link HmacAlgorithm}
	 * @param key 密钥
	 * @return {@link MacEngine}
	 */
	public static MacEngine createEngine(String algorithm, SecretKey key) {
		if(algorithm.equalsIgnoreCase(HmacAlgorithm.HmacSM3.getValue())) {
			// HmacSM3算法是BC库实现的
			return SmUtil.createHmacSm3Engine(key.getEncoded());
		}
		return new DefaultHMacEngine(algorithm, key);
	}
}
