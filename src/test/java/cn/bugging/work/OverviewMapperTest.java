package cn.bugging.work;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bugging.work.dao.OverviewDao;
import cn.bugging.work.utils.consts.Status;
import cn.bugging.work.utils.filters.MapResult;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class OverviewMapperTest {
	/**
	 * @author HuangJq
	 * @Description
	 * 
	 */
	@Autowired
	private OverviewDao overviewDao;

//	@Test
//	public void getNum() throws Exception {
//		int num = overviewDao.getAllCheckedNum();
//		System.out.println(num);
//	}
	@Test
	public void initAllPieChart() {
		// CopyOnWriteArrayList
		List<Map<String, Object>> list = new ArrayList<>();

		list.add(MapResult.createChartMap(Status.CREATE, overviewDao.getAllNewCreateNum()));
		list.add(MapResult.createChartMap(Status.HANDLE, overviewDao.getAllHandlingNum()));
		list.add(MapResult.createChartMap(Status.SOLVED, overviewDao.getAllSolvedNum()));
		list.add(MapResult.createChartMap(Status.REFUSE, overviewDao.getAllRefusedNum()));
		list.add(MapResult.createChartMap(Status.CHECKE, overviewDao.getAllCheckedNum()));
		list.add(MapResult.createChartMap(Status.DELAY, overviewDao.getAllDelayedNum()));

//			Iterator<Map<String, Object>> it=list.iterator();
//			while(it.hasNext()){
//				Map<String, Object> map=it.next();
//			    if(map.get("value").equals(0)){
//			    	it.remove();
//			    }
//			}

//			for(Map<String, Object> map : list)
//			{
//				if(map.get("value").equals(0))
//				{
//					list.remove(map);
//				}
//			}
		for (int i = 0; i < list.size(); i++) {
			Map<String, Object> map=list.get(i);
			if(map.get("value").equals(0))
			{
				list.remove(map);
				i-=1;
			}
		}
		System.out.println(list);
	}
}
