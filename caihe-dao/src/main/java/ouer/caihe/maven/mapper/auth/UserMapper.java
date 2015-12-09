package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.ResourceRole;
import ouer.caihe.maven.auth.model.User;

public interface UserMapper {
	/**
	 * insert
	 * 
	 * @param user
	 * @return
	 */
	Integer insertUser(User user);

	/**
	 * update
	 * 
	 * @param user
	 * @return
	 */
	Integer updateUser(User user);

	/**
	 * delete
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteUserById(@Param("id") String id);

	/**
	 * delete batch
	 * 
	 * @param ids
	 * @return
	 */
	Integer deleteUserBatch(@Param("ids") List<String> ids);
	
	/**
	 * select by id
	 * @param id
	 * @return
	 */
	User selectUserById(@Param("id")String id);
	
	/**
	 * select batch
	 * @param ids
	 * @return
	 */
	User selectUsersByIds(@Param("ids") List<String> ids);
	
	/**
	 * select by username
	 * @param username
	 * @return
	 */
	User selectUserByUsername(@Param("username")String username);
	/**
	 * 
	 * @param id
	 * @return
	 */
	List<ResourceRole> selectResourceIdsByUserAuthorities(@Param("id")String id);
}
