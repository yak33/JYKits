package com.junya.core.convert.impl;

import com.junya.core.convert.AbstractConverter;

import java.time.Period;
import java.time.temporal.TemporalAmount;

/**
 * 
 * {@link Period}对象转换器
 * 
 * @author zhangchao
 * @since 2.0.3
 */
public class PeriodConverter extends AbstractConverter<Period> {
	private static final long serialVersionUID = 1L;

	@Override
	protected Period convertInternal(Object value) {
		if(value instanceof TemporalAmount){
			return Period.from((TemporalAmount) value);
		}else if(value instanceof Integer){
			return Period.ofDays((Integer) value);
		} else {
			return Period.parse(convertToStr(value));
		}
	}

}
