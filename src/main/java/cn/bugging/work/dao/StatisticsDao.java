package cn.bugging.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.bugging.work.entity.MonthEntity;
import cn.bugging.work.entity.StatusEntity;

public interface StatisticsDao {

	/**
	 * 
	 * @return
	 * @Description 获取Bug状态名
	 */
	@Select("SELECT status_name FROM bug_status")
	@Results(@Result(property = "statusName", column = "status_name"))
	List<StatusEntity> getStatusNameList();

	/**
	 * 
	 * @return
	 * @Description 获取Bug类型名
	 */
	@Select("SELECT type_name FROM bug_type")
	@Results(@Result(property = "typeName", column = "type_name"))
	List<StatusEntity> getTypeNameList();

	/**
	 * 
	 * @return
	 * @Description 获取Bug优先级名
	 */
	@Select("SELECT priority_name FROM bug_priority")
	@Results(@Result(property = "priorityName", column = "priority_name"))
	List<StatusEntity> getPriorityNameList();

	/**
	 * 
	 * @param statusID
	 * @return 
	 * @Description 根据statusID来查询对应的data数据
	 */
	@Select("select \r\n" + 
			"    sum(case when MONTH(createtime)=\"1\" then 1 else 0 end)'Jan', \r\n" + 
			"    sum(case when MONTH(createtime)=\"2\" then 1 else 0 end)'Feb',\r\n" + 
			"    sum(case when MONTH(createtime)=\"3\" then 1 else 0 end)'Mar',\r\n" + 
			"    sum(case when MONTH(createtime)=\"4\" then 1 else 0 end)'Apr',\r\n" + 
			"    sum(case when MONTH(createtime)=\"5\" then 1 else 0 end)'May',\r\n" + 
			"    sum(case when MONTH(createtime)=\"6\" then 1 else 0 end)'Jun',\r\n" + 
			"    sum(case when MONTH(createtime)=\"7\" then 1 else 0 end)'Jul',\r\n" + 
			"    sum(case when MONTH(createtime)=\"8\" then 1 else 0 end)'Aug',\r\n" + 
			"    sum(case when MONTH(createtime)=\"9\" then 1 else 0 end)'Sept',\r\n" + 
			"    sum(case when MONTH(createtime)=\"10\" then 1 else 0 end)'Oct',\r\n" + 
			"    sum(case when MONTH(createtime)=\"11\" then 1 else 0 end)'Nov',\r\n" + 
			"    sum(case when MONTH(createtime)=\"12\" then 1 else 0 end)'Dec'\r\n" + 
			"from bug_detail where YEAR(createtime) = DATE_FORMAT(NOW(), '%Y') AND status_id=#{StatusID}\r\n" + 
			"")
	MonthEntity getStatisticsStatusData(String StatusID);
	
	/**
	 * 
	 * @param typeID
	 * @return 
	 * @Description 根据typeID来查询对应的data数据
	 */
	@Select("select \r\n" + 
			"    sum(case when MONTH(createtime)=\"1\" then 1 else 0 end)'Jan', \r\n" + 
			"    sum(case when MONTH(createtime)=\"2\" then 1 else 0 end)'Feb',\r\n" + 
			"    sum(case when MONTH(createtime)=\"3\" then 1 else 0 end)'Mar',\r\n" + 
			"    sum(case when MONTH(createtime)=\"4\" then 1 else 0 end)'Apr',\r\n" + 
			"    sum(case when MONTH(createtime)=\"5\" then 1 else 0 end)'May',\r\n" + 
			"    sum(case when MONTH(createtime)=\"6\" then 1 else 0 end)'Jun',\r\n" + 
			"    sum(case when MONTH(createtime)=\"7\" then 1 else 0 end)'Jul',\r\n" + 
			"    sum(case when MONTH(createtime)=\"8\" then 1 else 0 end)'Aug',\r\n" + 
			"    sum(case when MONTH(createtime)=\"9\" then 1 else 0 end)'Sept',\r\n" + 
			"    sum(case when MONTH(createtime)=\"10\" then 1 else 0 end)'Oct',\r\n" + 
			"    sum(case when MONTH(createtime)=\"11\" then 1 else 0 end)'Nov',\r\n" + 
			"    sum(case when MONTH(createtime)=\"12\" then 1 else 0 end)'Dec'\r\n" + 
			"from bug_detail where YEAR(createtime) = DATE_FORMAT(NOW(), '%Y') AND type_id=#{typeID}\r\n" + 
			"")
	MonthEntity getStatisticsTypeData(String typeID);
	
	/**
	 * 
	 * @param priorityID
	 * @return 
	 * @Description 根据priorityID来查询对应的data数据
	 */
	@Select("select \r\n" + 
			"    sum(case when MONTH(createtime)=\"1\" then 1 else 0 end)'Jan', \r\n" + 
			"    sum(case when MONTH(createtime)=\"2\" then 1 else 0 end)'Feb',\r\n" + 
			"    sum(case when MONTH(createtime)=\"3\" then 1 else 0 end)'Mar',\r\n" + 
			"    sum(case when MONTH(createtime)=\"4\" then 1 else 0 end)'Apr',\r\n" + 
			"    sum(case when MONTH(createtime)=\"5\" then 1 else 0 end)'May',\r\n" + 
			"    sum(case when MONTH(createtime)=\"6\" then 1 else 0 end)'Jun',\r\n" + 
			"    sum(case when MONTH(createtime)=\"7\" then 1 else 0 end)'Jul',\r\n" + 
			"    sum(case when MONTH(createtime)=\"8\" then 1 else 0 end)'Aug',\r\n" + 
			"    sum(case when MONTH(createtime)=\"9\" then 1 else 0 end)'Sept',\r\n" + 
			"    sum(case when MONTH(createtime)=\"10\" then 1 else 0 end)'Oct',\r\n" + 
			"    sum(case when MONTH(createtime)=\"11\" then 1 else 0 end)'Nov',\r\n" + 
			"    sum(case when MONTH(createtime)=\"12\" then 1 else 0 end)'Dec'\r\n" + 
			"from bug_detail where YEAR(createtime) = DATE_FORMAT(NOW(), '%Y') AND priority_id=#{priorityID}\r\n" + 
			"")
	MonthEntity getStatisticsPriorityData(String priorityID);
}
