package cn.bugging.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
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

	@GetMapping("info")
	public List<DetailEntity> getDetailInfo() {
		return detailService.getAllDetail();
	}

	@GetMapping("/status")
	public List<StatusEntity> getStatus() {
		return detailService.getStatusInfo();
	}

	@GetMapping("/type")
	public List<TypeEntity> getType() {
		return detailService.getTypeInfo();
	}

	@GetMapping("/priority")
	public List<PriorityEntity> getPriority() {
		return detailService.getPriorityInfo();
	}

	@PostMapping("/insert")
	public boolean insertDetail(@RequestBody DetailEntity detail) {
		try {
			if (detailService.getInfoByID(detail.getID()).isEmpty()) {
				detailService.insert(detail);
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@DeleteMapping("/delete")
	public boolean deleteDetail(String ID) {
		try {
			if (detailService.delete(ID))
				return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@PutMapping("/update")
	public boolean updateDetail(@RequestBody DetailEntity detail) {
		try {
			if (!detailService.getInfoByID(detail.getID()).isEmpty()) {
				detailService.update(detail);
				return true;
			}

		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return false;
	}

}
