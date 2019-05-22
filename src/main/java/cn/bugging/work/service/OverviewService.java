package cn.bugging.work.service;

import java.util.List;
import java.util.Map;

import cn.bugging.work.entity.UserEntity;

public interface OverviewService {
	/**
	 * @param creator
	 * @return 问题数目
	 * @Description 我创建的问题
	 */
	int getMyCreateNum(String creator);

	/**
	 * @param belongto
	 * @return 问题数目
	 * @Description 指派给我的问题->所属人为自己
	 */
	int getBelongtoMeNum(String belongto);

	/**
	 * @param creator
	 * @param belongto
	 * @return 问题数目
	 * @Description 待我解决的问题->所属人为自己，并且状态！=已拒绝或者已验收
	 */
	int getMyHandlingNum(String belongto);

	/**
	 * @param creator
	 * @param belongto
	 * @return 问题数目
	 * @Description 我跟踪的问题（创建人或者所属人为自己，并且状态！=已拒绝或者已验收）
	 */
	int getMyTraceNum(String creator, String belongto);

	/***
	 * @return 问题数目
	 * @Description 所有未关闭的问题
	 */
	int getAllUnclosedNum();

	/**
	 * @return 问题数目
	 * @Description 所有新建的问题
	 */

	int getAllNewCreateNum();

	/**
	 * 
	 * @return 问题数目
	 * @Description 全部待解决的问题
	 */
	int getAllHandlingNum();

	/**
	 * 
	 * @return 问题数目
	 * @Description 全部已解决的问题
	 */
	int getAllSolvedNum();

	/**
	 * 
	 * @return 问题数目
	 * @Description 全部已拒绝的问题
	 */
	int getAllRefusedNum();

	/**
	 * 
	 * @return 问题数目
	 * @Description 全部已验收的问题
	 */
	int getAllCheckedNum();

	/**
	 * 
	 * @return 问题数目
	 * @Description 全部延期的问题
	 */
	int getAllDelayedNum();

	
	Map<String, Integer> initStatistic(String creator, String belongto);
	/**
	 * 
	 * @param name
	 * @param value
	 * @return
	 * @Description 生成overview中关于我->饼形图统计数据的map，并放入list中
	 */
	List<Map<String, Object>> initMyPieChart(String creator, String belongto);

	/**
	 * 
	 * @param name
	 * @param value
	 * @return
	 * @Description 生成overview中所有问题->饼形图统计数据的map，并放入list中
	 */
	List<Map<String, Object>> initAllPieChart(String creator, String belongto);
	
	/**
	 * 
	 * @param userName
	 * @return 
	 * @Description 根据输入的用户名添加自定义成员
	 */
	boolean addUser(String userName);
	/**
	 * 
	 * @return 
	 * @Description 获取用户列表
	 */
	List<UserEntity> getUser();

}
