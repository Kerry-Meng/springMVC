package com.softtron.springmvc.aops;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.core.Logger;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.Aspect;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.datasource.DataSourceTransactionManager;
import org.springframework.stereotype.Component;

@Component("applicationaspect")
@Aspect
public class ApplicationAspect {
	@Autowired
	DataSourceTransactionManager transactionManager;
	public static final Logger logger = (Logger) LogManager.getLogger(ApplicationAspect.class);

	public Object exception(ProceedingJoinPoint jp) throws Throwable {
		Object ob = null;
		try {
			ob = jp.proceed();
		} catch (Throwable e) {
			logger.error(e.getMessage());
			throw e;
		}
		return ob;
	}
}
