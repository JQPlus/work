package cn.bugging.work.utils.filters;

/**
 * @author HuangJq
 * @Description
 * 
 */
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class MapResult {

	/**
	 * 
	 * @param name
	 * @param value
	 * @return
	 * @Description 生成overvie中->关于我->的统计数据map
	 */
	public static Map<String, Integer> createStatisticMap(String name,int value) {
		Map<String, Integer> map = new HashMap<>();
		map.put(name, value);
		return map;
	}
	/**
	 * 
	 * @param name
	 * @param value
	 * @return
	 * @Description 生成overview的饼形图的统计数据map
	 */
	public static Map<String, Object> createChartMap(String name, int value) {
		Map<String, Object> map = new HashMap<>();
		map.put("name", name);
		map.put("value", value);
		return map;
	}
	
	/**
	 * 
	 * @param name
	 * @param dataList
	 * @return 
	 * @Description statistics模块中，获取整个数据List
	 */
	public static Map<String, List<String>> statisticsResultMap(String name,List<String> dataList)
	{
		Map<String, List<String>> map = new HashMap<>();
		map.put(name, dataList);
		return map;
	}
}
