package com.iot.spring.dao;

import java.util.List;
import java.util.Map;

import com.iot.spring.vo.UserVO;

public interface UserDAO {
	List<UserVO> selectUserList(UserVO uvo);
	int insertUser(UserVO uvo);
	int deleteUser(int uiNo);
	UserVO selectUserInfo(UserVO uvo);
	int checkUserInfo(UserVO uvo);
}
