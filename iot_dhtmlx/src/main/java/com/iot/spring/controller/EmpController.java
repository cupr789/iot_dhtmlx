package com.iot.spring.controller;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.iot.spring.common.aspect.LogPrintAspect;
import com.iot.spring.service.EmpService;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.CheckNum;
import com.iot.spring.vo.Emp;
import com.iot.spring.vo.User;

@Controller
@RequestMapping("/emp")
public class EmpController {
	
	public static final Logger logger = LoggerFactory.getLogger(EmpController.class);
	
	@Autowired
	private EmpService es;
	@Autowired
	private UserService us;
	
	@RequestMapping(value="/list",method=RequestMethod.GET)
	public String getEmpList(Model m) {
		List<Emp> empList = es.getEmpList();
		m.addAttribute("empList",empList);
		return "emp/jstl_list";
	}
	
	
	@RequestMapping(value="/lista",method=RequestMethod.GET)
	public @ResponseBody Map getEmpListAjax(Model m) {
		List<Emp> empList = es.getEmpList();
		List<User> userList = us.getUserList();
		logger.info("lista => {}",empList);
		logger.info("lista => {}",userList);
		Map<String, List> map = new HashMap<String, List>();
		map.put("empList", empList);
		map.put("userList", userList);
		return map;
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
	public ModelAndView insertEmp(@Valid Emp empDTO,Errors es,ModelAndView m) throws Exception {
		//int result = es.insertEmp();
		if(es.hasErrors()) {
			logger.info("error=> {}",es);
			/*m.addAttribute("errorMsg",es.getAllErrors());
			return "error/error";*/
			throw new Exception(es.getAllErrors().get(0).getDefaultMessage());
			
		}
		logger.info("insert result=> {}",empDTO);
		logger.info("insert name=> {}",empDTO.getEmpName());
		logger.info("insert sal=> {}",empDTO.getEmpSal());
		Map<String, Object> map = new HashMap<String, Object>();
		map.put("empName", empDTO.getEmpName());
		map.put("empSal", empDTO.getEmpSal());
		
		this.es.insertEmp(map);
		m.setViewName("emp/write");
		return m;
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
	
	@RequestMapping(value="/delete",method=RequestMethod.GET)
	public String deleteEmp(@RequestParam(value="deleteEmpNo") List<Integer> list,Model m) {
		//int result = es.insertEmp();
			logger.info("deleteList=> {}",list);
			/*logger.info("delete exe=> {}",es.deleteEmp(list));*/
			return getEmpList(m);
	}
	@RequestMapping(value="/update",method=RequestMethod.GET)
	public String updateEmp(@RequestParam("updateName") String updateName,
			@RequestParam("updateSal") String updateSal,
			@RequestParam("updateId") String updateId,Model m) {
			logger.info("updateName=> {}",updateName);
			logger.info("updateSal=> {}",updateSal);
			logger.info("updateId=> {}",updateId);
			return getEmpList(m);
	}
	
}
