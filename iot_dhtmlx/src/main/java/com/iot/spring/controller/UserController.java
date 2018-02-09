package com.iot.spring.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

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

	@RequestMapping(value="/signup",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> signUp(@Valid UserVO ui,HttpSession hs) {
		
		Map<String, Object> map = new HashMap<String, Object>();
		us.insertUser(map, ui);
		return map;
	}
	
	@RequestMapping(value="/login",method=RequestMethod.POST)
	public @ResponseBody Map<String,Object> LoginUser(@Valid UserVO ui,HttpSession hs) {
		/*logger.info("login1 =>{}",map);
		//us.insertUser(uvo);
		map.put("msg", "입력성공");
		logger.info("login1 =>{}",map);*/
		logger.info("Before Login HttpSession =>{}",hs.getAttribute("user"));

		Map<String, Object> map = new HashMap<String, Object>();
		ui = us.getUserInfo(ui);
		map.put("loginOk", false);
		map.put("msg", "로그인 실패");
		if(ui!=null) {
			hs.setAttribute("user", ui);
			hs.setAttribute("isLogin", true);
			map.put("msg", "로그인 성공");
			map.put("loginOk", true);
		}
		
		
		logger.info("after Login HttpSession =>{}",map);
		logger.info("after Login HttpSession =>{}",hs.getAttribute("user"));
		
		return map;
	}
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public @ResponseBody List<UserVO> getUList(UserVO uvo) {
		return us.getUserList(uvo);
	}
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public @ResponseBody Map deleteUser(int uiNo,Model m) {
		 int result = us.deleteUser(uiNo);
		 logger.info("result =>{}",result);
		
		 Map<String,Object> map = new HashMap<String, Object>();
		 if(result==1) {
			 map.put("msg", "삭제완료");
		 }
		/* map.put("userList",);*/
		//m.addAttribute("userList",userList);
		return map;
	}
	
	
}
