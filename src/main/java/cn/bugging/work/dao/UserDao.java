package cn.bugging.work.dao;

import java.util.List;

import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;

import cn.bugging.work.entity.UserEntity;

 @Repository
public interface UserDao{
	@Select("SELECT * FROM user")
//	@Results({ @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
//			@Result(property = "nickName", column = "nick_name") })
	List<UserEntity> getAll();

	@Select("SELECT * FROM user WHERE id = #{ID}")
	UserEntity getUserByID(String ID);
	
	@Select("SELECT * FROM user WHERE username = #{username}")
	UserEntity getByUsername(String username);

	@Insert("INSERT INTO user(id,username,password) VALUES(#{ID,jdbcType=VARCHAR},#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR} )")
	void insert(UserEntity user);

	@Update("UPDATE user SET username=#{userName},password=#{password} WHERE id =#{ID}")
	void update(UserEntity user);

	@Delete("DELETE FROM user WHERE id =#{ID}")
	void delete(String id);
}
