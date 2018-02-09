package com.iot.spring.service;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserVO;

public interface UserService {
	List<UserVO> getUserList(UserVO uvo);
	void insertUser(Map<String, Object> rMap,UserVO uvo);
	int deleteUser(int uiNo);
	UserVO getUserInfo(UserVO uvo);
	int checkUser(UserVO uvo);
	
}
