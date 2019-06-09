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
	
	/**
	 * 获取user所有信息
	 * @return
	 */
	public List<UserEntity> getAll();
	/**
	 * 根据id查询user
	 * @param userID
	 * @return
	 */
	public UserEntity findUserById(String userID);
	/**
	 * 根据username查找user
	 * @param username
	 * @return
	 */
	public UserEntity getUserByUsername(String username);
	
	public boolean update(UserEntity user);
}
