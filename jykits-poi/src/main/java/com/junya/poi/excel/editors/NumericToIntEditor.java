package com.junya.poi.excel.editors;

import org.apache.poi.ss.usermodel.Cell;

import com.junya.poi.excel.cell.CellEditor;

/**
 * POI中NUMRIC类型的值默认返回的是Double类型，此编辑器用于转换其为int型
 * @author zhangchao
 *
 */
public class NumericToIntEditor implements CellEditor{

	@Override
	public Object edit(Cell cell, Object value) {
		if(value instanceof Number) {
			return ((Number)value).intValue();
		}
		return value;
	}

}
