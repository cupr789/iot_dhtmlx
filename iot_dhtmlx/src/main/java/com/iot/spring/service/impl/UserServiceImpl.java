package com.iot.spring.service.impl;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.iot.spring.dao.UserDAO;
import com.iot.spring.service.UserService;
import com.iot.spring.vo.UserVO;

@Service
public class UserServiceImpl implements UserService{
	@Autowired
	UserDAO userDao;
	@Override
	public List<UserVO> getUserList(UserVO uvo) {
		return userDao.selectUserList(uvo);
	}
	
	private boolean isDuplUserInfo(UserVO uvo) {
		if(userDao.checkUserInfo(uvo)==1) {
			return true;
		}
		return false;
	}
	
	@Override
	public void insertUser(Map<String, Object> rMap,UserVO uvo) {
		rMap.put("msg", "회원가입이 실패하였습니다.");
		rMap.put("signupOk", false);
		if(isDuplUserInfo(uvo)) {
			rMap.put("msg", uvo.getUiId()+"는 이미 존재하는 아이디 입니다.");
			return;
		}
		int result = userDao.insertUser(uvo);
		if(result==1) {
			rMap.put("msg", "회원가입이 성공하였습니다.");
			rMap.put("signupOk", true);
		}
	}
	@Override
	public int deleteUser(int uiNo) {
		
		return userDao.deleteUser(uiNo);
	}
	@Override
	public UserVO getUserInfo(UserVO uvo) {
	
		return userDao.selectUserInfo(uvo);
	}

	@Override
	public int checkUser(UserVO uvo) {
		
		return userDao.checkUserInfo(uvo);
	}

}
