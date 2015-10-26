package ouer.caihe.maven.test;

import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import ouer.caihe.maven.config.ApplicationConfig;
import ouer.caihe.maven.config.ServiceConfig;


@ActiveProfiles("dev")
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = { ApplicationConfig.class, ServiceConfig.class})
public abstract class BaseTest<T> {

    protected T service;

    protected T getService() {
        return service;
    }

    @Autowired
    protected void setService(T service) {
        this.service = service;
    }
}
