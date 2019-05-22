package cn.bugging.work.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import cn.bugging.work.dao.DetailDao;
import cn.bugging.work.entity.DetailEntity;
import cn.bugging.work.entity.StatusEntity;
import cn.bugging.work.entity.TypeEntity;
import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.entity.PriorityEntity;
import cn.bugging.work.service.DetailService;

/**
 * @author HuangJq
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
	public List<DetailEntity> getMyCreateInfo(String creator) {
		// TODO Auto-generated method stub
				List<DetailEntity> originList = detailDao.getMyCreateInfo(creator);
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
	public List<DetailEntity> getMyHandlingInfo(String belongto) {
		// TODO Auto-generated method stub
		List<DetailEntity> originList = detailDao.getMyHandlingInfo(belongto);
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
	public List<DetailEntity> getBelongtoMeInfo(String belongto) {
		// TODO Auto-generated method stub
		List<DetailEntity> originList = detailDao.getBelongtoMeInfo(belongto);
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
	public List<DetailEntity> getMyTraceInfo(String creator, String belongto) {
		// TODO Auto-generated method stub
		List<DetailEntity> originList = detailDao.getMyTraceInfo(creator, belongto);
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
	public List<DetailEntity> getAllUnclosedInfo() {
		// TODO Auto-generated method stub
		List<DetailEntity> originList = detailDao.getAllUnclosedInfo();;
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
	public boolean insert(DetailEntity detail) {
		// TODO Auto-generated method stub
		try {
			// 生成随机uuid
			String uuid = UUID.randomUUID().toString().replace("-", "").toLowerCase();
			Date date = new Date();
			detail.setID(uuid);
			detail.setCreatetime(date);
			detail.setUpdatetime(date);
			detail.setStatusID(detailDao.getStatusID(detail.getStatusName()));
			detail.setTypeID(detailDao.getTypeID(detail.getTypeName()));
			detail.setPriorityID(detailDao.getpriorityID(detail.getPriorityName()));
			detailDao.insert(detail);
			return true;
		} catch (Exception e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean update(@RequestBody DetailEntity detail) {
		// TODO Auto-generated method stub
		try {
			Date date = new Date();
			detail.setUpdatetime(date);
			detailDao.update(detail);
			return true;
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(String ID) {
		// TODO Auto-generated method stub
		try {
			List<DetailEntity> list = detailDao.getInfoByID(ID);
			if (!list.isEmpty()) {
				detailDao.delete(ID);
				return true;
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new NullPointerException("当前Bug信息不存在，请重试！");
		}
		return false;
	}

	@Override
	public List<DetailEntity> getInfoByID(String ID) {
		// TODO Auto-generated method stub
		return detailDao.getInfoByID(ID);
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

}
