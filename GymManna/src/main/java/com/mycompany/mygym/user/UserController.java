package com.mycompany.mygym.user;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.mygym.user.service.UserService;
import com.mycompany.mygym.user.vo.User;

@Controller
@RequestMapping("user")
public class UserController {

	@Autowired
	private UserService service;
	
	@PostMapping(value="login")
	public String login(String userId, String userPw, Model model) {
		
		User user = new User();
		user.setUserId(userId);
		user.setUserPw(userPw);
		
		User res = service.selectUser(user);
		
		model.addAttribute("user",res);
	
		return "login/loginsuccess";
		
	}
	
}
