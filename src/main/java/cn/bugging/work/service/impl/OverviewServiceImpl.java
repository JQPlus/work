package cn.bugging.work.service.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Service;

import cn.bugging.work.dao.OverviewDao;
import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.service.OverviewService;
import cn.bugging.work.utils.consts.Status;
import cn.bugging.work.utils.filters.MapResult;

/**
 * @author HuangJq
 * @Description 总览
 * 
 */
@Service
public class OverviewServiceImpl implements OverviewService {

	@Autowired
	private OverviewDao overviewDao;

	@Override
	public int getMyCreateNum(String creator) {
		// TODO Auto-generated method stub
		return overviewDao.getMyCreateNum(creator);
	}

	@Override
	public int getBelongtoMeNum(String belongto) {
		// TODO Auto-generated method stub
		return overviewDao.getBelongtoMeNum(belongto);
	}

	@Override
	public int getMyHandlingNum(String belongto) {
		// TODO Auto-generated method stub
		return overviewDao.getMyHandlingNum(belongto);
	}

	@Override
	public int getMyTraceNum(String creator, String belongto) {
		// TODO Auto-generated method stub
		return overviewDao.getMyTraceNum(creator, belongto);
	}

	@Override
	public int getAllUnclosedNum() {
		// TODO Auto-generated method stub
		return overviewDao.getAllUnclosedNum();
	}

	@Override
	public int getAllNewCreateNum() {
		// TODO Auto-generated method stub
		return overviewDao.getAllNewCreateNum();
	}

	@Override
	public int getAllHandlingNum() {
		// TODO Auto-generated method stub
		return overviewDao.getAllHandlingNum();
	}

	@Override
	public int getAllSolvedNum() {
		// TODO Auto-generated method stub
		return overviewDao.getAllSolvedNum();
	}

	@Override
	public int getAllRefusedNum() {
		// TODO Auto-generated method stub
		return overviewDao.getAllRefusedNum();
	}

	@Override
	public int getAllCheckedNum() {
		// TODO Auto-generated method stub
		return overviewDao.getAllCheckedNum();
	}

	@Override
	public int getAllDelayedNum() {
		// TODO Auto-generated method stub
		return overviewDao.getAllDelayedNum();
	}

	/**
	 * 
	 * @param name
	 * @param value
	 * @return
	 * @Description 生成overview中关于我->统计数据的map
	 */
	@Override
	public Map<String, Integer> initStatistic(String creator, String belongto) {
		Map<String, Integer> map = new HashMap<>();
		try {
			map.put(Status.CREATE_BY_ME, overviewDao.getMyCreateNum(creator));
			map.put(Status.TRACE_BY_ME, overviewDao.getMyTraceNum(creator, belongto));
			map.put(Status.HANDLE_BY_ME, overviewDao.getMyHandlingNum(belongto));
			map.put(Status.BELONG_TO_ME, overviewDao.getBelongtoMeNum(belongto));
		} catch (Exception e) {
			// TODO: handle exception
			System.out.println("初始化错误");
		}
		return map;
	}

	/**
	 * 
	 * @param name
	 * @param value
	 * @return
	 * @Description 生成overview中关于我->饼形图统计数据的map，并放入list中
	 */
	@Override
	public List<Map<String, Object>> initMyPieChart(String creator, String belongto) {
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			list.add(MapResult.createChartMap(Status.CREATE, overviewDao.getMyCreateNum(creator)));
			list.add(MapResult.createChartMap(Status.HANDLE, overviewDao.getMyHandlingNum(belongto)));
			list.add(MapResult.createChartMap(Status.SOLVED, overviewDao.getMySolvedNum(belongto)));
			list.add(MapResult.createChartMap(Status.REFUSE, overviewDao.getAMyRefusedNum(belongto)));
			list.add(MapResult.createChartMap(Status.CHECKE, overviewDao.getMyCheckedNum(belongto)));
			list.add(MapResult.createChartMap(Status.DELAY, overviewDao.getMyDelayedNum(belongto)));
			// 清空value值为0的map,否则echart会显示出来
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);
				if (map.get("value").equals(0)) {
					list.remove(map);
					i -= 1;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return list;
	}

	/**
	 * 
	 * @param name
	 * @param value
	 * @return
	 * @Description 生成overview中所有问题->饼形图统计数据的map，并放入list中
	 */
	@Override
	public List<Map<String, Object>> initAllPieChart(String creator, String belongto) {
		List<Map<String, Object>> list = new ArrayList<>();
		try {
			list.add(MapResult.createChartMap(Status.CREATE, overviewDao.getAllNewCreateNum()));
			list.add(MapResult.createChartMap(Status.HANDLE, overviewDao.getAllHandlingNum()));
			list.add(MapResult.createChartMap(Status.SOLVED, overviewDao.getAllSolvedNum()));
			list.add(MapResult.createChartMap(Status.REFUSE, overviewDao.getAllRefusedNum()));
			list.add(MapResult.createChartMap(Status.CHECKE, overviewDao.getAllCheckedNum()));
			list.add(MapResult.createChartMap(Status.DELAY, overviewDao.getAllDelayedNum()));
			// 清空value值为0的map,否则echart会显示出来
			for (int i = 0; i < list.size(); i++) {
				Map<String, Object> map = list.get(i);
				if (map.get("value").equals(0)) {
					list.remove(map);
					i -= 1;
				}
			}
		} catch (Exception e) {
			// TODO: handle exception
		}
		return list;
	}

	@Override
	public boolean addUser(String userName) {
		// TODO Auto-generated method stub
		UserEntity user = new UserEntity();
		String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
		user.setID(uuid);
		user.setUsername(userName);
		user.setPassword(userName);
		if (overviewDao.addUser(user)) {
			return true;
		}
		return false;
	}

	@Override
	public List<UserEntity> getUser() {
		return overviewDao.getUser();
	}

}
