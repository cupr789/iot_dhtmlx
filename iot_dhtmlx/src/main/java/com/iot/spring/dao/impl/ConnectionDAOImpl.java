package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ColumnVO;
import com.iot.spring.vo.ConnectionInfoVO;
import com.iot.spring.vo.TableVO;

@Repository
public class ConnectionDAOImpl implements ConnectionDAO {

	@Autowired
	SqlSessionFactory ssf;
	
	@Override
	public ConnectionInfoVO selectConnectionInfo(ConnectionInfoVO ci) {
		SqlSession ss = ssf.openSession();
		ConnectionInfoVO conOne = ss.selectOne("con.selectConnectionInfo");
		ss.close();
		return null;
	}

	@Override
	public List<ConnectionInfoVO> selectConnectionInfoList(ConnectionInfoVO ci) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insertConnectionInfo(ConnectionInfoVO ci) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("con.insertConnectionInfo",ci);
		ss.close();
		return result;
	}

	@Override
	public List<Map<String, Object>> selectDatabase() {
		SqlSession ss = ssf.openSession();
		List<Map<String,Object>> selectlist= ss.selectList("con.selectDatabase");
		ss.close();
		return selectlist;
	}

	@Override
	public List<TableVO> selectTableList(String dbName) {
		SqlSession ss = ssf.openSession();
		List<TableVO> selectlist= ss.selectList("con.selectTable",dbName);
		ss.close();
		return selectlist;
	}

	@Override
	public List<ColumnVO> selectColumnList(String tbName) {
		SqlSession ss = ssf.openSession();
		List<ColumnVO> selectlist= ss.selectList("con.selectColumn",tbName);
		ss.close();
		return selectlist;
	}

}
