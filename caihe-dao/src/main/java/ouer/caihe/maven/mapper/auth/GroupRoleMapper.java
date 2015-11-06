package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.GroupRole;

public interface GroupRoleMapper {
	/**
	 * ����һ����¼
	 * @param group
	 * @return
	 */
	Integer insertGroupRole(GroupRole groupRole);
	/**
	 * ��������
	 * @param groups
	 * @return
	 */
	Integer insertGroupRoleBatch(@Param("groupRoles")List<GroupRole> groupRoles);
	
	/**
	 * ����role_idɾ��
	 * @param id
	 * @return
	 */
	Integer deleteGroupRoleById(@Param("roleId")String roleId);
	
	/**
	 * ����group_idɾ��
	 * @param parentId
	 * @return
	 */
	Integer deleteGroupRoleByGroupId(@Param("groupId")String groupId);
}
