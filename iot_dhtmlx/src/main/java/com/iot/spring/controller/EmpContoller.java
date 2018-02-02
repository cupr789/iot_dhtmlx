package com.iot.spring.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.iot.spring.service.EmpService;
import com.iot.spring.vo.Emp;

@Controller
@RequestMapping("/emp")
public class EmpContoller {
	
	public static final Logger logger = LoggerFactory.getLogger(EmpContoller.class);
	
	@Autowired
	private EmpService es;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getEmpList(Model m) {
		List<Emp> empList = es.getEmpList();
		m.addAttribute("empList",empList);
		return "emp/jstl_list";
	}
	
	/*@RequestMapping(value="/write",method=RequestMethod.GET)
	public String getWritePage(Model m) {
		List<Emp> empList = es.getEmpList();
		m.addAttribute("empList",empList);
		return "emp/jstl_list";
	}*/
	
/*	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insertEmp(@RequestParam Map<String, String> map,Model m) {
		//int result = es.insertEmp();
		logger.info("empMap=> {}",map);
		logger.info("empName=>{}",empName);
		logger.info("empSal=>{}",empSal);
		
		logger.info("insert Result=> {}", es.insertEmp(map));
		return "emp/write";
	}*/
	
	@RequestMapping(value="/insert",method=RequestMethod.GET)
	public String insertEmp(@Valid Emp empDTO,Errors es,Model m) {
		//int result = es.insertEmp();
		if(es.hasErrors()) {
			logger.info("error=> {}",es);
			m.addAttribute("errorMsg",es.getAllErrors());
			return "error/error";
		}
		logger.info("insert result=> {}",empDTO);
		return "emp/write";
	}
	
	
	
	
	@RequestMapping(value="/view",method=RequestMethod.GET)
	public String getEmp(@RequestParam("param")String empName,Model m) {
		//int result = es.insertEmp();
		logger.info("empName=> {}",empName);
		List<Emp> list = new ArrayList<Emp>();
		list.add(es.getEmp(empName));
		m.addAttribute("empOne",list);
		logger.info("empOne => {}", es.getEmp(empName));
		return "emp/one";
	}
	
}
