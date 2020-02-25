package com.junya.core.io.watch;

import java.nio.file.StandardWatchEventKinds;
import java.nio.file.WatchEvent;

/**
 * 监听事件类型枚举，包括：
 *
 * <pre>
 *      1. 事件丢失 OVERFLOW -》StandardWatchEventKinds.OVERFLOW
 *      2. 修改事件 MODIFY   -》StandardWatchEventKinds.ENTRY_MODIFY
 *      3. 创建事件 CREATE   -》StandardWatchEventKinds.ENTRY_CREATE
 *      4. 删除事件 DELETE   -》StandardWatchEventKinds.ENTRY_DELETE
 * </pre>
 *
 * @author zhangchao
 * @since 2.1.2
 */
public enum WatchKind {

	/**
	 * 事件丢失
	 */
	OVERFLOW(StandardWatchEventKinds.OVERFLOW),
	/**
	 * 修改事件
	 */
	MODIFY(StandardWatchEventKinds.ENTRY_MODIFY),
	/**
	 * 创建事件
	 */
	CREATE(StandardWatchEventKinds.ENTRY_CREATE),
	/**
	 * 删除事件
	 */
	DELETE(StandardWatchEventKinds.ENTRY_DELETE);

	private WatchEvent.Kind<?> value;

	/**
	 * 构造
	 *
	 * @param value 事件类型
	 */
	WatchKind(WatchEvent.Kind<?> value) {
		this.value = value;
	}

	/**
	 * 获取枚举对应的事件类型
	 *
	 * @return 事件类型值
	 */
	public WatchEvent.Kind<?> getValue() {
		return this.value;
	}
}
