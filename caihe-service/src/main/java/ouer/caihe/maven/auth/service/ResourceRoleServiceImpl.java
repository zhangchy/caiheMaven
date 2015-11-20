package ouer.caihe.maven.auth.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import ouer.caihe.maven.auth.model.ResourceRole;
import ouer.caihe.maven.mapper.auth.ResourceRoleMapper;
@Service("resourceRoleService")
public class ResourceRoleServiceImpl implements ResourceRoleService{
	@Resource
	ResourceRoleMapper resourceRoleMapper;
	@Override
	public List<ResourceRole> getByResourceId(String resourceId) {
		return resourceRoleMapper.selectResourceRolesByResourceId(resourceId);
	}
	@Override
	public List<ResourceRole> getByResourceIds(List<String> resourceIds) {
		return resourceRoleMapper.selectResourceRolesByResourceIds(resourceIds);
	}

}
