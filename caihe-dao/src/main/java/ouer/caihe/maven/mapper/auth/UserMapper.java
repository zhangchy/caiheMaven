package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.User;

public interface UserMapper {
	/**
	 * 新增一条记录
	 * 
	 * @param user
	 * @return
	 */
	Integer insertUser(User user);

	/**
	 * 更新组记录信息
	 * 
	 * @param user
	 * @return
	 */
	Integer updateUser(User user);

	/**
	 * 根据组id删除
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteUserById(@Param("id") String id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	Integer deleteUserBatch(@Param("ids") List<String> ids);
	
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	User selectUserById(@Param("id")String id);
	
	/**
	 * 批量查询
	 * @param ids
	 * @return
	 */
	User selectUsersByIds(@Param("ids") List<String> ids);
}
