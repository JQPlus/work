package cn.bugging.work.utils.utils;

import com.alibaba.fastjson.JSONObject;

public class JSONResult {
	/**
	 * @author HuangJq @Date 2019年5月6日下午8:31:03
	 * @Description
	 * 
	 */
	 public static String fillResultString(Integer code, String message, Object data){
	        JSONObject jsonObject = new JSONObject(){{
	            put("code", code);
	            put("message", message);
	            put("data", data);
	        }};
	        return jsonObject.toString();
	    }
}
