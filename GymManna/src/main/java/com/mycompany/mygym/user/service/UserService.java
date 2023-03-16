package com.mycompany.mygym.user.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.mygym.user.dao.UserDao;
import com.mycompany.mygym.user.vo.User;

@Service
public class UserService implements UserServiceImpl {

	@Autowired
	private UserDao dao;
	
	@Override
	public User selectUser(User user) {
		
		User res = dao.selectUser(user);
		
		return res;
	}


}
