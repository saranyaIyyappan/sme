package com.interland.payment.util;

import java.lang.reflect.InvocationTargetException;

import org.apache.commons.beanutils.BeanUtils;
import org.apache.commons.beanutils.BeanUtilsBean;
import org.apache.commons.beanutils.Converter;
import org.apache.commons.beanutils.converters.DateConverter;

public class CopyObject {
	public static void copyProperties(Object src, Object dest) throws IllegalAccessException,InvocationTargetException, NoSuchMethodException {
		java.util.Date defaultValue = null;
		Converter converter = new DateConverter(defaultValue);
		BeanUtilsBean beanUtilsBean = BeanUtilsBean.getInstance();
		beanUtilsBean.getConvertUtils().register(converter, java.util.Date.class);
		BeanUtils.copyProperties(dest, src);
	}
}
