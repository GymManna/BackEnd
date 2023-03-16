package com.mycompany.mygym.user.dao;

import org.apache.ibatis.session.SqlSession;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.mycompany.mygym.user.vo.User;

@Repository("userDao")
@Transactional
public class UserDaoImpl implements UserDao {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private SqlSession session;

	//회원가입
//	@Override
//	public int insertUser(User user) {
//		log.debug("회원가입dao");
//		
//		
//		return session.insert("UseUser.register", user);
//	}
//
//	@Override
//	public User selectUser(User user) {
//		log.debug("회원가입받아오는dao");
//		return session.selectOne("UseUser.regiseterChk", user);
//	}

	@Override
	public int createUser(User user) {
		
		log.debug("회원가입dao");
		return session.insert("UseUser.register", user);
	}
	
	//로그인
	@Override
	public User findByUsername(User user) {
		
//		User user = new User();
//		user.setUserId(userId);
//		log.debug(userId);
		log.debug("dao");

		//list = session.selectList("User.login", user); // db에서 select 실행해서 그 결과값 돌려받기
		User result = session.selectOne("UseUser.login", user);
		log.debug(result);
		return result;
//		log.debug((User)(session.selectOne("UseUser.login", user)));
		
//		return (User)(session.selectOne("UseUser.login", user));
	}





	
	

}
