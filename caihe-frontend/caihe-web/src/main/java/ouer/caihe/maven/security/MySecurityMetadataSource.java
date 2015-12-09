package ouer.caihe.maven.security;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.PostConstruct;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.ConfigAttribute;
import org.springframework.security.access.SecurityConfig;
import org.springframework.security.web.FilterInvocation;
import org.springframework.security.web.access.intercept.FilterInvocationSecurityMetadataSource;
import org.springframework.stereotype.Service;

import ouer.caihe.maven.auth.model.Resource;
import ouer.caihe.maven.auth.model.ResourceRole;
import ouer.caihe.maven.auth.service.ResourceRoleService;
import ouer.caihe.maven.auth.service.ResourceService;

@Service("mySecurityMetadataSource")
public class MySecurityMetadataSource implements FilterInvocationSecurityMetadataSource {
	@Autowired
	private ResourceService resourceService;
	@Autowired
	private ResourceRoleService resourceRoleService;
	private static Map<String, Collection<ConfigAttribute>> resourceMap = null;

	public Collection<ConfigAttribute> getAllConfigAttributes() {
		return null;
	}

	public boolean supports(Class<?> clazz) {
		return true;
	}
	/**
	 * @PostConstruct是Java EE 5引入的注解，
	 * Spring允许开发者在受管Bean中使用它。当DI容器实例化当前受管Bean时，
	 * @PostConstruct注解的方法会被自动触发，从而完成一些初始化工作，
	 * 
	 * 加载所有资源与权限的关系
	 */
	@PostConstruct
	private void loadResourceDefine() {
		if (resourceMap == null) {
			resourceMap = new HashMap<String, Collection<ConfigAttribute>>();
			//初始化
			/*<security:intercept-url pattern="/resource/**" access="permitAll" />
			<security:intercept-url pattern="/login" access="permitAll" />
			<security:intercept-url pattern="/signin" access="permitAll" />
			<security:intercept-url pattern="/signin_fail" access="permitAll" />
			<security:intercept-url pattern="/signin_deny" access="permitAll" />
			<security:intercept-url pattern="/**" access="isAuthenticated()" />*/
			List<Resource> resources = this.resourceService.getAllResourcesUrlNotNull();
			List<String> resourceIds  = new ArrayList<String>();
			for (Resource resource : resources) {
				resourceIds.add(resource.getId());
			}
			if(resources.size()>0){
				List<ResourceRole> resourcesRoles = resourceRoleService.getByResourceIds(resourceIds);
				if(resourcesRoles.size()>0){
					for(Resource resource : resources){
						Collection<ConfigAttribute> configAttributes = new ArrayList<ConfigAttribute>();
						for(ResourceRole resourceRole:resourcesRoles){
							if(String.valueOf(resource.getId()).equals(String.valueOf(resourceRole.getResourceId().toString()))){
								// 通过资源名称来表示具体的权限 注意：必须"ROLE_"开头
								ConfigAttribute configAttribute = new SecurityConfig(resourceRole.getResourceId());
								configAttributes.add(configAttribute);
							}
						}
						resourceMap.put(resource.getUrl(), configAttributes);
					}
				}
			}
		}
	}
	//返回所请求资源所需要的权限
	public Collection<ConfigAttribute> getAttributes(Object object) throws IllegalArgumentException {
		String requestUrl = ((FilterInvocation) object).getRequestUrl();
		if(resourceMap == null) {
			loadResourceDefine();
		}
		if(requestUrl.indexOf("?")>-1){
			requestUrl=requestUrl.substring(0,requestUrl.indexOf("?"));
		}
		Collection<ConfigAttribute> configAttributes = resourceMap.get(requestUrl);
		if(configAttributes == null){
			configAttributes = new ArrayList<ConfigAttribute>(); 
			configAttributes.add(new SecurityConfig("ROLE_NO_USER")); 
		}
		return configAttributes;
	}
}