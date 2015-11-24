package ouer.caihe.maven.config;

import java.util.Locale;

import nz.net.ultraq.thymeleaf.LayoutDialect;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.MessageSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.ComponentScan.Filter;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;
import org.springframework.context.annotation.ImportResource;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;
import org.springframework.stereotype.Controller;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurationSupport;
import org.springframework.web.servlet.i18n.CookieLocaleResolver;
import org.springframework.web.servlet.i18n.LocaleChangeInterceptor;
import org.thymeleaf.extras.springsecurity3.dialect.SpringSecurityDialect;
import org.thymeleaf.spring4.SpringTemplateEngine;
import org.thymeleaf.spring4.view.ThymeleafViewResolver;
import org.thymeleaf.templateresolver.ServletContextTemplateResolver;
import org.thymeleaf.templateresolver.TemplateResolver;

import ouer.caihe.maven.Scanned;
import ouer.caihe.maven.constant.GeneralConstant;

@Configuration
@Import(value = ApplicationConfig.class)
@ImportResource("classpath:/META-INF/applicationContext-web.xml")
@ComponentScan(basePackageClasses = Scanned.class, includeFilters = @Filter(Controller.class), useDefaultFilters = false)
class WebMvcConfig extends WebMvcConfigurationSupport {
	private static final String MESSAGE_SOURCE = "/resources/i18n/messages";
	@Value("${view.page.prefix}")
	String prefix;

	@Value("${view.page.suffix}")
	String suffix;

	@Value("${view.page.templateMode}")
	String templateMode;

	@Value("${cache.page.templates}")
	boolean cacheable;

	@Value("${cache.page.templates.ttl}")
	Long cacheTTLMs;

	@Value("${message.source.cache.seconds}")
	int msgSrcCacheSeconds;

	// 静态资源地址
	@Override
	public void addResourceHandlers(ResourceHandlerRegistry registry) {
		registry.addResourceHandler(GeneralConstant.RESOURCES_HANDLER)
				.addResourceLocations(GeneralConstant.RESOURCE_LOCATION);
	}

	@Bean
	public TemplateResolver templateResolver() {
		ServletContextTemplateResolver templateResolver = new ServletContextTemplateResolver();
		templateResolver.setPrefix(prefix);
		templateResolver.setSuffix(suffix);
		templateResolver.setTemplateMode(templateMode);
		templateResolver.setCacheable(cacheable);
		templateResolver.setCacheTTLMs(cacheTTLMs);
		return templateResolver;
	}

	@Bean
	public SpringTemplateEngine templateEngine() {
		SpringTemplateEngine templateEngine = new SpringTemplateEngine();
		templateEngine.setTemplateResolver(templateResolver());
		templateEngine.addDialect(new SpringSecurityDialect());
		templateEngine.addDialect(new LayoutDialect());
		return templateEngine;
	}

	@Bean
	public ThymeleafViewResolver viewResolver() {
		ThymeleafViewResolver thymeleafViewResolver = new ThymeleafViewResolver();
		thymeleafViewResolver.setTemplateEngine(templateEngine());
		thymeleafViewResolver.setCharacterEncoding("UTF-8");

		return thymeleafViewResolver;
	}
	@Bean(name = "messageSource")
    public MessageSource messageSource() {
        ReloadableResourceBundleMessageSource messageSource = new ReloadableResourceBundleMessageSource();
        messageSource.setBasename(MESSAGE_SOURCE);
        messageSource.setCacheSeconds(msgSrcCacheSeconds);
        return messageSource;
    }
	@Bean
	public LocaleResolver localeResolver() {
		CookieLocaleResolver localeResolver = new CookieLocaleResolver();
		localeResolver.setDefaultLocale(new Locale("zh"));
		return localeResolver;
	}
	@Bean
	public LocaleChangeInterceptor localeChangeInterceptor() {
		LocaleChangeInterceptor localeChangeInterceptor = new LocaleChangeInterceptor();
		localeChangeInterceptor.setParamName("lang");
		return localeChangeInterceptor;
	}


	@Override
	public void addInterceptors(InterceptorRegistry registry) {
		registry.addInterceptor(localeChangeInterceptor());
	}

}
