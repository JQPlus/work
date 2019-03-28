package cn.bugging.work.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	/**
	 * @author HuangJq @Date 2019年3月20日下午8:06:07
	 * @Description
	 * 
	 */
	@GetMapping(value = "/home")
    public String home() {
        return "home";
    }
}
