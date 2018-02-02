package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.Emp;

public interface EmpDAO {
	public List<Emp> selectEmpList();
	public Emp selectEmp(String empName);
	public int insertEmp(Map<String, String> map);
	public int updateEmp();
	public int deleteEmp();
}
