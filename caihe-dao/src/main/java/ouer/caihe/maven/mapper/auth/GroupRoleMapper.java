package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.GroupRole;

public interface GroupRoleMapper {
	/**
	 * 新增一条记录
	 * @param group
	 * @return
	 */
	Integer insertGroupRole(GroupRole groupRole);
	/**
	 * 批量插入
	 * @param groups
	 * @return
	 */
	Integer insertGroupRoleBatch(@Param("groupRoles")List<GroupRole> groupRoles);
	
	/**
	 * 根据role_id删除
	 * @param id
	 * @return
	 */
	Integer deleteGroupRoleById(@Param("roleId")String roleId);
	
	/**
	 * 根据group_id删除
	 * @param parentId
	 * @return
	 */
	Integer deleteGroupRoleByGroupId(@Param("groupId")String groupId);
}
