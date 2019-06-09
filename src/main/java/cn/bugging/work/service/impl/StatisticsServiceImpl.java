package cn.bugging.work.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bugging.work.dao.StatisticsDao;
import cn.bugging.work.entity.MonthEntity;
import cn.bugging.work.service.StatisticsService;
import cn.bugging.work.utils.consts.Priority;
import cn.bugging.work.utils.consts.Status;
import cn.bugging.work.utils.consts.Type;
import cn.bugging.work.utils.filters.ListResult;

/**
 * @author HuangJq
 * @Description
 * 
 */
@Service
public class StatisticsServiceImpl implements StatisticsService {

	@Autowired
	private StatisticsDao statisticsDao;

	@Override
	public Map<String, List<String>> getStatusList() {
		// TODO Auto-generated method stub
		Map<String, List<String>> map = new HashMap<>();
		// 得到最后的状态为｛状态名:list｝
		map.put(Status.CREATE, ListResult.monthDataResult(statisticsDao.getStatisticsStatusData("1")));
		map.put(Status.HANDLE, ListResult.monthDataResult(statisticsDao.getStatisticsStatusData("2")));
		map.put(Status.SOLVED, ListResult.monthDataResult(statisticsDao.getStatisticsStatusData("3")));
		map.put(Status.REFUSE, ListResult.monthDataResult(statisticsDao.getStatisticsStatusData("4")));
		map.put(Status.CHECKE, ListResult.monthDataResult(statisticsDao.getStatisticsStatusData("5")));
		map.put(Status.DELAY, ListResult.monthDataResult(statisticsDao.getStatisticsStatusData("6")));
		return map;
	}

	@Override
	public Map<String, List<String>> getTypeList() {
		// TODO Auto-generated method stub
		Map<String, List<String>> map = new HashMap<>();
		// 得到最后的状态为｛类型名字:list｝
		map.put(Type.FUNCTION_BUG, ListResult.monthDataResult(statisticsDao.getStatisticsTypeData("1")));
		map.put(Type.UI_BUG, ListResult.monthDataResult(statisticsDao.getStatisticsTypeData("2")));
		map.put(Type.DATA_MISTAKE, ListResult.monthDataResult(statisticsDao.getStatisticsTypeData("3")));
		map.put(Type.FEEDBACK, ListResult.monthDataResult(statisticsDao.getStatisticsTypeData("4")));
		map.put(Type.EXCEPTION, ListResult.monthDataResult(statisticsDao.getStatisticsTypeData("5")));
		map.put(Type.MISSION, ListResult.monthDataResult(statisticsDao.getStatisticsTypeData("6")));
		map.put(Type.DEMAND, ListResult.monthDataResult(statisticsDao.getStatisticsTypeData("7")));
		map.put(Type.OTHER, ListResult.monthDataResult(statisticsDao.getStatisticsTypeData("8")));
		return map;
	}

	@Override
	public Map<String, List<String>> getPriorityList() {
		// TODO Auto-generated method stub
		Map<String, List<String>> map = new HashMap<>();
		// 得到最后的状态为｛优先级名字:list｝
		map.put(Priority.FATAL, ListResult.monthDataResult(statisticsDao.getStatisticsPriorityData("1")));
		map.put(Priority.SERIOUS, ListResult.monthDataResult(statisticsDao.getStatisticsPriorityData("2")));
		map.put(Priority.GENERAL, ListResult.monthDataResult(statisticsDao.getStatisticsPriorityData("3")));
		map.put(Priority.SLIGHT, ListResult.monthDataResult(statisticsDao.getStatisticsPriorityData("4")));
		return map;
	}

}
