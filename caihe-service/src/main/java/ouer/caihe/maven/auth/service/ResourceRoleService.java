package ouer.caihe.maven.auth.service;

import java.util.List;

import ouer.caihe.maven.auth.model.ResourceRole;

public interface ResourceRoleService {
	/**
	 * 根据resourceId查询
	 * @param resourceId
	 * @return
	 */
	public List<ResourceRole> getByResourceId(String resourceId);

	/**
	 * 根据resourceIds 批量查询
	 * @param resourceIds
	 * @return
	 */
	public List<ResourceRole> getByResourceIds(List<String> resourceIds);
}
