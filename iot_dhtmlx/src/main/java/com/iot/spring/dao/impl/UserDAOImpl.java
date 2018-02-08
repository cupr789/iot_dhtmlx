package com.iot.spring.dao.impl;

import java.util.List;
import java.util.Map;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.vo.UserVO;

@Repository
public class UserDAOImpl implements UserDAO {
	@Autowired
	private SqlSessionFactory ssf;

	@Override
	public List<UserVO> selectUserList() {
		SqlSession ss = ssf.openSession();
		List<UserVO> userList = ss.selectList("user.selectUser");
		ss.close();
		return userList;
	}

	@Override
	public int insertUser(UserVO uvo) {
		SqlSession ss = ssf.openSession();
		int result = ss.insert("user.insertUser",uvo);
		ss.close();
		return 0;
	}

	@Override
	public int deleteUser(int uiNo) {
		SqlSession ss = ssf.openSession();
		int result = ss.delete("user.deleteUser",uiNo);
		ss.close();
		return result;
	}

}
