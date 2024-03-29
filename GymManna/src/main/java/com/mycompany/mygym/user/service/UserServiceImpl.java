package com.mycompany.mygym.user.service;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.PlatformTransactionManager;
import org.springframework.transaction.TransactionStatus;
import org.springframework.transaction.support.DefaultTransactionDefinition;

import com.mycompany.mygym.user.dao.UserDao;
import com.mycompany.mygym.user.vo.User;

@Service
public class UserServiceImpl implements UserService {

	Logger log = LogManager.getLogger("case3");
	
//	@Autowired
//	private PlatformTransactionManager transactionManager;
	
	@Autowired
	@Qualifier("userDao")
	private UserDao userDao;


	//로그인
	@Override
    public User loginUser(User user) {
		log.debug("loginUser");

		//dao일시키기
		User result = userDao.findByUsername(user);
//		log.debug(result);
		//if문 아이디 비번 틀렷을때
		if(result != null && result.getUserPassword().equals(user.getUserPassword())) {
			log.debug("로그인 성공");
			return result;
		} else {
			log.debug("아이디비번 틀림");
			return null;
		}
	}

	//로그인 - 카카오
	@Override
    public User loginUserKakao(User user) {
		log.debug("loginUserKakao");

		//dao일시키기
		User result = userDao.findByUsernameKakao(user);
//		log.debug(result);
		//if문 아이디 비번 틀렷을때
		if(result != null && result.getUserPassword().equals("1")) {
			log.debug("로그인 성공");
			return result;
		} else {
			log.debug("아이디비번 틀림");
			return null;
		}
	}

	//로그인
	@Override
    public User selectUser(User user) {
		log.debug("selectUser");
		User result = userDao.findByUsername(user);
//		log.debug(result);
		//if문 아이디 비번 틀렷을때
		if(result != null) {
			log.debug("검색 성공");
			return result;
		} else {
			log.debug("검색 실패");
			return null;
		}
	}

	@Override
	public User createUser(User user) {
		log.debug("회원가입서비스");
//		TransactionStatus txStatus = 
//				transactionManager.getTransaction(new DefaultTransactionDefinition());
		
//		boolean result = false;
		
//		try {
//			userDao.createUser(user);
			
//			result = true;
//			transactionManager.commit(txStatus);	
//			
//		} catch (Exception e) {
//			result = false;
//			transactionManager.rollback(txStatus);
//		}
		
		int result = userDao.createUser(user);
		if (result != 0) {
			return userDao.selectUser(user);
		} else {
			return null;
		}
	}
	
	@Override
	public User createUserKakao(User user) {
		log.debug("회원가입서비스");
//		TransactionStatus txStatus = 
//				transactionManager.getTransaction(new DefaultTransactionDefinition());
		
//		boolean result = false;
		
//		try {
//			userDao.createUser(user);
			
//			result = true;
//			transactionManager.commit(txStatus);	
//			
//		} catch (Exception e) {
//			result = false;
//			transactionManager.rollback(txStatus);
//		}
		
		int result = userDao.createUserKakao(user);
		if (result != 0) {
			return userDao.selectUser(user);
		} else {
			return null;
		}
	}
	
	//전체회원리스트
	@Override
	public List<User> allUser() {
		log.debug("admin서비스");
		return userDao.getAllUser();
	}

	//회원정보 수정
	@Override
	public int editUser(User user) {
		log.debug("회원정보 수정 서비스");
//		User result = userDao.selectUser(user);
		int result = userDao.editUser(user);
		return result;
	}

	//회원탈퇴
	@Override
	public int deleteUser(User user) {
		
		return userDao.deleteUser(user);
	}

}
