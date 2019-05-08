package cn.bugging.work.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;

import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.service.TokenService;
import cn.bugging.work.service.UserService;
import cn.bugging.work.utils.Response;

//@Controller
//实现该类下所有方法都会自动以Json格式返回数据(放在方法前同理)=@controller+@responsebody
@RestController
@RequestMapping("/users")
public class UserController {
	/**
	 * @Auther Huangjq
	 * @Date 2019年2月24日下午7:25:33
	 * @Description
	 *
	 */
	@Autowired
	private UserService userService;

	@Autowired
	TokenService tokenService;

	/**
	 * 登录
	 * 
	 * @param user
	 * @return
	 */
	@PostMapping("/login")
	@ResponseBody
	public Object login(@RequestBody UserEntity user) {
		JSONObject jsonObject = new JSONObject();
		UserEntity userForBase = userService.getUserByUsername(user.username);
		// 用户不存在
		if (userForBase == null) {
			jsonObject.put("code", Response.CODE_USER_NOTEXIST);
			jsonObject.put("message", Response.MSG_USER_NOTEXIST);
			return jsonObject;
		} else {
			// 密码不正确
			if (!userForBase.getPassword().equals(user.getPassword())) {
				jsonObject.put("code", Response.CODE_PASSWORD_WRONG);
				jsonObject.put("message", Response.MSG_PASSWORD_WRONG);
				return jsonObject;
			} else {
				String token = tokenService.createToken(userForBase);
				jsonObject.put("code", Response.CODE_ALL_CORRECT);
				jsonObject.put("token", token);
				jsonObject.put("roles", userForBase.username);
//                jsonObject.put("user", userForBase);
				return jsonObject;
			}
		}
	}

	/**
	 * 获取token进行验证
	 * 
	 * @param request header中的token
	 * @return
	 */
	@GetMapping("/info")
	@ResponseBody
	public Object getInfo(HttpServletRequest request) {
		String token = request.getHeader("Bugging");
		String userId = "";
		UserEntity user = new UserEntity();
		try {
			userId = JWT.decode(token).getIssuer();
			user = userService.findUserById(userId);
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return tokenService.verifyToken(token, user);
	}

	/**
	 * 注销
	 * 
	 * @return
	 */
	@PostMapping("/logout")
	public Object logout() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", Response.CODE_ALL_CORRECT);
		return jsonObject;
	}

}
