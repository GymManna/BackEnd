package com.mycompany.mygym.user.service;

import java.util.List;

import com.mycompany.mygym.user.vo.User;

public interface UserService {

	
	//로그인
	User loginUser(User user);
	User loginUserKakao(User user);
	User selectUser(User user);
	
	//회원가입
	User createUser(User user);
	User createUserKakao(User user);

	//회원전체 리스트 불러오기
	List<User> allUser();
	
	//회원정보 수정
	//User selectUser(); //수정하기위해서 불러오는것
	int editUser(User user); //정보수정
	
	//회원탈퇴
	int deleteUser(User user);

}
