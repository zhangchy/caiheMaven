package ouer.caihe.maven.config;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Profile;
import org.springframework.context.support.PropertySourcesPlaceholderConfigurer;
import org.springframework.core.io.ClassPathResource;

@Configuration
public class ApplicationConfig {

	private final Logger LOG = LoggerFactory.getLogger(ApplicationConfig.class);

	/** ���ϻ�����profile��� */
	public static final String PROFILE_NAME_TEST = "caihe-test";
	public static final String PROFILE_NAME_DEV = "caihe-dev";

	/**
	 * dev profile
	 */
	@Profile(PROFILE_NAME_DEV)
	@Bean(name = "propertyPlaceholderConfigurer")
	public PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurerDev() {
		final PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("env/config-dev.properties"));
		LOG.warn("env/config-dev.properties loaded");
		return ppc;
	}

	@Profile(PROFILE_NAME_TEST)
	@Bean(name = "propertyPlaceholderConfigurer")
	public PropertySourcesPlaceholderConfigurer propertyPlaceholderConfigurerTest() {
		final PropertySourcesPlaceholderConfigurer ppc = new PropertySourcesPlaceholderConfigurer();
		ppc.setLocation(new ClassPathResource("env/config-test.properties"));
		LOG.warn("env/config-test.properties loaded");
		return ppc;
	}
}