package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.User;

public interface UserMapper {
	/**
	 * ����һ����¼
	 * 
	 * @param user
	 * @return
	 */
	Integer insertUser(User user);

	/**
	 * �������¼��Ϣ
	 * 
	 * @param user
	 * @return
	 */
	Integer updateUser(User user);

	/**
	 * ������idɾ��
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteUserById(@Param("id") String id);

	/**
	 * ����ɾ��
	 * 
	 * @param ids
	 * @return
	 */
	Integer deleteUserBatch(@Param("ids") List<String> ids);
	
	/**
	 * ����id��ȡ
	 * @param id
	 * @return
	 */
	User selectUserById(@Param("id")String id);
	
	/**
	 * ������ѯ
	 * @param ids
	 * @return
	 */
	User selectUsersByIds(@Param("ids") List<String> ids);
}
