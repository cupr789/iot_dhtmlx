package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.Emp;

public interface EmpService {
	public List<Emp> getEmpList();
	public Emp getEmp(String EmpName);
	public int insertEmp(Map<String, Object> map);
	public int updateEmp();
	public int deleteEmp(Map map);
}
