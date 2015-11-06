package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.Role;

public interface RoleMapper {
	/**
	 * ����һ����¼
	 * 
	 * @param role
	 * @return
	 */
	Integer insertRole(Role role);

	/**
	 * �����������¼
	 * 
	 * @param roles
	 * @return
	 */
	Integer insertRoleBatch(@Param("roles") List<Role> roles);

	/**
	 * �������¼��Ϣ
	 * 
	 * @param role
	 * @return
	 */
	Integer updateRole(Role role);

	/**
	 * ������idɾ��
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteRoleById(@Param("id") String id);

	/**
	 * ����ɾ��
	 * 
	 * @param ids
	 * @return
	 */
	Integer deleteRoleBatch(@Param("ids") List<String> ids);
}
