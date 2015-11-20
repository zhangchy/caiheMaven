package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.Resource;

public interface ResourceMapper {
	/**
	 * 新增一条记录
	 * 
	 * @param group
	 * @return
	 */
	Integer insertResource(Resource resource);

	/**
	 * 更新组记录信息
	 * 
	 * @param group
	 * @return
	 */
	Integer updateResource(Resource resource);

	/**
	 * 根据组id删除
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteResourceById(@Param("id") String id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	Integer deleteResourceBatch(@Param("ids") List<String> ids);

	/**
	 * 根据父id删除
	 * 
	 * @param parentId
	 * @return
	 */
	Integer deleteResourceByParentId(@Param("parentId") String parentId);
	/**
	 * 根据id获取
	 * @param id
	 * @return
	 */
	Resource selectResourceById(@Param("id")String id);
	
	/**
	 * 根据parent_id,is_menu获取
	 * @param parentId
	 * @param isMenu
	 * @return
	 */
	List<Resource> selectResourcesByParams(@Param("parentId") String parentId,@Param("is_menu") Boolean isMenu);
	
	/**
	 * 获取所有的url不为空的菜单资源
	 * @return
	 */
	List<Resource> selectAllResourcesUrlNotNull();
}
