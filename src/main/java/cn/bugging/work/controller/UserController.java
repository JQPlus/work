package cn.bugging.work.controller;

import java.io.UnsupportedEncodingException;
import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.alibaba.fastjson.JSONObject;
import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTVerificationException;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.service.TokenService;
import cn.bugging.work.service.UserService;
import cn.bugging.work.service.impl.UserServiceImpl;
import cn.bugging.work.utils.Response;
import cn.bugging.work.utils.anno.PassToken;
import cn.bugging.work.utils.anno.UserLoginToken;

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

	// 登录
	@PostMapping("/login")
	@ResponseBody
	public Object login(@RequestBody UserEntity user) {
		JSONObject jsonObject = new JSONObject();
		UserEntity userForBase = userService.getByUsername(user.username);
		if (userForBase == null) {
			jsonObject.put("code", Response.CODE_USER_NOTEXIST);
			jsonObject.put("message", Response.MSG_USER_NOTEXIST);
			return jsonObject;
		} else {
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

	@GetMapping("/info")
	@ResponseBody
	public Object getInfo(String token) {
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

	@PostMapping("/logout")
	public Object logout() {
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("code", Response.CODE_ALL_CORRECT);
		return jsonObject;
	}

}
