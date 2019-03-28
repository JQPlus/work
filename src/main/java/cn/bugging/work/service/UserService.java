package cn.bugging.work.service;

import java.util.List;

import com.github.pagehelper.Page;

import cn.bugging.work.entity.UserEntity;


public interface UserService {
	/**
	 * 
	 * @param pageNo 页号
	 * @param pageSize 每页显示的数量
	 * @return
	 */
//	public Page<UserEntity> getAll(int pageNo, int pageSize);
	
	public List<UserEntity> getAll();
}
