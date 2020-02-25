package com.junya.poi.excel;

import java.util.ArrayList;
import java.util.List;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;

import com.junya.poi.excel.cell.CellEditor;
import com.junya.poi.excel.cell.CellUtil;

/**
 * Excel中的行{@link Row}封装工具类
 * 
 * @author zhangchao
 * @since 2.0.1
 */
public class RowUtil {
	/**
	 * 获取已有行或创建新行
	 * 
	 * @param sheet Excel表
	 * @param rowIndex 行号
	 * @return {@link Row}
	 * @since 2.0.3
	 */
	public static Row getOrCreateRow(Sheet sheet, int rowIndex) {
		Row row = sheet.getRow(rowIndex);
		if (null == row) {
			row = sheet.createRow(rowIndex);
		}
		return row;
	}

	/**
	 * 读取一行
	 * 
	 * @param row 行
	 * @param cellEditor 单元格编辑器
	 * @return 单元格值列表
	 */
	public static List<Object> readRow(Row row, CellEditor cellEditor) {
		if (null == row) {
			return new ArrayList<>(0);
		}
		final short length = row.getLastCellNum();
		if (length < 0) {
			return new ArrayList<>(0);
		}
		final List<Object> cellValues = new ArrayList<>((int) length);
		Object cellValue;
		boolean isAllNull = true;
		for (short i = 0; i < length; i++) {
			cellValue = CellUtil.getCellValue(row.getCell(i), cellEditor);
			isAllNull &= isEmptyIfStr(cellValue);
			cellValues.add(cellValue);
		}

		if (isAllNull) {
			// 如果每个元素都为空，则定义为空行
			return new ArrayList<>(0);
		}
		return cellValues;
	}

	/**
	 * 如果对象是字符串是否为空串空的定义如下:<br>
	 * 1、为null <br>
	 * 2、为""<br>
	 *
	 * @param obj 对象
	 * @return 如果为字符串是否为空串
	 * @since 2.0.1
	 */
	public static boolean isEmptyIfStr(Object obj) {
		if (null == obj) {
			return true;
		} else if (obj instanceof CharSequence) {
			return 0 == ((CharSequence) obj).length();
		}
		return false;
	}


	/**
	 * 写一行数据
	 * 
	 * @param row 行
	 * @param rowData 一行的数据
	 * @param styleSet 单元格样式集，包括日期等样式
	 * @param isHeader 是否为标题行
	 */
	public static void writeRow(Row row, Iterable<?> rowData, StyleSet styleSet, boolean isHeader) {
		int i = 0;
		Cell cell;
		for (Object value : rowData) {
			cell = row.createCell(i);
			CellUtil.setCellValue(cell, value, styleSet, isHeader);
			i++;
		}
	}
}
