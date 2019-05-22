package cn.bugging.work.dao;

import java.nio.channels.ScatteringByteChannel;
import java.util.Date;
import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;

import cn.bugging.work.entity.DetailEntity;
import cn.bugging.work.entity.PriorityEntity;
import cn.bugging.work.entity.StatusEntity;
import cn.bugging.work.entity.TypeEntity;
import cn.bugging.work.entity.UserEntity;

public interface DetailDao {
	/**
	 * 
	 * @return 信息列表
	 * @Description 所有bug信息
	 */
	@Select("SELECT * FROM bug_detail")
	@Results({ @Result(property = "statusID", column = "status_id"), @Result(property = "typeID", column = "type_id"),
			@Result(property = "priorityID", column = "priority_id") })
	List<DetailEntity> getAllDetail();

	/**
	 * 
	 * @param ID
	 * @return 对应ID的bug详情
	 * @Description 根据bug ID来查询相应的bug信息
	 */
	@Select("SELECT * FROM bug_detail WHERE id=#{ID}")
	List<DetailEntity> getInfoByID(String ID);

	/**
	 * 
	 * @param creator
	 * @return
	 * @Description 我创建的问题列表(创建人为自己)
	 */
	@Select("SELECT * FROM bug_detail WHERE creator=#{creator}")
	@Results({ @Result(property = "statusID", column = "status_id"), @Result(property = "typeID", column = "type_id"),
			@Result(property = "priorityID", column = "priority_id") })
	List<DetailEntity> getMyCreateInfo(String creator);

	/**
	 * 
	 * @param belongto
	 * @return
	 * @Description 待我解决的问题(所属人为自己，状态!=已拒绝和已验收)
	 */
	@Select("SELECT * FROM bug_detail WHERE belongto=#{belongto} AND status_id!=4 AND status_id!=5")
	@Results({ @Result(property = "statusID", column = "status_id"), @Result(property = "typeID", column = "type_id"),
			@Result(property = "priorityID", column = "priority_id") })
	List<DetailEntity> getMyHandlingInfo(String belongto);

	/**
	 * 
	 * @param belongto
	 * @return
	 * @Description 指派给我的问题
	 */
	@Select("SELECT * FROM bug_detail WHERE belongto=#{belongto}")
	@Results({ @Result(property = "statusID", column = "status_id"), @Result(property = "typeID", column = "type_id"),
			@Result(property = "priorityID", column = "priority_id") })
	List<DetailEntity> getBelongtoMeInfo(String belongto);

	/**
	 * 
	 * @param creator
	 * @param belongto
	 * @return
	 * @Description 我跟踪的问题(创建人或者所属人为自己的问题，并且问题状态！=已拒绝和已验收)
	 */
	@Select("SELECT * FROM bug_detail WHERE creator=#{creator} OR belongto=#{belongto} AND status_id!=4 AND status_id!=5")
	@Results({ @Result(property = "statusID", column = "status_id"), @Result(property = "typeID", column = "type_id"),
			@Result(property = "priorityID", column = "priority_id") })
	List<DetailEntity> getMyTraceInfo(String creator, String belongto);

	/**
	 * 
	 * @return
	 * @Description 所有未关闭的问题数目
	 */
	@Select("SELECT * FROM bug_detail WHERE status_id!=4 AND status_id!=5")
	@Results({ @Result(property = "statusID", column = "status_id"), @Result(property = "typeID", column = "type_id"),
			@Result(property = "priorityID", column = "priority_id") })
	List<DetailEntity> getAllUnclosedInfo();

	/**
	 * 
	 * @return bug状态的列表
	 * @Description 获取bug处理状态
	 */
	@Select("SELECT * FROM bug_status")
	@Results({ @Result(property = "ID", column = "id"), @Result(property = "statusName", column = "status_name"), })
	List<StatusEntity> getStatusInfo();

	/**
	 * 
	 * @return bug类型的列表
	 * @Description 获取bug类型
	 */
	@Select("SELECT * FROM bug_type")
	@Results({ @Result(property = "ID", column = "id"), @Result(property = "typeName", column = "type_name"), })
	List<TypeEntity> getTypeInfo();

	/**
	 * 
	 * @return bug处理优先级的列表
	 * @Description 获取bug处理优先级
	 */
	@Select("SELECT * FROM bug_priority")
	@Results({ @Result(property = "ID", column = "id"), @Result(property = "priorityName", column = "priority_name"), })
	List<PriorityEntity> getPriorityInfo();

	/**
	 * 
	 * @return 优先级name
	 * @Description 根据ID查询优先级名字
	 */
	@Select("SELECT priority_name FROM bug_priority WHERE id=#{priorityID}")
	String getPriorityNameByID(String priorityID);

	/**
	 * 
	 * @return bug状态name
	 * @Description 根据ID查询状态名字
	 */
	@Select("SELECT status_name FROM bug_status WHERE id=#{statusID}")
	String getStatusNameByID(String statusID);

	/**
	 * 
	 * @return
	 * @Description 根据ID查询bug类型名字
	 */
	@Select("SELECT type_name FROM bug_type WHERE id=#{typeID}")
	String getTypeNameByID(String typeID);

	/**
	 * 
	 * @return 优先级ID
	 * @Description 根据优先级名字返回ID
	 */
	@Select("SELECT id FROM bug_priority WHERE priority_name=#{priorityName}")
	String getpriorityID(String priorityName);

	/**
	 * 
	 * @return bug处理状态ID
	 * @Description 根据状态名字返回ID
	 */
	@Select("SELECT id FROM bug_status WHERE status_name=#{statusName}")
	String getStatusID(String statusName);

	/**
	 * 
	 * @return bug类型ID
	 * @Description 根据bug类型名字返回ID
	 */
	@Select("SELECT id FROM bug_type WHERE type_name=#{typeName}")
	String getTypeID(String typeName);

	/**
	 * 
	 * @param detail
	 * @return
	 * @Description 新增bug信息
	 */
	@Insert("INSERT INTO bug_detail"
			+ "(id,type_id,status_id,priority_id,brief,createtime,updatetime,creator,belongto) " + "VALUES"
			+ "(#{ID,jdbcType=VARCHAR},#{typeID,jdbcType=VARCHAR}, #{statusID,jdbcType=VARCHAR},"
			+ "#{priorityID,jdbcType=VARCHAR},#{brief,jdbcType=VARCHAR} ,#{createtime,jdbcType=TIMESTAMP},"
			+ "#{updatetime,jdbcType=TIMESTAMP},#{creator,jdbcType=VARCHAR}, #{belongto,jdbcType=VARCHAR})")
	boolean insert(DetailEntity detail);

	/**
	 * 
	 * @param user
	 * @return
	 * @Description 更新bug信息
	 */
	@Update("UPDATE bug_detail SET "
			+ "type_id=#{typeID,jdbcType=VARCHAR},status_id=#{statusID,jdbcType=VARCHAR},priority_id=#{priorityID,jdbcType=VARCHAR},"
			+ "brief=#{brief,jdbcType=VARCHAR} ,updatetime=#{updatetime} ,belongto=#{belongto,jdbcType=VARCHAR} WHERE id =#{ID,jdbcType=VARCHAR}")
	boolean update(DetailEntity detail);

	/**
	 * 
	 * @param id
	 * @return
	 * @Description 删除
	 */
	@Delete("DELETE FROM bug_detail WHERE id =#{ID}")
	boolean delete(String ID);
}
