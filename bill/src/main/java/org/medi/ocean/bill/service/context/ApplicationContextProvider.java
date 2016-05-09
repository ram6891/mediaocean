package org.medi.ocean.bill.service.context;

import org.springframework.beans.BeansException;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;

public class ApplicationContextProvider implements ApplicationContextAware {
	
	private static ApplicationContext context;

    public static <T>   T getBean(Class<T> name ) {
    	if(context == null) {
    		return null;
    	}
    	return context.getBean(name);
    }

    @Override
    public void setApplicationContext(ApplicationContext ac)
            throws BeansException {
        context = ac;
    }

}
