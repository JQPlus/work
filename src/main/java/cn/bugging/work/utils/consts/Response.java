package cn.bugging.work.utils.consts;

import java.util.Map;

import org.omg.CORBA.PUBLIC_MEMBER;

public class Response {
	/**
	 * @author HuangJq @Date 2019年5月8日下午2:52:01
	 * @Description 请求回应
	 * 
	 */

	/**
	 * 过期token
	 */
	public static final int CODE_TOKEN_OVERVUE = 100;
	/**
	 * 非法token
	 */
	public static final int CODE_TOKEN_INVALID = 102;
	/**
	 * 用户已登录
	 */
	public static final int CODE_INUSED_CODE = 104;
	/**
	 * 正确
	 */
	public static final int CODE_ALL_CORRECT = 200;
	/**
	 * 用户不存在
	 */
	public static final int CODE_USER_NOTEXIST = 202;
	/**
	 * 密码错误
	 */
	public static final int CODE_PASSWORD_WRONG = 204;

	public static final String MSG_TOKEN_OVERVUE = "Token已过期，请重新登录";
	public static final String MSG_TOKEN_INVALID = "非法Token";
	public static final String MSG_INUSED_CODE = "已在其他客户端登录";
	public static final String MSG_ALL_CORRECT = "验证成功";
	public static final String MSG_USER_NOTEXIST = "登录失败,用户不存在";
	public static final String MSG_PASSWORD_WRONG = "登录失败,密码错误";
}
