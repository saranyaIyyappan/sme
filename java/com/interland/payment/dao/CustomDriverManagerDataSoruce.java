package com.interland.payment.dao;

import org.springframework.jdbc.datasource.DriverManagerDataSource;

import com.interland.payment.exception.DataAccessException;
import com.interland.payment.util.EncryptionUtil;

/**
 * This method is to override DriverManagerDataSource, so that we can catch the
 * db password and decrypt it.
 * 
 * @since 12/9/2015
 *
 */
public class CustomDriverManagerDataSoruce extends DriverManagerDataSource {

	public CustomDriverManagerDataSoruce() {
		super();
	}
	public synchronized void setPassword(String password)throws DataAccessException  {
		try {
			super.setPassword(EncryptionUtil.decryptPassword(password));
		} catch (Exception e) {
			logger.error(e.getMessage(),e);
			throw new DataAccessException();
		}
	}
}
