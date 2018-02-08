package com.iot.spring.controller;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.UserService;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.Emp;
import com.iot.spring.vo.UserVO;

@Controller
@RequestMapping("/user")
public class UserController {
	public static final Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@Autowired
	private UserService us;
	
	ObjectMapper om=new ObjectMapper();

	@RequestMapping(value="/insert",method=RequestMethod.POST)
	public @ResponseBody Map insertUser(@RequestParam Map<String, Object> map) {
		UserVO uvo = om.convertValue(map, UserVO.class);
		logger.info("UserVO =>{}",uvo.getUiName());
		int result = us.insertUser(uvo);
		if(result==1) {
			map.put("msg", "입력성공");
		}
		//us.insertUser(uvo);
		return map;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody Map LoginUser(@RequestParam Map<String, Object> map) {
		logger.info("login1 =>{}",map);
		//us.insertUser(uvo);
		map.put("msg", "입력성공");
		logger.info("login1 =>{}",map);
		return map;
	}
	
}
