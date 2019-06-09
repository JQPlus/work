package cn.bugging.work.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.RequestBody;

import cn.bugging.work.dao.DetailDao;
import cn.bugging.work.dao.HistoryDao;
import cn.bugging.work.entity.DetailEntity;
import cn.bugging.work.entity.HistoryEntity;
import cn.bugging.work.entity.StatusEntity;
import cn.bugging.work.entity.TypeEntity;
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
	@Autowired
	private HistoryDao historyDao;

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
		List<DetailEntity> originList = detailDao.getAllUnclosedInfo();
		;
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
			HistoryEntity history = new HistoryEntity();
			// 生成随机uuid
			String detailID = UUID.randomUUID().toString().replace("-", "").toLowerCase();
			detail.setID(detailID);
			//设置创建日期
			detail.setCreatetime(new Date());
			 //设置更新日期
			detail.setUpdatetime(new Date());
			detail.setStatusID(detailDao.getStatusID(detail.getStatusName()));
			detail.setTypeID(detailDao.getTypeID(detail.getTypeName()));
			detail.setPriorityID(detailDao.getpriorityID(detail.getPriorityName()));
			// 插入Bug记录
			detailDao.insert(detail);
			// 在这之后插入历史记录是因为自增ID在插入后才生成
			// 生成随机历史ID
			String historyID = UUID.randomUUID().toString().replace("-", "").toLowerCase();
			BeanUtils.copyProperties(detailDao.getInfoByID(detailID), history);
			history.setID(historyID);
			history.setBugID(detailID);
			history.setUpdater(detail.getUpdater());
			history.setRemark(detail.getRemark());
			history.setUpdatetime(new Date());
			historyDao.insert(history);
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
			HistoryEntity history = new HistoryEntity();
			detail.setUpdatetime(new Date());

			// 为历史记录定义ID
			String historyID = UUID.randomUUID().toString().replace("-", "").toLowerCase();
			// 将两个表中具有相同属性（非空）的列进行赋值
			DetailEntity sourceDetail = detailDao.getInfoByID(detail.getID());
			BeanUtils.copyProperties(sourceDetail, history);
			history.setUpdater(detail.getUpdater());
			history.setID(historyID);
			history.setBugID(detail.getID());
			history.setRemark(detail.getRemark());
			// 将旧记录插入到历史表中
			historyDao.insert(history);
			detailDao.update(detail);

			return true;
		} catch (NullPointerException e) {
			// TODO: handle exception
		}
		return false;
	}

	@Override
	public boolean delete(@RequestBody DetailEntity detail) {
		// TODO Auto-generated method stub
		try {
			HistoryEntity history=new HistoryEntity();
			if (detailDao.getInfoByID(detail.getID()) != null) {
				BeanUtils.copyProperties(detail, history);
				String historyID = UUID.randomUUID().toString().replace("-", "").toLowerCase();
				history.setID(historyID);
				history.setUpdater(detail.getUpdater());
				history.setBugID(detail.getID());
				history.setRemark(detail.getRemark());
				history.setUpdatetime(new Date());
				historyDao.insert(history);
				detailDao.delete(detail);
				return true;
			}
		} catch (NullPointerException e) {
			// TODO: handle exception
			throw new NullPointerException("当前Bug信息不存在，请重试！");
		}
		return false;
	}

	@Override
	public DetailEntity getInfoByID(String ID) {
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
