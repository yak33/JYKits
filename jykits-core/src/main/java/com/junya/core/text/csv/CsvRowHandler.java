package com.junya.core.text.csv;

/**
 * CSV的行处理器，实现此接口用于按照行处理数据
 *
 * @author zhangchao
 * @since 2.0.3
 */
@FunctionalInterface
public interface CsvRowHandler {

	/**
	 * 处理行数据
	 *
	 * @param row 行数据
	 */
	void handle(CsvRow row);
}
