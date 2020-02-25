package com.junya.core.convert.impl;

import com.junya.core.convert.AbstractConverter;
import com.junya.core.date.DateTime;
import com.junya.core.date.DateUtil;
import com.junya.core.util.StringUtil;

import java.time.temporal.TemporalAccessor;
import java.util.Calendar;
import java.util.Date;

/**
 * 日期转换器
 * 
 * @author zhangchao
 *
 */
public class DateConverter extends AbstractConverter<java.util.Date> {
	private static final long serialVersionUID = 1L;

	private Class<? extends java.util.Date> targetType;
	/** 日期格式化 */
	private String format;

	/**
	 * 构造
	 * 
	 * @param targetType 目标类型
	 */
	public DateConverter(Class<? extends java.util.Date> targetType) {
		this.targetType = targetType;
	}

	/**
	 * 构造
	 * 
	 * @param targetType 目标类型
	 * @param format 日期格式
	 */
	public DateConverter(Class<? extends java.util.Date> targetType, String format) {
		this.targetType = targetType;
		this.format = format;
	}

	/**
	 * 获取日期格式
	 * 
	 * @return 设置日期格式
	 */
	public String getFormat() {
		return format;
	}

	/**
	 * 设置日期格式
	 * 
	 * @param format 日期格式
	 */
	public void setFormat(String format) {
		this.format = format;
	}

	@Override
	protected java.util.Date convertInternal(Object value) {
		Long mills = null;
		if (value instanceof Calendar) {
			// Handle Calendar
			mills = ((Calendar) value).getTimeInMillis();
		} else if (value instanceof Number) {
			// Handle Number
			mills = ((Number) value).longValue();
		}else if (value instanceof TemporalAccessor) {
			return DateUtil.date((TemporalAccessor) value);
		} else {
			// 统一按照字符串处理
			final String valueStr = convertToStr(value);
			Date date = null;
			try {
				date = StringUtil.isBlank(this.format) //
						? DateUtil.parse(valueStr) //
						: DateUtil.parse(valueStr, this.format);
			} catch (Exception e) {
				// Ignore Exception
			}
			if(null != date){
				mills = date.getTime();
			}
		}

		if (null == mills) {
			return null;
		}

		// 返回指定类型
		if (java.util.Date.class == targetType) {
			return new java.util.Date(mills);
		}
		if (DateTime.class == targetType) {
			return new DateTime(mills);
		} else if (java.sql.Date.class == targetType) {
			return new java.sql.Date(mills);
		} else if (java.sql.Time.class == targetType) {
			return new java.sql.Time(mills);
		} else if (java.sql.Timestamp.class == targetType) {
			return new java.sql.Timestamp(mills);
		}

		throw new UnsupportedOperationException(StringUtil.format("Unsupport Date type: {}", this.targetType.getName()));
	}

}
