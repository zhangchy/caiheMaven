package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.Group;

/**
 * ������ݿ��������
 * 
 * @author caihe
 */
public interface GroupMapper {
	/**
	 * ����һ����¼
	 * 
	 * @param group
	 * @return
	 */
	Integer insertGroup(Group group);

	/**
	 * �����������¼
	 * 
	 * @param groups
	 * @return
	 */
	Integer insertGroupBatch(@Param("groups") List<Group> groups);

	/**
	 * �������¼��Ϣ
	 * 
	 * @param group
	 * @return
	 */
	Integer updateGroup(Group group);

	/**
	 * ������idɾ��
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteGroupById(@Param("id") String id);

	/**
	 * ����ɾ��
	 * 
	 * @param ids
	 * @return
	 */
	Integer deleteGroupBatch(@Param("ids") List<String> ids);

	/**
	 * ���ݸ�idɾ��
	 * 
	 * @param parentId
	 * @return
	 */
	Integer deleteGroupByParentId(@Param("parentId") String parentId);
}
