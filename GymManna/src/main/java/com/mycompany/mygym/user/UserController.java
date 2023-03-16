package com.mycompany.mygym.user;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.mycompany.mygym.user.service.UserService;
import com.mycompany.mygym.user.vo.User;

@Controller
@RequestMapping("user")
public class UserController {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private UserService userService;
	
	//회원가입 통로
	@GetMapping(value = "/registerjsp")
	public String registerJsp() {
		
		return "user/userRegister";
	}
	
	//회원가입
	@PostMapping(value = "/register")
	public String registerHandler(@ModelAttribute User user, Model model) {
		
		userService.createUser(user);
		log.debug("회원가입컨트롤러");
		model.addAttribute("message", "회원가입이 완료되었습니다.");
		
		return null;
	}
		
	//로그인
	@GetMapping(value = "/login")
	public String loginHandler(Model model, String userId, String userPw) {
		log.debug("컨트롤러");
		User user = new User();
		user.setUserId(userId);
		user.setUserPassword(userPw);
		log.debug(user);
		User result = userService.loginUser(user);
		
		if(result == null ) {
			log.debug("서비스 실패");
			return "user/loginFail";
		} else {
			return "user/loginSuccess";
		}
	}
	
	//회원정보수정
//	@PostMapping(value = "/update")
//	public String updateHandler() {
//		log.debug("update컨트롤러");
//		User user = new User();
//		User result = userService.
//		return null;
//	}
	
	//전체회원 리스트 불러오기
	@GetMapping(value = "/admin")
	public List<User> adminHandler(){
		log.debug("update컨트롤러");
		return null;
	}
	
	//로그아웃
//	@PostMapping(value="/logout")
//	public String logoutHandler() {	
//		
//		
//		return null;
//	}
//	
}
