package cn.bugging.work.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import cn.bugging.work.entity.ProjectEntity;
import cn.bugging.work.service.ProjectService;

/**
 * @author HuangJq
 * @Description
 * 
 */
@RestController
@RequestMapping("/project")
public class ProjectController {
	
	@Autowired
	private ProjectService projectService;
	
	@GetMapping("/info")
	public List<ProjectEntity> getProjectInfo()
	{
		return projectService.getProjectInfo();
	}
}
