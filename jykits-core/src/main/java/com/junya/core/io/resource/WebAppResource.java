package com.junya.core.io.resource;

import java.io.File;

import com.junya.core.io.FileUtil;

/**
 * Web root资源访问对象
 * 
 * @author zhangchao
 * @since 2.0.3
 */
public class WebAppResource extends FileResource {
	private static final long serialVersionUID = 1L;

	/**
	 * 构造
	 * 
	 * @param path 相对于Web root的路径
	 */
	public WebAppResource(String path) {
		super(new File(FileUtil.getWebRoot(), path));
	}

}
