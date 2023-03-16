package com.mycompany.mygym.user.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.mygym.user.dao.UserDao;
import com.mycompany.mygym.user.vo.User;

@Service
public class UserServiceImpl implements UserService {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;

	//회원가입
//	@Override
//	public User selectUser(User user) {
//		
//		int result = userDao.insertUser(user);
//		User resultOne = userDao.selectUser(user);
//		log.debug("회원가입서비스");
//		return resultOne;
//	}


	@Override
	public void createUser(User user) {
	
		//int result = userDao.createUser(user);
		log.debug("회원가입서비스");
        userDao.createUser(user);
	}
	
	
	//로그인
	@Override
    public User loginUser(User user) {
		
		
		log.debug("서비스");
		log.debug(user);
//		log.debug(user.getUserId());
//		log.debug(user.getUserPassword());

		//dao일시키기
		User result = userDao.findByUsername(user);
		log.debug(result);
		//if문 아이디 비번 틀렷을때
		if(result != null && result.getUserPassword().equals(user.getUserPassword())) {
			log.debug("로그인 성공");
			return result;
		} else {
			log.debug("아이디비번 틀림");
			return null;
			
		}

	}

	//전체회원리스트
	@Override
	public List<User> allUser(User user) {
		// TODO Auto-generated method stub
		return null;
	}


}
	
	

	    


	


