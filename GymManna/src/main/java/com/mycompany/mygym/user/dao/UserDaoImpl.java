package com.mycompany.mygym.user.dao;

import java.util.List;

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
	@Override
	public int createUser(User user) {
		log.debug("회원가입dao");
		return session.insert("UseUser.register", user);
	}

	@Override
	public int createUserKakao(User user) {
		log.debug("회원가입Kakao dao");
		return session.insert("UseUser.registerKakao", user);
	}

	//정보 수정을 위해 불러오는 정보
	@Override
	public User selectUser(User user) {
		
		return session.selectOne("UseUser.selectUser", user);
	}

	//로그인
	@Override
	public User findByUsername(User user) {
		log.debug("findByUsername");

		User result = session.selectOne("UseUser.selectUser", user);
		log.debug(result);
		return result;
//		log.debug((User)(session.selectOne("UseUser.login", user)));
		
//		return (User)(session.selectOne("UseUser.login", user));
	}
	
	//로그인 - 카카오
	@Override
	public User findByUsernameKakao(User user) {
		log.debug("dao");

		User result = session.selectOne("UseUser.selectUser", user);
		log.debug(result);
		return result;
	}
	
	//전체 회원 리스트
	@Override
	public List<User> getAllUser() {
		log.debug("admin dao");
		return session.selectList("UseUser.allUser");
	}

	//회원정보 수정
	@Override
	public int editUser(User user) {
		log.debug("회원정보수정 dao");
		int result = session.update("UseUser.editUser", user);
		return result;
	}
	
	//회원탈퇴
	@Override
	public int deleteUser(User user) {
		// TODO Auto-generated method stub
		log.debug("deleteUser()");
		int result = session.delete("UseUser.withdraw", user);
		return result;
	}
	




	
	

}
