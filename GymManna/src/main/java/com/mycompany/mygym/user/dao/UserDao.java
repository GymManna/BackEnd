package com.mycompany.mygym.user.dao;

import com.mycompany.mygym.user.vo.User;


public interface UserDao {


//	User selUser(User user);
	
	//회원가입
//	int insertUser(User user);
//	User selectUser(User user);
	int createUser(User user);
	
	//로그인
	User findByUsername(User user);

	//전체회원리스트 불러오기
	
	
}
