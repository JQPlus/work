package cn.bugging.work.service;

import java.util.List;

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
	boolean delete(String id);
}
