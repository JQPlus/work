package cn.bugging.work.entity;

public class UserEntity {
	/**
	 * @Auther Huangjq
	 * @Date 2019年2月25日下午7:46:32
	 * @Description
	 *
	 */
	// 用户名
	public String userName;
	// 密码
	public String passWord;
	// 主键ID
	public String ID;

	public String getUserName() {
		return userName;
	}

	public void setUserName(String userName) {
		this.userName = userName;
	}

	public String getPassWord() {
		return passWord;
	}

	public void setPassWord(String passWord) {
		this.passWord = passWord;
	}

	public String getID() {
		return ID;
	}

	public void setID(String iD) {
		ID = iD;
	}

}
