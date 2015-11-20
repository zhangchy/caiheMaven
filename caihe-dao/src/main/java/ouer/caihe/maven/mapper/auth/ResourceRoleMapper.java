package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.ResourceRole;

public interface ResourceRoleMapper {
	/**
	 * ����һ����¼
	 * @param group
	 * @return
	 */
	Integer insertResourceRole(ResourceRole resourceRole);
	/**
	 * ��������
	 * @param groups
	 * @return
	 */
	Integer insertResourceRoleBatch(@Param("resourceRoles")List<ResourceRole> resourceRoles);
	
	/**
	 * ����role_idɾ��
	 * @param id
	 * @return
	 */
	Integer deleteResourceRoleById(@Param("roleId")String roleId);
	
	/**
	 * ����resource_idɾ��
	 * @param parentId
	 * @return
	 */
	Integer deleteResourceRoleByGroupId(@Param("resourceId")String resourceId);
	
	/**
	 * ����resource_id��ȡ�б�
	 * @param resourceId
	 * @return
	 */
	List<ResourceRole> selectResourceRolesByResourceId(@Param("resourceId") String resourceId);
	
	/**
	 * ����user_id��ȡ�б�
	 * @param roleId
	 * @return
	 */
	List<ResourceRole> selectResourceRolesByRoleId(@Param("roleId") String roleId);
	/**
	 * ����resource_id������ѯ
	 * @param resourceIds
	 * @return
	 */
	List<ResourceRole> selectResourceRolesByResourceIds(@Param("resourceIds") List<String> resourceIds);
}
