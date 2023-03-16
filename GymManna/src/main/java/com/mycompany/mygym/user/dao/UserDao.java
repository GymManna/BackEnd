package com.mycompany.mygym.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.mycompany.mygym.user.vo.User;

@Repository
public class UserDao implements UserDaoImpl {

	@Autowired
	private SqlSession session;
	
	@Override
	public User selectUser(User user) {
	
		return session.selectOne("myUser.login",user);
	
	}

	
}
