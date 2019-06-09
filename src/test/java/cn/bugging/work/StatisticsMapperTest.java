package cn.bugging.work;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import cn.bugging.work.dao.StatisticsDao;
import cn.bugging.work.entity.MonthEntity;
import cn.bugging.work.utils.filters.ListResult;

@SpringBootTest
@RunWith(SpringJUnit4ClassRunner.class)
public class StatisticsMapperTest {
	/**
	 * @author HuangJq
	 * @Description
	 * 
	 */

	@Autowired
	private StatisticsDao statisticsDao;
	
	@Test
	public void test()
	{
		System.out.println(ListResult.monthDataResult(statisticsDao.getStatisticsStatusData("1")));
	}
}
