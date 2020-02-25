package com.junya.core.bean.copier.provider;

import java.lang.reflect.Type;
import java.util.Map;

import com.junya.core.bean.copier.ValueProvider;
import com.junya.core.convert.Convert;
import com.junya.core.map.CaseInsensitiveMap;
import com.junya.core.util.StringUtil;

/**
 * Map值提供者
 * 
 * @author zhangchao
 *
 */
public class MapValueProvider implements ValueProvider<String> {

	private Map<?, ?> map;

	/**
	 * 构造
	 * 
	 * @param map Map
	 * @param ignoreCase 是否忽略key的大小写
	 */
	public MapValueProvider(Map<?, ?> map, boolean ignoreCase) {
		if(false == ignoreCase || map instanceof CaseInsensitiveMap) {
			//不忽略大小写或者提供的Map本身为CaseInsensitiveMap则无需转换
			this.map = map;
		}else {
			//转换为大小写不敏感的Map
			this.map = new CaseInsensitiveMap<>(map);
		}
	}

	@Override
	public Object value(String key, Type valueType) {
		Object value = map.get(key);
		if(null == value) {
			//检查下划线模式
			value = map.get(StringUtil.toUnderlineCase(key));
		}
		
		return Convert.convert(valueType, value);
	}

	@Override
	public boolean containsKey(String key) {
		//检查下划线模式
		if(map.containsKey(key)) {
			return true;
		}else {
			return map.containsKey(StringUtil.toUnderlineCase(key));
		}
	}

}
