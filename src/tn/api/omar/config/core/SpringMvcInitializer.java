package tn.api.omar.config.core;

import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

import tn.api.omar.config.AppConfig;

public class SpringMvcInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

	@Override
	protected Class<?>[] getRootConfigClasses() {
		System.out.println("getRootConfig");
		return new Class[] { AppConfig.class };
	}

	@Override
	protected Class<?>[] getServletConfigClasses() {
		System.out.println("getServletConfig");
		return new Class[] { AppConfig.class };
	}

	@Override
	protected String[] getServletMappings() {
		System.out.println("getServletMappings");
		return new String[] { "/" };
	}

}