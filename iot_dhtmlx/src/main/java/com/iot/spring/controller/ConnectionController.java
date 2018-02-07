package com.iot.spring.controller;

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

import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ConnectionInfoVO;

@Controller
@RequestMapping("/connection")
public class ConnectionController {
	public static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	ConnectionService cs;
	
	//@Autowired
	ObjectMapper om=new ObjectMapper();
	
	@RequestMapping(value="/insert", method=RequestMethod.POST)
	public @ResponseBody Map insertInfo(@RequestParam Map map) {
			ConnectionInfoVO ci = om.convertValue(map, ConnectionInfoVO.class);
			logger.info("ConnectionInfoVO=>{}",ci);
			logger.info("requestMap =>{}",map);
			cs.insertConnectionInfo(map,ci);
			return map;
			
	}
	
	@RequestMapping(value="/select", method=RequestMethod.POST)
	public ConnectionInfoVO selectInfo(@RequestParam Map<String,Object> map, Model m) {
			
		return null;
	}
	
}
