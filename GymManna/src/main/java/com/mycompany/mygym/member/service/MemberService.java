package com.mycompany.mygym.member.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;

import com.mycompany.mygym.member.dao.MemberDao;

@Service
public class MemberService implements MemberServiceImpl {

	@Autowired
	@Qualifier("memberDao")
	private MemberDao dao;
}
