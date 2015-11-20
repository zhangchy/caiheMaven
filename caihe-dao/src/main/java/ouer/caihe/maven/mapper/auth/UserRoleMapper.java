package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.UserRole;

public interface UserRoleMapper {
	/**
	 * ����һ����¼
	 * 
	 * @param userRole
	 * @return
	 */
	Integer insertUserRole(UserRole userRole);

	/**
	 * ��������
	 * 
	 * @param userRoles
	 * @return
	 */
	Integer insertUserRoleBatch(@Param("userRoles") List<UserRole> userRoles);

	/**
	 * ����role_idɾ��
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteUserRoleById(@Param("roleId") String roleId);

	/**
	 * ����user_idɾ��
	 * 
	 * @param userId
	 * @return
	 */
	Integer deleteUserRoleByGroupId(@Param("userId") String userId);
	
	/**
	 * ����user_id��ȡ�б�
	 * @param userId
	 * @return
	 */
	List<UserRole> selectUserRolesByUserId(@Param("userId") String userId);
	
	/**
	 * ����role_id��ȡ�б�
	 * @param roleId
	 * @return
	 */
	List<UserRole> selectUserRolesByRoleId(@Param("roleId") String roleId);
}
