package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.Role;

public interface RoleMapper {
	/**
	 * 新增一条记录
	 * 
	 * @param role
	 * @return
	 */
	Integer insertRole(Role role);

	/**
	 * 批量插入组记录
	 * 
	 * @param roles
	 * @return
	 */
	Integer insertRoleBatch(@Param("roles") List<Role> roles);

	/**
	 * 更新组记录信息
	 * 
	 * @param role
	 * @return
	 */
	Integer updateRole(Role role);

	/**
	 * 根据组id删除
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteRoleById(@Param("id") String id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	Integer deleteRoleBatch(@Param("ids") List<String> ids);
}
