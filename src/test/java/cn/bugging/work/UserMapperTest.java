package cn.bugging.work;

import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import cn.bugging.work.dao.UserDao;
import cn.bugging.work.entity.UserEntity;


@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = App.class)
@SpringBootTest
@Transactional
public class UserMapperTest {
	/**
	*@Auther Huangjq
	*@Date 2019年2月25日下午9:14:53
	*@Description
	*
	*/
	@Autowired
	private UserDao userdao;

//	@Test
//	public void testInsert() throws Exception {
//		UserEntity userEntity=new UserEntity();
//		userEntity.ID="2";
//		userEntity.username="aaa";
//		userEntity.password="aaa";
//		UserMapper.insert(userEntity);
////		Assert.assertEquals(2, userdao.insert(userEntity).size());
//	}

//	@Test
//	public void testQuery() throws Exception {
//		List<UserEntity> users = userdao.getAll();
////		System.out.println(users.toString());
//		for(UserEntity info:users)
//		{
//			System.out.println(info.username);
//		}
//	}
	
	@Test
	public void testselectByName() throws Exception {
		String username="admin";
		UserEntity users = userdao.getByUsername(username);
//		System.out.println(users.toString());
		System.out.println(users); 
	}
	
//	
//	@Test
////	@Rollback(false)
//	public void testUpdate() throws Exception {
//		UserEntity user = userdao.selectByPrimaryKey("1");
//		user.setPassword("456");
//		UserMapper.updateByPrimaryKey(user);
//	}
}
