package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.GroupUser;

public interface GroupUserMapper {
	/**
	 * ����һ����¼
	 * @param group
	 * @return
	 */
	Integer insertGroupUserRole(GroupUser groupUser);
	/**
	 * ��������
	 * @param groups
	 * @return
	 */
	Integer insertGroupUserBatch(@Param("groupUsers")List<GroupUser> groupUsers);
	
	/**
	 * ����user_idɾ��
	 * @param id
	 * @return
	 */
	Integer deleteGroupUserById(@Param("userId")String userId);
	
	/**
	 * ����group_idɾ��
	 * @param parentId
	 * @return
	 */
	Integer deleteGroupUserByGroupId(@Param("groupId")String groupId);
	
	/**
	 * ����group_id��ȡ�б�
	 * @param groupId
	 * @return
	 */
	List<GroupUser> selectGroupUsersByGroupId(@Param("groupId") String groupId);
	
	/**
	 * ����user_id��ȡ�б�
	 * @param userId
	 * @return
	 */
	List<GroupUser> selectGroupUsersByRoleId(@Param("userId") String userId);
}
