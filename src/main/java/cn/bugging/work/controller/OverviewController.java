package cn.bugging.work.controller;

import java.util.List;
import java.util.Map;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bugging.work.entity.HistoryEntity;
import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.service.OverviewService;


//实现该类下所有方法都会自动以Json格式返回数据(放在方法前同理)=@controller+@responsebody
@RestController
@RequestMapping("/overview")
/**
 * @author HuangJq
 * @Description
 * 
 */
public class OverviewController {

	@Autowired
	private OverviewService overviewService;

	/**
	 * 
	 * @param creator
	 * @param belongto
	 * @return 一个map，包含所需要的数据
	 * @Description overview界面->关于我的缺陷统计数目
	 */
	@PostMapping("/statistic")
	public Map<String, Integer> initStatistic(String creator,String belongto) {
		return overviewService.initStatistic(creator, belongto);
	}

	/**
	 * 
	 * @param creator
	 * @return
	 * @Description 饼图->我的任务->数据
	 */
	@PostMapping("/mychart")
	public List<Map<String, Object>> initMyPieChart(String creator, String belongto) {
		return overviewService.initMyPieChart(creator, belongto);
	}

	/**
	 * 
	 * @param creator
	 * @return
	 * @Description 饼图->所有的任务->数据
	 */
	@PostMapping("/allchart")
	public List<Map<String, Object>> initAllPieChart(String creator, String belongto) {
		return overviewService.initAllPieChart(creator, belongto);
	}
	/**
	 * 
	 * @param userName
	 * @return 
	 * @Description 添加用户成员操作
	 */
	@PostMapping("/adduser")
	public boolean addUser(String userName) {
		if(overviewService.addUser(userName)){
			return true;
		}
		return false;
	}
	
	@GetMapping("/getuser")
	public List<UserEntity> getUser() {
		return overviewService.getUser();
	}
	
	@GetMapping("/history")
	public List<HistoryEntity> getHistory() {
		return overviewService.getHistory();
	}

}
