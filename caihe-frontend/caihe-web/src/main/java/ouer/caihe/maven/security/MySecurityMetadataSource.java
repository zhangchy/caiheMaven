package ouer.caihe.maven.security;

import java.util.Collection;
import java.util.LinkedHashMap;

import javax.annotation.PostConstruct;

import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.web.access.intercept.DefaultFilterInvocationSecurityMetadataSource;
import org.springframework.security.web.util.matcher.RequestMatcher;
import org.springframework.stereotype.Component;

@Component("mySecurityMetadataSource")
public class MySecurityMetadataSource extends DefaultFilterInvocationSecurityMetadataSource{

	public MySecurityMetadataSource(
			LinkedHashMap<RequestMatcher, Collection<ConfigAttribute>> requestMap) {
		super(requestMap);
	}
	//返回所请求资源所需要的权限
	@PostConstruct
	public void loadResources(){
		
	}
}
