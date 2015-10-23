/**
 * Copyright (C) 2015 O'er, Inc. All Rights Reserved.
 */
package ouer.caihe.maven.config;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.ServletRegistration;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContextInitializer;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.core.env.ConfigurableEnvironment;
import org.springframework.core.io.support.ResourcePropertySource;
import org.springframework.web.filter.CharacterEncodingFilter;
import org.springframework.web.filter.DelegatingFilterProxy;
import org.springframework.web.filter.ShallowEtagHeaderFilter;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;


public class WebAppInitializer extends AbstractAnnotationConfigDispatcherServletInitializer {

    @Override
    protected Class<?>[] getRootConfigClasses() {
		return new Class<?>[] { ApplicationConfig.class, DaoConfig.class,
				ServiceConfig.class,SecurityConfig.class };
    }

    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] { WebMvcConfig.class };
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] { "/" };
    }

    @Override
    protected Filter[] getServletFilters() {
        CharacterEncodingFilter characterEncodingFilter = new CharacterEncodingFilter();
        characterEncodingFilter.setEncoding("UTF-8");
        characterEncodingFilter.setForceEncoding(true);

        ShallowEtagHeaderFilter shallowEtagHeaderFilter = new ShallowEtagHeaderFilter();

        DelegatingFilterProxy springSecurityFilterChain = new DelegatingFilterProxy("springSecurityFilterChain");

        return new Filter[] { characterEncodingFilter, shallowEtagHeaderFilter, springSecurityFilterChain };
    }

    @Override
    protected void customizeRegistration(ServletRegistration.Dynamic registration) {
        registration.setInitParameter("defaultHtmlEscape", "true");
    }

    public static class ConfigApplicationContextInitializer implements ApplicationContextInitializer<ConfigurableApplicationContext> {
        private Logger logger = LoggerFactory.getLogger(ConfigApplicationContextInitializer.class);

        @Override
        public void initialize(ConfigurableApplicationContext applicationContext) {
            ConfigurableEnvironment environment = applicationContext.getEnvironment();
            try {
                environment.getPropertySources().addFirst(new ResourcePropertySource("classpath:filtered.properties"));

                if (logger.isInfoEnabled()) {
                    logger.info("filtered.properties loaded");
                }
            } catch (IOException e) {
                // it's ok if the file is not there. we will just log that info.
                if (logger.isInfoEnabled()) {
                    logger.info("didn't find filtered.properties in classpath so not loading it in the AppContextInitialized");
                }
            }
        }
    }

}