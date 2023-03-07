package com.mycompany.mygym;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.mygym.member.service.MemberService;

@Controller
@RequestMapping("member")
public class MemberLoginController {

	@Autowired
	private MemberService service;
	
	@PostMapping(value="Login")
	public String Login() {
		
		
		return null;
	}
}
