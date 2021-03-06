package com.junya.poi;

import com.junya.core.exceptions.DependencyException;
import com.junya.core.util.ClassLoaderUtil;

/**
 * POI引入检查器
 * 
 * @author zhangchao
 * @since 2.0.1
 */
public class PoiChecker {

	/** 没有引入POI的错误消息 */
	public static final String NO_POI_ERROR_MSG = "You need to add dependency of 'poi-ooxml' to your project, and version >= 3.17";

	/**
	 * 检查POI包的引入情况
	 */
	public static void checkPoiImport() {
		try {
			Class.forName("org.apache.poi.ss.usermodel.Workbook", false, ClassLoaderUtil.getClassLoader());
		} catch (ClassNotFoundException | NoClassDefFoundError e) {
			throw new DependencyException(e, NO_POI_ERROR_MSG);
		}
	}
}
