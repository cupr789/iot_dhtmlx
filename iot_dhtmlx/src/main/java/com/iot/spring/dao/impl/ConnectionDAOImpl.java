package com.iot.spring.dao.impl;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.ConnectionDAO;
import com.iot.spring.vo.ConnectionInfoVO;

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

}
