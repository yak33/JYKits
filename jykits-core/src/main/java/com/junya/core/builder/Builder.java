package com.junya.core.builder;

import java.io.Serializable;

/**
 * 建造者模式接口定义
 * 
 * @param <T> 建造对象类型
 * @author zhangchao
 * @since 2.0.3
 */
public interface Builder<T> extends Serializable{
	/**
	 * 构建
	 * 
	 * @return 被构建的对象
	 */
	T build();
}