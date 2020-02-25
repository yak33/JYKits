package com.junya.http.useragent;

import java.util.List;

import com.junya.core.collection.CollectionUtil;

/**
 * 引擎对象
 * 
 * @author zhangchao
 * @since 2.0.3
 */
public class Engine extends UserAgentInfo {
	
	/** 未知 */
	public static final Engine Unknown = new Engine(NameUnknown, null);

	/**
	 * 支持的引擎类型
	 */
	public static final List<Engine> engines = CollectionUtil.newArrayList(//
			new Engine("Trident", "trident"), //
			new Engine("Webkit", "webkit"), //
			new Engine("Chrome", "chrome"), //
			new Engine("Opera", "opera"), //
			new Engine("Presto", "presto"), //
			new Engine("Gecko", "gecko"), //
			new Engine("KHTML", "khtml"), //
			new Engine("Konqeror", "konqueror"), //
			new Engine("MIDP", "MIDP")//
	);

	/**
	 * 构造
	 * 
	 * @param name 引擎名称
	 * @param regex 关键字或表达式
	 */
	public Engine(String name, String regex) {
		super(name, regex);
	}

}
