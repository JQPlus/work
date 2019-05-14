package cn.bugging.work.service.impl;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bugging.work.dao.DetailDao;
import cn.bugging.work.entity.DetailEntity;
import cn.bugging.work.entity.StatusEntity;
import cn.bugging.work.entity.TypeEntity;
import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.entity.PriorityEntity;
import cn.bugging.work.service.DetailService;

/**
 * @author HuangJq @Date 2019年5月2日下午5:21:19
 * @Description bug详情的业务逻辑实现
 * 
 */
@Service
public class DetailServiceImpl implements DetailService {

	@Autowired
	private DetailDao detailDao;

	@Override
	public List<DetailEntity> getAllDetail() {
		// TODO Auto-generated method stub
		List<DetailEntity> originList = detailDao.getAllDetail();
		List<DetailEntity> resultList = new ArrayList<>();
		resultList.addAll(originList);
		for (DetailEntity list : resultList) {
			if (list != null) {
				list.setStatusName(detailDao.getStatusNameByID(list.getStatusID()));
				list.setTypeName(detailDao.getTypeNameByID(list.getTypeID()));
				list.setPriorityName(detailDao.getPriorityNameByID(list.getPriorityID()));
			}
		}
		return resultList;
	}

	@Override
	public List<StatusEntity> getStatusInfo() {
		// TODO Auto-generated method stub
		return detailDao.getStatusInfo();
	}

	@Override
	public List<TypeEntity> getTypeInfo() {
		// TODO Auto-generated method stub
		return detailDao.getTypeInfo();
	}

	@Override
	public List<PriorityEntity> getPriorityInfo() {
		// TODO Auto-generated method stub
		return detailDao.getPriorityInfo();
	}

	@Override
	public String getpriorityNameByID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatusNameByID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTypeNameByID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getpriorityID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getStatusID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTypeID() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public boolean insert(DetailEntity detail) {
		// TODO Auto-generated method stub
		try {
			detailDao.insert(detail);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean update(DetailEntity detail) {
		// TODO Auto-generated method stub
		try {
			if (!detail.getID().isEmpty()) {
				detailDao.update(detail);
				return true;
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new NullPointerException("当前Bug信息不存在，请重试！");
		}
		return false;
	}

	@Override
	public boolean delete(String ID) {
		// TODO Auto-generated method stub
		try {
			List<DetailEntity> list = detailDao.getDetailByID(ID);
			if (!list.isEmpty()) {
				detailDao.delete(ID);
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new NullPointerException("当前Bug信息不存在，请重试！");
		}
		return false;
	}

}
