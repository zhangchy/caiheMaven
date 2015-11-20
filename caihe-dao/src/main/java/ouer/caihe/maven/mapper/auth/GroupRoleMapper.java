package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.GroupRole;

public interface GroupRoleMapper {
	/**
	 * ����һ����¼
	 * 
	 * @param group
	 * @return
	 */
	Integer insertGroupRole(GroupRole groupRole);

	/**
	 * ��������
	 * 
	 * @param groups
	 * @return
	 */
	Integer insertGroupRoleBatch(@Param("groupRoles") List<GroupRole> groupRoles);

	/**
	 * ����role_idɾ��
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteGroupRoleById(@Param("roleId") String roleId);

	/**
	 * ����group_idɾ��
	 * 
	 * @param parentId
	 * @return
	 */
	Integer deleteGroupRoleByGroupId(@Param("groupId") String groupId);

	/**
	 * ����group_id��ȡ�б�
	 * @param groupId
	 * @return
	 */
	List<GroupRole> selectGroupRolesByGroupId(@Param("groupId") String groupId);
	
	/**
	 * ����role_id��ȡ�б�
	 * @param roleId
	 * @return
	 */
	List<GroupRole> selectGroupRolesByRoleId(@Param("roleId") String roleId);
}
