package cn.bugging.work.controller;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bugging.work.service.StatisticsService;

/**
 * @author HuangJq @Date 2019年5月2日下午5:19:40
 * @Description
 * 
 */
@RestController
@RequestMapping("/statistics")
public class StatisticsController {
	@Autowired
	private StatisticsService statisticsService;
	
	@GetMapping("/statuslist")
	public Map<String,List<String>> getStatusList(){
		return statisticsService.getStatusList();
	}
	@GetMapping("/typelist")
	public Map<String,List<String>> getTypeList() {
		// TODO Auto-generated method stub
		return statisticsService.getTypeList();
	}

	@GetMapping("/prioritylist")
	public Map<String,List<String>> getPriorityList() {
		// TODO Auto-generated method stub
		return statisticsService.getPriorityList();
	}
}
