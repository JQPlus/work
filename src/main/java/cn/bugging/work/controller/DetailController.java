package cn.bugging.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bugging.work.dao.DetailDao;
import cn.bugging.work.entity.DetailEntity;
import cn.bugging.work.entity.StatusEntity;
import cn.bugging.work.entity.TypeEntity;
import cn.bugging.work.entity.PriorityEntity;
import cn.bugging.work.service.DetailService;

/**
 * @author HuangJq
 * @Description
 * 
 */
@RestController
@RequestMapping("/detail")
public class DetailController {

	@Autowired
	private DetailService detailService;

	@PostMapping("info")
	public List<DetailEntity> getDetailInfo() {
		return detailService.getAllDetail();
	}

	@PostMapping("/status")
	public List<StatusEntity> getStatus() {
		return detailService.getStatusInfo();
	}

	@PostMapping("/type")
	public List<TypeEntity> getType() {
		return detailService.getTypeInfo();
	}

	@PostMapping("/priority")
	public List<PriorityEntity> getPriority() {
		return detailService.getPriorityInfo();
	}

	@PostMapping("/insert")
	public boolean insertDetail(DetailEntity detail) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@PostMapping("/delete")
	public boolean deleteDetail(String ID) {
		try {

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@PostMapping("/update")
	public boolean updateDetail(DetailEntity detail) {
		try {
			
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

}
