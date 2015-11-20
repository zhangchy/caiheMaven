package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.GroupUser;

public interface GroupUserMapper {
	/**
	 * 新增一条记录
	 * @param group
	 * @return
	 */
	Integer insertGroupUserRole(GroupUser groupUser);
	/**
	 * 批量插入
	 * @param groups
	 * @return
	 */
	Integer insertGroupUserBatch(@Param("groupUsers")List<GroupUser> groupUsers);
	
	/**
	 * 根据user_id删除
	 * @param id
	 * @return
	 */
	Integer deleteGroupUserById(@Param("userId")String userId);
	
	/**
	 * 根据group_id删除
	 * @param parentId
	 * @return
	 */
	Integer deleteGroupUserByGroupId(@Param("groupId")String groupId);
	
	/**
	 * 根据group_id获取列表
	 * @param groupId
	 * @return
	 */
	List<GroupUser> selectGroupUsersByGroupId(@Param("groupId") String groupId);
	
	/**
	 * 根据user_id获取列表
	 * @param userId
	 * @return
	 */
	List<GroupUser> selectGroupUsersByRoleId(@Param("userId") String userId);
}
