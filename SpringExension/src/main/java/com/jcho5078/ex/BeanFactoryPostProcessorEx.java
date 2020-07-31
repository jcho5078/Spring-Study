package com.jcho5078.ex;

import org.springframework.beans.BeansException;
import org.springframework.beans.FatalBeanException;
import org.springframework.beans.MutablePropertyValues;
import org.springframework.beans.factory.config.BeanDefinition;
import org.springframework.beans.factory.config.BeanFactoryPostProcessor;
import org.springframework.beans.factory.config.ConfigurableListableBeanFactory;

public class BeanFactoryPostProcessorEx implements BeanFactoryPostProcessor{
	
	private int threshold;

	@Override
	public void postProcessBeanFactory(ConfigurableListableBeanFactory beanFactory) throws BeansException {
		
		String[] beanName = beanFactory.getBeanDefinitionNames();//XML에 있는 빈 객체들의 이름을 전부 가져옴
		for(String name : beanName) {
			BeanDefinition beanInfo = beanFactory.getBeanDefinition(name);//BeanDefinition 객체에 해당 빈의 설정정보 저장
			Class<?> klass = getClassFromBean(beanInfo);
			if(klass != null && ThresholdRequired.class.isAssignableFrom(klass)) {
				MutablePropertyValues prop = beanInfo.getPropertyValues();
				if(!prop.contains("threshold")) {
					prop.add("threshold", threshold);
				}
			}
		}
	}

	private Class<?> getClassFromBean(BeanDefinition beanInfo) {
		if(beanInfo.getBeanClassName() == null) return null;
		try {
			return Class.forName(beanInfo.getBeanClassName());
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			throw new FatalBeanException(e.getMessage(), e);
		}
	}
	
}
