package cn.bugging.work.dao;

import java.util.List;

import org.apache.catalina.User;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Result;
import org.apache.ibatis.annotations.Results;
import org.apache.ibatis.annotations.Select;
import org.apache.ibatis.annotations.Update;
import org.springframework.stereotype.Repository;

import com.github.pagehelper.Page;

import cn.bugging.work.base.MyBaseMapper;
import cn.bugging.work.entity.UserEntity;

// @Repository
public interface UserDao extends MyBaseMapper<UserEntity>{
//	@Select("SELECT * FROM user")
////	@Results({ @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
////			@Result(property = "nickName", column = "nick_name") })
//	List<UserEntity> getAll();
//
//	@Select("SELECT * FROM user WHERE id = #{ID}")
////	@Results({ @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
////			@Result(property = "nickName", column = "nick_name") })
//	UserEntity getInfoByID(@Param("ID")String ID);
//
//	@Insert("INSERT INTO user(username,password,id) VALUES(#{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, #{id,jdbcType=VARCHAR})")
//	void insert(UserEntity user);
//
//	@Update("UPDATE user SET username=#{userName},password=#{password} WHERE id =#{id}")
//	void update(UserEntity user);
//
//	@Delete("DELETE FROM user WHERE id =#{id}")
//	void delete(String id);
}
