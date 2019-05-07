package cn.bugging.work.controller;

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
import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.service.TokenService;
import cn.bugging.work.service.UserService;
import cn.bugging.work.service.impl.UserServiceImpl;
import cn.bugging.work.utils.anno.PassToken;
import cn.bugging.work.utils.anno.UserLoginToken;

//@Controller
//实现该类下所有方法都会自动以Json格式返回数据(放在方法前同理)=@controller+@responsebody
@RestController

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

    //登录
    @PostMapping("/users/login")
    public Object login(@RequestBody UserEntity user){
    	JSONObject jsonObject=new JSONObject();
        UserEntity userForBase=userService.getByUsername(user.username);
        if(userForBase==null){
        	jsonObject.put("code",1000);
            jsonObject.put("message","登录失败,用户不存在");
            return jsonObject;
        }else {
            if (!userForBase.getPassword().equals(user.getPassword())){
            	jsonObject.put("code",1001);
                jsonObject.put("message","登录失败,密码错误");
                return jsonObject;
            }else {
                String token = tokenService.getToken(userForBase);
                jsonObject.put("code",20000);
                jsonObject.put("token", token);
                jsonObject.put("roles", userForBase.username);
//                jsonObject.put("user", userForBase);
                return jsonObject;
            }
        }
    }
    
    @GetMapping("/users/info")
    public Object getInfo(HttpServletRequest request){
    	String token = request.getHeader("token");
    	String userId = JWT.decode(token).getAudience().get(0);
    	UserEntity user = userService.findUserById(userId);
		JSONObject jsonObject=new JSONObject();
    	if(token!=null||token!="")
    	{
            jsonObject.put("roles",user.username);
    	}
        return jsonObject;
    }
    
    @PostMapping("/users/logout")
    public Object logout(){
		JSONObject jsonObject=new JSONObject();
            jsonObject.put("code",20000);
        return jsonObject;
    }
    
	
}
