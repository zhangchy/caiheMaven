package ouer.caihe.maven.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

@Component(value = "mySecurityInterceptorConfig")
public class MySecurityInterceptorConfig {
	@Autowired
	private FilterSecurityInterceptor filterSecurityInterceptor;
	
	@Autowired
	private MySecurityMetadataSource mMySecurityMetadataSource;
	@PostConstruct
	public void reBuilder() {
		reBuilderFilterSecurityInterceptor();
	}
	private void reBuilderFilterSecurityInterceptor() {
		if (filterSecurityInterceptor != null) {
			if (mMySecurityMetadataSource != null) {
				filterSecurityInterceptor
						.setSecurityMetadataSource(mMySecurityMetadataSource);
			}
		}
	}
}
