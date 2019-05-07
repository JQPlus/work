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
	public String ID;
	// 用户名
	public String username;
	// 密码
	public String password;
	
	/**
	 * token的生成方法,
	 * Algorithm.HMAC256():使用HS256生成token,密钥则是用户的密码，唯一密钥的话可以保存在服务端。
	 * withAudience()存入需要保存在token的信息，这里我把用户ID存入token中
	 * @param user
	 * @return
	 */
	public String getToken(UserEntity user) {
        String token="";
        token= JWT.create().withAudience(user.getID())
                .sign(Algorithm.HMAC256(user.getPassword()));
        return token;
    }

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
