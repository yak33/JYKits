package com.junya.core.convert.impl;

import java.lang.reflect.Type;
import java.util.concurrent.atomic.AtomicReference;

import com.junya.core.convert.AbstractConverter;
import com.junya.core.convert.ConverterRegistry;
import com.junya.core.util.TypeUtil;

/**
 * {@link AtomicReference}转换器
 * 
 * @author zhangchao
 * @since 2.0.3
 */
@SuppressWarnings("rawtypes")
public class AtomicReferenceConverter extends AbstractConverter<AtomicReference> {
	private static final long serialVersionUID = 1L;
	
	@Override
	protected AtomicReference<?> convertInternal(Object value) {
		
		//尝试将值转换为Reference泛型的类型
		Object targetValue = null;
		final Type paramType = TypeUtil.getTypeArgument(AtomicReference.class);
		if(false == TypeUtil.isUnknow(paramType)){
			targetValue = ConverterRegistry.getInstance().convert(paramType, value);
		}
		if(null == targetValue){
			targetValue = value;
		}
		
		return new AtomicReference<>(targetValue);
	}

}
