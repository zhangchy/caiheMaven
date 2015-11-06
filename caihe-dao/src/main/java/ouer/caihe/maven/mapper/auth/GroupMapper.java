package ouer.caihe.maven.mapper.auth;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import ouer.caihe.maven.auth.model.Group;

/**
 * 组的数据库操作集合
 * 
 * @author caihe
 */
public interface GroupMapper {
	/**
	 * 新增一条记录
	 * 
	 * @param group
	 * @return
	 */
	Integer insertGroup(Group group);

	/**
	 * 批量插入组记录
	 * 
	 * @param groups
	 * @return
	 */
	Integer insertGroupBatch(@Param("groups") List<Group> groups);

	/**
	 * 更新组记录信息
	 * 
	 * @param group
	 * @return
	 */
	Integer updateGroup(Group group);

	/**
	 * 根据组id删除
	 * 
	 * @param id
	 * @return
	 */
	Integer deleteGroupById(@Param("id") String id);

	/**
	 * 批量删除
	 * 
	 * @param ids
	 * @return
	 */
	Integer deleteGroupBatch(@Param("ids") List<String> ids);

	/**
	 * 根据父id删除
	 * 
	 * @param parentId
	 * @return
	 */
	Integer deleteGroupByParentId(@Param("parentId") String parentId);
}
