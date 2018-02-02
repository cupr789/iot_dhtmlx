package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.EmpDAO;
import com.iot.spring.vo.Emp;

@Repository
public class EmpDAOImpl implements EmpDAO {
	@Autowired
	private SqlSessionFactory ssf;
	@Override
	public List<Emp> selectEmpList() {
		SqlSession ss = ssf.openSession();
		List<Emp> empList = ss.selectList("emp.selectEmp");
		ss.close();
		return empList;
	}

	@Override
	public Emp selectEmp(String empName) {
		SqlSession ss = ssf.openSession();
		Emp empOne= ss.selectOne("emp.selectEmpOne",empName);
		ss.close();
		return empOne;
	}

	@Override
	public int insertEmp(Map<String, Object> map) {
		SqlSession ss = ssf.openSession();
		System.out.println("들어옴?");
		int insert = ss.insert("emp.insertEmp",map);
		ss.close();
		return insert;
	}

	@Override
	public int updateEmp() {
		
		return 0;
	}

	@Override
	public int deleteEmp() {

		return 0;
	}

}
