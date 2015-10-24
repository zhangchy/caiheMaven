package ouer.caihe.maven.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import ouer.caihe.maven.Scanned;


@Configuration
@EnableTransactionManagement
@ComponentScan(basePackageClasses = Scanned.class)
@ImportResource({ "classpath:/META-INF/applicationContext-service.xml", })
public class ServiceConfig {

}