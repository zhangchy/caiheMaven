package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.UserRole;

public interface UserRoleMapper {
	/**
	 * 新增一条记录
	 * 
	 * @param userRole
	 * @return
	 */
	Integer insertUserRole(UserRole userRole);

	/**
	 * 批量插入
	 * 
	 * @param userRoles
	 * @return
	 */
	Integer insertUserRoleBatch(@Param("userRoles") List<UserRole> userRoles);

	/**
	 * 根据role_id删除
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteUserRoleById(@Param("roleId") String roleId);

	/**
	 * 根据user_id删除
	 * 
	 * @param userId
	 * @return
	 */
	Integer deleteUserRoleByGroupId(@Param("userId") String userId);
	
	/**
	 * 根据user_id获取列表
	 * @param userId
	 * @return
	 */
	List<UserRole> selectUserRolesByUserId(@Param("userId") String userId);
	
	/**
	 * 根据role_id获取列表
	 * @param roleId
	 * @return
	 */
	List<UserRole> selectUserRolesByRoleId(@Param("roleId") String roleId);
}
