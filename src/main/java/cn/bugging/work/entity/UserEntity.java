package cn.bugging.work.entity;

import com.auth0.jwt.JWT;
import com.auth0.jwt.algorithms.Algorithm;

public class UserEntity {
	/**
	 * @Auther Huangjq
	 * @Date 2019年2月25日下午7:46:32
	 * @Description:user用户实体类
	 *
	 */
	// 主键ID
	private String ID;
	// 用户名
	private String username;
	// 密码
	private String password;

	public String getUsername() {
		return username;
	}

	public void setUsername(String username) {
		this.username = username;
	}

	public String getPassword() {
		return password;
	}

	public void setPassword(String password) {
		this.password = password;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}
}
