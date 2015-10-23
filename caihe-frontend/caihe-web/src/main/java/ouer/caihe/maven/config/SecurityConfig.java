package ouer.caihe.maven.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
import org.springframework.security.config.annotation.web.servlet.configuration.EnableWebMvcSecurity;
@Configuration
@EnableWebMvcSecurity
@ImportResource("classpath:META-INF/spring-security-context.xml")
class SecurityConfig extends WebSecurityConfigurerAdapter {
	
}
 
	