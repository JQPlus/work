package cn.bugging.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.bugging.work.entity.DetailEntity;
import cn.bugging.work.entity.priorityEntity;
import cn.bugging.work.entity.StatusEntity;
import cn.bugging.work.entity.TypeEntity;
import cn.bugging.work.entity.UserEntity;

public interface DetailDao {
	/**
	 * 
	 * @return 所有Bug信息
	 */
	@Select("SELECT * FROM bug_detail")
	List<DetailEntity> getAllDetail();

	/**
	 * 
	 * @return 根据ID查询优先级名字
	 */
	@Select("SELECT priority_name FROM bug_priority WHERE id=#{priorityID}")
	String getpriorityNameByID();

	/**
	 * 
	 * @return 根据ID查询状态名字
	 */
	@Select("SELECT status_name FROM bug_status WHERE id=#{statusID}")
	String getStatusNameByID();

	/**
	 * 
	 * @return 根据ID查询问题类型名字
	 */
	@Select("SELECT type_name FROM bug_type WHERE id=#{typeID}")
	String getTypeNameByID();

	/**
	 * 
	 * @return 根据优先级名字返回ID
	 */
	@Select("SELECT id FROM bug_priority WHERE priority_name=#{priorityName}")
	String getpriorityID();

	/**
	 * 
	 * @return 根据状态名字返回ID
	 */
	@Select("SELECT id FROM bug_status WHERE status_name=#{statusName}")
	String getStatusID();

	/**
	 * 
	 * @return 根据问题类型名字返回ID
	 */
	@Select("SELECT id FROM bug_type WHERE type_name=#{typeName}")
	String getTypeID();

	/**
	 * 新增bug信息
	 * 
	 * @param detail
	 * @return
	 */
	@Insert("INSERT INTO bug_detail"
			+ "(id,type_id,status_id,lev000el_id,brief,createtime,updatetime,creater,belongto) " + "VALUES"
			+ "(#{ID,jdbcType=VARCHAR},#{typeID,jdbcType=VARCHAR}, #{statusID,jdbcType=VARCHAR},"
			+ "#{priorityID,jdbcType=VARCHAR},#{brief,jdbcType=VARCHAR} ,#{createtime,jdbcType=DATE},"
			+ "#{updatetime,jdbcType=DATE},#{creater,jdbcType=VARCHAR}, #{creater,jdbcType=VARCHAR})")
	boolean insert(DetailEntity detail);

	/**
	 * 更新bug信息
	 * 
	 * @param user
	 * @return
	 */
	@Update("UPDATE bug_detail SET " + "type_id=#{typeID},status_id=#{statusID},priority_id=#{priorityID},"
			+ "brief=#{brief} ,updatetime=#{updatetime} ,belongto=#{belongto}" + "WHERE id =#{ID}")
	boolean update(UserEntity user);

	/**
	 * 删除
	 * 
	 * @param id
	 * @return
	 */
	@Delete("DELETE FROM bug_detail WHERE id =#{ID}")
	boolean delete(String id);
}
