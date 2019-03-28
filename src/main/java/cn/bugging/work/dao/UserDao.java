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

// @Repository
public interface UserDao {
	@Select("SELECT * FROM login")
//	@Results({ @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
//			@Result(property = "nickName", column = "nick_name") })
	List<UserEntity> getAll();

	@Select("SELECT * FROM login WHERE ID = #{ID}")
//	@Results({ @Result(property = "userSex", column = "user_sex", javaType = UserSexEnum.class),
//			@Result(property = "nickName", column = "nick_name") })
	UserEntity getInfoByID(@Param("ID")String ID);

	@Insert("INSERT INTO login(userName,passWord,ID) VALUES(#{userName,jdbcType=VARCHAR}, #{passWord,jdbcType=VARCHAR}, #{ID,jdbcType=VARCHAR})")
	void insert(UserEntity user);

	@Update("UPDATE login SET userName=#{userName},nick_name=#{nickName} WHERE ID =#{ID}")
	void update(UserEntity user);

	@Delete("DELETE FROM login WHERE ID =#{ID}")
	void delete(String id);
}
