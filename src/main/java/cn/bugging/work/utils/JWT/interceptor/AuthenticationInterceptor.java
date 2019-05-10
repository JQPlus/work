package cn.bugging.work.utils.JWT.interceptor;

import java.lang.reflect.Method;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.method.HandlerMethod;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.ModelAndView;

import com.auth0.jwt.JWT;
import com.auth0.jwt.JWTVerifier;
import com.auth0.jwt.algorithms.Algorithm;
import com.auth0.jwt.exceptions.JWTDecodeException;
import com.auth0.jwt.exceptions.JWTVerificationException;

import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.service.UserService;
import cn.bugging.work.utils.JWT.anno.PassToken;
import cn.bugging.work.utils.JWT.anno.UserLoginToken;

public class AuthenticationInterceptor implements HandlerInterceptor {

	/**
	 * @author HuangJq @Date 2019年5月6日下午5:15:19
	 * @Description
	 * 
	 */
	@Autowired
	UserService userService;

	@Override
	/**
	 * 预处理回调方法,实现处理器的预处理，
	 * 第三个参数为响应的处理器,自定义Controller,
	 * 返回值为true表示继续流程（如调用下一个拦截器或处理器）或者接着执行postHandle()和afterCompletion()；
	 * false表示流程中断，不会继续调用其他的拦截器或处理器，中断执行。
	 */
	public boolean preHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object object) throws Exception {
		String token = httpServletRequest.getHeader("token");// 从 http 请求头中取出 token
		// 如果不是映射到方法直接通过
		if (!(object instanceof HandlerMethod)) {
			return true;
		}
		HandlerMethod handlerMethod = (HandlerMethod) object;
		Method method = handlerMethod.getMethod();
		// 检查是否有passtoken注释，有则跳过认证
		if (method.isAnnotationPresent(PassToken.class)) {
			PassToken passToken = method.getAnnotation(PassToken.class);
			if (passToken.required()) {
				return true;
			}
		}
		// 检查有没有需要用户权限的注解
		if (method.isAnnotationPresent(UserLoginToken.class)) {
			UserLoginToken userLoginToken = method.getAnnotation(UserLoginToken.class);
			if (userLoginToken.required()) {
				// 执行认证
				if (token == null) {
					throw new RuntimeException("无token，请重新登录");
				}
				// 获取 token 中的 user id
				String userId;
				try {
					userId = JWT.decode(token).getAudience().get(0);
				} catch (JWTDecodeException j) {
					throw new RuntimeException("401");
				}
				UserEntity user = userService.findUserById(userId);
				if (user == null) {
					throw new RuntimeException("用户不存在，请重新登录");
				}
				// 验证 token
				JWTVerifier jwtVerifier = JWT.require(Algorithm.HMAC256(user.getPassword())).build();
				try {
					jwtVerifier.verify(token);
				} catch (JWTVerificationException e) {
					throw new RuntimeException("401");
				}
				return true;
			}
		}
		return true;
	}

	@Override
	public void postHandle(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o,
			ModelAndView modelAndView) throws Exception {

	}

	@Override
	public void afterCompletion(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse,
			Object o, Exception e) throws Exception {
	}
}