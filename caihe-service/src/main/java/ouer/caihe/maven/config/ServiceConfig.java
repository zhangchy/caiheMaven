package ouer.caihe.maven.config;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;


@Configuration
@EnableTransactionManagement
@ImportResource({ "classpath:/META-INF/applicationContext-service.xml", })
public class ServiceConfig {

}