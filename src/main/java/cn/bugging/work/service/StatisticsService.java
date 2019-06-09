package cn.bugging.work.service;

import java.util.List;
import java.util.Map;

public interface StatisticsService {

	/**
	 * 
	 * @return
	 * @Description 获取所有Bug状态所对应的list
	 */
	Map<String, List<String>> getStatusList();

	/**
	 * 
	 * @return
	 * @Description 获取所有Bug类型所对应的list
	 */
	Map<String, List<String>> getTypeList();

	/**
	 * 
	 * @return
	 * @Description 获取所有Bug优先级所对应的list
	 */
	Map<String, List<String>> getPriorityList();

}
