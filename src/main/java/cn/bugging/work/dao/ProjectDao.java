package cn.bugging.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;

import cn.bugging.work.entity.ProjectEntity;

public interface ProjectDao {

	@Select("SELECT * FROM project")
	@Results(@Result(property="projectName",column="project_name"))
	List<ProjectEntity> getProjectInfo(); 
}
