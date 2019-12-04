package org.junya.core.getter;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Date;

import org.junya.core.convert.Convert;

/**
 * 基本类型的getter接口抽象实现，所有类型的值获取都是通过将getObj获得的值转换而来<br>
 * 用户只需实现getObj方法即可，其他类型将会从Object结果中转换
 * 在不提供默认值的情况下， 如果值不存在或获取错误，返回null<br>
 * @author Looly
 */
public abstract class OptNullBasicTypeFromObjectGetter<K> extends OptNullBasicTypeGetter<K>{
	
	@Override
	public String getStr(K key, String defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toStr(obj, defaultValue);
	}
	
	@Override
	public Integer getInt(K key, Integer defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toInt(obj, defaultValue);
	}

	@Override
	public Short getShort(K key, Short defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toShort(obj, defaultValue);
	}

	@Override
	public Boolean getBool(K key, Boolean defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toBool(obj, defaultValue);
	}

	@Override
	public Long getLong(K key, Long defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toLong(obj, defaultValue);
	}

	@Override
	public Character getChar(K key, Character defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toChar(obj, defaultValue);
	}
	
	@Override
	public Float getFloat(K key, Float defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toFloat(obj, defaultValue);
	}

	@Override
	public Double getDouble(K key, Double defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toDouble(obj, defaultValue);
	}

	@Override
	public Byte getByte(K key, Byte defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toByte(obj, defaultValue);
	}

	@Override
	public BigDecimal getBigDecimal(K key, BigDecimal defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toBigDecimal(obj, defaultValue);
	}

	@Override
	public BigInteger getBigInteger(K key, BigInteger defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toBigInteger(obj, defaultValue);
	}
	
	@Override
	public <E extends Enum<E>> E getEnum(Class<E> clazz, K key, E defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toEnum(clazz, obj, defaultValue);
	}
	
	@Override
	public Date getDate(K key, Date defaultValue) {
		final Object obj = getObj(key);
		if(null == obj) {
			return defaultValue;
		}
		return Convert.toDate(obj, defaultValue);
	}
}
