package cn.bugging.work;

import java.util.Date;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.transaction.annotation.Transactional;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTCreationException;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;

import cn.bugging.work.dao.UserDao;
import cn.bugging.work.entity.UserEntity;

@RunWith(SpringJUnit4ClassRunner.class)
//@SpringApplicationConfiguration(classes = App.class)
@SpringBootTest
@Transactional
public class UserMapperTest {
	/**
	 * @Auther Huangjq
	 * @Date 2019年2月25日下午9:14:53
	 * @Description
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

//	@Test
//	public void testselectByName() throws Exception {
//		String username="admin";
//		UserEntity users = userdao.getUserByUsername(username);
////		System.out.println(users.toString());
//		System.out.println(users); 
//	}

//	
//	@Test
////	@Rollback(false)
//	public void testUpdate() throws Exception {
//		UserEntity user = userdao.selectByPrimaryKey("1");
//		user.setPassword("456");
//		UserMapper.updateByPrimaryKey(user);
//	}

	@Test
	public void getTokenTest() {
		try {
			String token = "";
			Algorithm algorithm = Algorithm.HMAC256("secret");
			token = JWT.create().withIssuer("auth0")
					.withIssuedAt(new Date()) // sign time  
					.withExpiresAt(new Date(System.currentTimeMillis() + (1 * 60 * 1000))) // expire time  
					.sign(algorithm);
			System.out.println(token);

			JWTVerifier verifier = JWT.require(algorithm).build(); // Reusable verifier instance
			DecodedJWT jwt = verifier.verify(token+"1");
			System.out.println(jwt.getClaims());
		} catch (JWTVerificationException exception) {
			// Invalid signature/claims
//			exception.printStackTrace();  
			System.out.println("verify false");
		}
	}
}
