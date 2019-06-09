package cn.bugging.work.service;

import java.util.List;

import org.apache.ibatis.annotations.Select;

import cn.bugging.work.entity.DetailEntity;
import cn.bugging.work.entity.StatusEntity;
import cn.bugging.work.entity.TypeEntity;
import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.entity.PriorityEntity;

public interface DetailService {
	/**
	 * 
	 * @return 信息列表
	 * @Description 所有bug信息
	 */
	List<DetailEntity> getAllDetail();
	
	/**
	 * 
	 * @param ID
	 * @return 
	 * @Description 根据信息ID查找信息
	 */
	DetailEntity getInfoByID(String ID);
	
	/**
	 * 
	 * @param creator
	 * @return 
	 * @Description 我创建的问题列表(创建人为自己)
	 */
	List<DetailEntity> getMyCreateInfo(String creator);
	

	/**
	 * 
	 * @param belongto
	 * @return 
	 * @Description 待我解决的问题(所属人为自己，状态!=已拒绝和已验收)
	 */
	List<DetailEntity> getMyHandlingInfo(String belongto);
	
	/**
	 * 
	 * @param belongto
	 * @return 
	 * @Description 指派给我的问题
	 */
	List<DetailEntity> getBelongtoMeInfo(String belongto);

	/**
	 * 
	 * @param creator
	 * @param belongto
	 * @return 
	 * @Description 我跟踪的问题(创建人或者所属人为自己的问题，并且问题状态！=已拒绝和已验收)
	 */
	List<DetailEntity> getMyTraceInfo(String creator,String belongto);
	
	/**
	 * 
	 * @return 
	 * @Description 所有未关闭的问题数目
	 */
	List<DetailEntity> getAllUnclosedInfo();
	
	/**
	 * 
	 * @return bug状态的列表
	 * @Description 获取bug处理状态
	 */
	List<StatusEntity> getStatusInfo();

	/**
	 * 
	 * @return bug类型的列表
	 * @Description 获取bug类型
	 */
	List<TypeEntity> getTypeInfo();

	/**
	 * 
	 * @return bug处理优先级的列表
	 * @Description 获取bug处理优先级
	 */
	List<PriorityEntity> getPriorityInfo();

	/**
	 * 
	 * @return 优先级name
	 * @Description 根据ID查询优先级名字
	 */
	String getpriorityNameByID();

	/**
	 * 
	 * @return bug状态name
	 * @Description 根据ID查询状态名字
	 */
	String getStatusNameByID();

	/**
	 * 
	 * @return
	 * @Description 根据ID查询bug类型名字
	 */
	String getTypeNameByID();

	/**
	 * 
	 * @return 优先级ID
	 * @Description 根据优先级名字返回ID
	 */
	String getpriorityID();

	/**
	 * 
	 * @return bug处理状态ID
	 * @Description 根据状态名字返回ID
	 */
	String getStatusID();

	/**
	 * 
	 * @return bug类型ID
	 * @Description 根据bug类型名字返回ID
	 */
	String getTypeID();

	/**
	 * 
	 * @param detail
	 * @return
	 * @Description 新增bug信息
	 */
	boolean insert(DetailEntity detail);

	/**
	 * 
	 * @param user
	 * @return
	 * @Description 更新bug信息
	 */
	boolean update(DetailEntity detail);

	/**
	 * 
	 * @param id
	 * @return
	 * @Description 删除
	 */
	boolean delete(DetailEntity detail);
}
