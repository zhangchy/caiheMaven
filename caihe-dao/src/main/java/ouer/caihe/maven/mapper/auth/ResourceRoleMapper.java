package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.ResourceRole;

public interface ResourceRoleMapper {
	/**
	 * 新增一条记录
	 * @param group
	 * @return
	 */
	Integer insertResourceRole(ResourceRole resourceRole);
	/**
	 * 批量插入
	 * @param groups
	 * @return
	 */
	Integer insertResourceRoleBatch(@Param("resourceRoles")List<ResourceRole> resourceRoles);
	
	/**
	 * 根据role_id删除
	 * @param id
	 * @return
	 */
	Integer deleteResourceRoleById(@Param("roleId")String roleId);
	
	/**
	 * 根据resource_id删除
	 * @param parentId
	 * @return
	 */
	Integer deleteResourceRoleByGroupId(@Param("resourceId")String resourceId);
	
	/**
	 * 根据resource_id获取列表
	 * @param resourceId
	 * @return
	 */
	List<ResourceRole> selectResourceRolesByResourceId(@Param("resourceId") String resourceId);
	
	/**
	 * 根据user_id获取列表
	 * @param roleId
	 * @return
	 */
	List<ResourceRole> selectResourceRolesByRoleId(@Param("roleId") String roleId);
	/**
	 * 根据resource_id批量查询
	 * @param resourceIds
	 * @return
	 */
	List<ResourceRole> selectResourceRolesByResourceIds(@Param("resourceIds") List<String> resourceIds);
}
