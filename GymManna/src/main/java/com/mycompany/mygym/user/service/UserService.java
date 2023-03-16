package com.mycompany.mygym.user.service;

import java.util.List;

import com.mycompany.mygym.user.vo.User;

public interface UserService {

	
	//로그인
	User loginUser(User user);
	
	//회원가입
	//User selectUser(User user);
	
	void createUser(User user);

	//회원전체 리스트 불러오기
	List<User> allUser(User user);
	
}
