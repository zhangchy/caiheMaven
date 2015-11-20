package ouer.caihe.maven.security;

import java.util.Collection;
import java.util.Iterator;

import org.springframework.security.access.AccessDecisionManager;
import org.springframework.security.access.AccessDeniedException;
import org.springframework.security.access.AuthorizationServiceException;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.authentication.InsufficientAuthenticationException;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Component;
@Component("myAccessDecisionManager")
public class MyAccessDecisionManager implements AccessDecisionManager{

	@Override
	public void decide(Authentication authentication, Object object,
			Collection<ConfigAttribute> configAttributes)
			throws AccessDeniedException, InsufficientAuthenticationException {
		if (configAttributes == null) {
			throw new AccessDeniedException("没有权限访问！ ");
        }
		String userDetail = String.valueOf(SecurityContextHolder.getContext().getAuthentication().getPrincipal());
		if(userDetail.equals("anonymousUser")){
			throw new AuthorizationServiceException("请登录 ");
		}
        // 所请求的资源拥有的权限(一个资源对多个权限)
        Iterator<ConfigAttribute> iterator = configAttributes.iterator();
        if(!(configAttributes.size()==1&&configAttributes.iterator().next().getAttribute().equals("ROLE_NO_USER"))){
        	while (iterator.hasNext()) {
                ConfigAttribute configAttribute = iterator.next();
                // 访问所请求资源所需要的权限
                String needPermission = configAttribute.getAttribute();
                // 用户所拥有的权限authentication
                for (GrantedAuthority ga : authentication.getAuthorities()) {
                    if (needPermission.equals(ga.getAuthority())) {
                        return;
                    }
                }
            }
            // 没有权限
            throw new AccessDeniedException(" 没有权限访问！ ");
        }
	}

	@Override
	public boolean supports(ConfigAttribute attribute) {
		return true;
	}

	@Override
	public boolean supports(Class<?> clazz) {
		return true;
	}
	
}
