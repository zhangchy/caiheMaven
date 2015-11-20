package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.Resource;

public interface ResourceMapper {
	/**
	 * ����һ����¼
	 * 
	 * @param group
	 * @return
	 */
	Integer insertResource(Resource resource);

	/**
	 * �������¼��Ϣ
	 * 
	 * @param group
	 * @return
	 */
	Integer updateResource(Resource resource);

	/**
	 * ������idɾ��
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteResourceById(@Param("id") String id);

	/**
	 * ����ɾ��
	 * 
	 * @param ids
	 * @return
	 */
	Integer deleteResourceBatch(@Param("ids") List<String> ids);

	/**
	 * ���ݸ�idɾ��
	 * 
	 * @param parentId
	 * @return
	 */
	Integer deleteResourceByParentId(@Param("parentId") String parentId);
	/**
	 * ����id��ȡ
	 * @param id
	 * @return
	 */
	Resource selectResourceById(@Param("id")String id);
	
	/**
	 * ����parent_id,is_menu��ȡ
	 * @param parentId
	 * @param isMenu
	 * @return
	 */
	List<Resource> selectResourcesByParams(@Param("parentId") String parentId,@Param("is_menu") Boolean isMenu);
	
	/**
	 * ��ȡ���е�url��Ϊ�յĲ˵���Դ
	 * @return
	 */
	List<Resource> selectAllResourcesUrlNotNull();
}
