package com.iot.spring;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.List;

import org.apache.commons.dbcp2.BasicDataSource;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.BeanPropertyRowMapper;
import org.springframework.jdbc.core.JdbcTemplate;



public class EmpDAO {

	@Autowired
	JdbcTemplate jt;

	public void setJdbcTemplate(JdbcTemplate jt) {
		this.jt = jt;
	}

	public void con() {
		try {
			Connection con = jt.getDataSource().getConnection();
				System.out.println("접속성공"); 
				System.out.println(con);
				
				
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public List<Emp> selectEmpList(){
		String sql = "select * from emp";
		List<Emp> list= jt.query(sql, new BeanPropertyRowMapper(Emp.class));
		return list;
	}
}
