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
	private UserDao UserMapper;

	@Test
	public void testInsert() throws Exception {
		UserEntity userEntity=new UserEntity();
		userEntity.ID="2";
		userEntity.username="aaa";
		userEntity.password="aaa";
		UserMapper.insert(userEntity);
//		Assert.assertEquals(2, UserMapper.insert(userEntity).size());
	}

	@Test
	public void testQuery() throws Exception {
		List<UserEntity> users = UserMapper.selectAll();
//		System.out.println(users.toString());
		for(UserEntity info:users)
		{
			System.out.println(info.username);
		}
	}
//	
	@Test
//	@Rollback(false)
	public void testUpdate() throws Exception {
		UserEntity user = UserMapper.selectByPrimaryKey("1");
		user.setPassword("456");
		UserMapper.updateByPrimaryKey(user);
	}
}
