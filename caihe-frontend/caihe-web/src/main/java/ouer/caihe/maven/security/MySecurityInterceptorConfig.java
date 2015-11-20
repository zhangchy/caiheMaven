package ouer.caihe.maven.security;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.web.access.intercept.FilterSecurityInterceptor;
import org.springframework.stereotype.Component;

@Component(value = "mySecurityInterceptorConfig")
public class MySecurityInterceptorConfig {
	@Autowired
	private FilterSecurityInterceptor filterSecurityInterceptor;
	@Autowired
	private AuthenticationManager myAuthenticationManager;
	@Autowired
	private MySecurityMetadataSource mySecurityMetadataSource;
	@Autowired
	private MyAccessDecisionManager myAccessDecisionManager;
	@PostConstruct
	public void reBuilder() {
		reBuilderFilterSecurityInterceptor();
	}
	private void reBuilderFilterSecurityInterceptor() {
		if (filterSecurityInterceptor != null) {
			if (mySecurityMetadataSource != null) {
				filterSecurityInterceptor
						.setSecurityMetadataSource(mySecurityMetadataSource);
			}
			if(myAuthenticationManager!=null){
				filterSecurityInterceptor.setAuthenticationManager(myAuthenticationManager);
			}
			if(myAccessDecisionManager!=null){
				filterSecurityInterceptor.setAccessDecisionManager(myAccessDecisionManager);
			}
		}
	}
}
