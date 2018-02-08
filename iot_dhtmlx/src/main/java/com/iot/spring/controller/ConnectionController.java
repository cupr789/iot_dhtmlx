package com.iot.spring.controller;

import java.util.List;
import java.util.Map;

import org.codehaus.jackson.map.ObjectMapper;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.iot.spring.service.ConnectionService;
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

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
	
	@RequestMapping(value="/db_list", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> getDatabaseList(Map<String,Object> map) {
		List<Map<String,Object>> dbList = cs.getDatabaseList();
		logger.info("asdasdasd =>{}",dbList);
		map.put("dbList", dbList);
		return map;
	}
	
	@RequestMapping(value="/tables/{dbName}", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> getTablesList(@PathVariable("dbName")String dbName,Map<String,Object> map) {
		List<TableVO> tableList = cs.getTableList(dbName);
		map.put("tableList", tableList);
		return map;
	}
	
	@RequestMapping(value="/columns/{tbName}", method=RequestMethod.GET)
	public @ResponseBody Map<String,Object> getColumnList(@PathVariable("tbName")String tbName,Map<String,Object> map) {
		List<ColumnVO> columnList = cs.getColumnList(tbName);
		logger.info("asdasdasd =>{}",tbName);
		map.put("columnList", columnList);
		return map;
	}
	
}
