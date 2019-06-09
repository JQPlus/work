package cn.bugging.work.utils.filters;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import cn.bugging.work.entity.MonthEntity;
import cn.bugging.work.service.StatisticsService;

/**
 * @author HuangJq
 * @Description
 * 
 */
@Component
public class ListResult {
	/**
	 * 
	 * @param month 1-12月的数据实体
	 * @return 返回1-12月数据列表
	 * @Description 将month实体中对应月份的数据依次添加到list中，返回给statistics使用
	 */
	public static List<String> monthDataResult(MonthEntity month) {
		List<String> result = new ArrayList<>();
		if (month == null)
			return new ArrayList<>(Collections.nCopies(12, "0"));
		result.add(month.getJan());
		result.add(month.getFeb());
		result.add(month.getMar());
		result.add(month.getApr());
		result.add(month.getMay());
		result.add(month.getJun());
		result.add(month.getJul());
		result.add(month.getAug());
		result.add(month.getSept());
		result.add(month.getOct());
		result.add(month.getNov());
		result.add(month.getDec());
		return result;
	}

}
