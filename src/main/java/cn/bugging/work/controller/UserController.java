package cn.bugging.work.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageInfo;

import cn.bugging.work.entity.UserEntity;
import cn.bugging.work.service.UserService;
import cn.bugging.work.service.impl.UserServiceImpl;

@Controller
//实现该类下所有方法都会自动以Json格式返回数据(放在方法前同理)=@controller+@responsebody
// @RestController
public class UserController {
	/**
	 * @Auther Huangjq
	 * @Date 2019年2月24日下午7:25:33
	 * @Description
	 *
	 */
	@Autowired
	private UserService userService;
	
//	@RequestMapping(value="/user", method=RequestMethod.GET)
//	@ResponseBody
//	public ModelMap list (int pageNo, int pageSize){
//        ModelMap modelMap =new ModelMap();
//        try{
//            Page<UserEntity> userList=userService.getAll(pageNo,pageSize);
//             //获取分页查询后的数据
//             PageInfo<UserEntity> pageInfo=new PageInfo<UserEntity>(userList);
//            modelMap.put("userList", userList);
//            // 总记录数
//            modelMap.put("total", pageInfo.getTotal());
//            // 当前页
//            modelMap.put("courrentPage", pageInfo.getPageNum());
//        }catch(Exception e){
//            e.printStackTrace();
//        }
//        return  modelMap;
//    }
//	@ResponseBody
//	public List<UserEntity> list()
//	{
//		return userService.getAll();
//	}
//	 public ModelAndView login(HttpServletRequest request,HttpServletResponse response){
//	 	ModelAndView mav = new ModelAndView();
//	 	mav.setViewName("user");
//	 	return mav;
//	 }
	@GetMapping(value = "/login")
    public String index() {
        return "user";
    }
	
}
