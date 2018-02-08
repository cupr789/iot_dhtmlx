package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserVO;

public interface UserDAO {
	public List<UserVO> selectUserList();
	
	public int insertUser(UserVO uvo);
	public int deleteUser(int uiNo);
}
