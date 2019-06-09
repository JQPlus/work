package cn.bugging.work.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import cn.bugging.work.dao.ProjectDao;
import cn.bugging.work.entity.ProjectEntity;
import cn.bugging.work.service.ProjectService;

/**
 * @author HuangJq
 * @Description
 * 
 */
@Service
public class ProjectServiceImpl implements ProjectService{

	@Autowired
	private ProjectDao projectDao;
	@Override
	public List<ProjectEntity> getProjectInfo() {
		// TODO Auto-generated method stub
		return projectDao.getProjectInfo();
	}
	
	@Override
	public String getProjectIDByName(String projectName) {
		// TODO Auto-generated method stub
		return projectDao.getProjectIDByName(projectName);
	}
	

}
