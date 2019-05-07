package cn.bugging.work.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;

import cn.bugging.work.dao.UserDao;
import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.service.UserService;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;

	@Override
	public List<UserEntity> getAll() {
		// TODO Auto-generated method stub
		return userDao.getAll();
	}
//	@Override
//    public Page<UserEntity> getAll(int pageNo, int pageSize) {
//        PageHelper.startPage(pageNo,pageSize);
//        return userMapper.getAll();
//    }

	@Override
	public UserEntity findUserById(String userID) {
		// TODO Auto-generated method stub
		return userDao.getUserByID(userID);
	}

	@Override
	public UserEntity getByUsername(String username) {
		// TODO Auto-generated method stub
		return userDao.getByUsername(username);
	}
	
	
}
