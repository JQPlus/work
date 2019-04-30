package cn.bugging.work.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
//实体类注解
@Entity
//表名和实体类名相同则可省略
@Table(name = "user")
public class UserEntity {
	/**
	 * @Auther Huangjq
	 * @Date 2019年2月25日下午7:46:32
	 * @Description:user用户实体类
	 *
	 */
	//主键注释
	@Id 
	//如果表名中的列与实体类中的字段不同名，则如此来修改
	//其中 name 属性的值为数据库中的列名
	@Column(name="id")
	// 主键ID
	public String ID;
	// 用户名
	public String username;
	// 密码
	public String password;
	

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
