package com.junya.poi.excel.editors;

import org.apache.poi.ss.usermodel.Cell;

import com.junya.core.util.StringUtil;
import com.junya.poi.excel.cell.CellEditor;

/**
 * 去除String类型的单元格值两边的空格
 * @author zhangchao
 *
 */
public class TrimEditor implements CellEditor{

	@Override
	public Object edit(Cell cell, Object value) {
		if(value instanceof String) {
			return StringUtil.trim((String)value);
		}
		return value;
	}

}
