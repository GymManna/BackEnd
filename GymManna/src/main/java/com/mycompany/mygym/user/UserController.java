package com.mycompany.mygym.user;

import java.util.List;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.bind.annotation.SessionAttributes;

import com.mycompany.mygym.user.service.UserService;
import com.mycompany.mygym.user.vo.User;

@RestController
@CrossOrigin(origins = "http://localhost:8081/")
@RequestMapping("user")
@SessionAttributes("newUser")
public class UserController {

	Logger log = LogManager.getLogger("case3");
	
	@Autowired
	private UserService userService;
	
	//회원가입 통로
	@GetMapping(value = "/registerjsp")
	public String registerJsp() {
		
		return "user/userRegister";
	}
	
//	@RequestMapping(value="newUser")
//	public User newUser() {
//		User user = new User();
//		return user;
//	}
	
	//회원가입
	@PostMapping(value = "/register", produces = "application/json; charset=UTF-8")
	public User register(@ModelAttribute User user, Model model) {
		log.debug("회원가입컨트롤러");
		User result = userService.createUser(user);
		
//		model.addAttribute("message", "회원가입이 완료되었습니다.");
		
		return result;
	}
	
	//회원가입 - 카카오
	@PostMapping(value = "/registeruserkakao", produces = "application/json; charset=UTF-8")
	public User registerUserKakao(@ModelAttribute User user, Model model) {
		log.debug("회원가입컨트롤러");
		user.setUserPassword("1");
		user.setUserPhone("010-9999-9998");
		User result = userService.createUserKakao(user);
		
//		model.addAttribute("message", "회원가입이 완료되었습니다.");
		
		return result;
	}
		
	//로그인
	@GetMapping(value = "/login", produces = "application/json; charset=UTF-8")
	public User login(Model model, String userId, String userPw) {
		log.debug("login");
		User user = new User();
		user.setUserId(userId);
		user.setUserPassword(userPw);
//		log.debug(user);
		User result = userService.loginUser(user);
		
		model.addAttribute("user", user);
		
		if(result == null ) {
			log.debug("로그인 실패");
		}
		return result;
	}
	
	//로그인 - 카카오
	@GetMapping(value = "/loginkakao", produces = "application/json; charset=UTF-8")
	public User loginKakao(Model model, String userId) {
		log.debug("loginKakao");
		User user = new User();
		user.setUserId(userId);
		user.setUserRoute(1);
//		log.debug(user);
		User result = userService.loginUserKakao(user);
		
		model.addAttribute("user", user);
		
		if(result == null ) {
			log.debug("로그인 실패");
		}
		return result;
	}
	
	//로그인 - 카카오
	@GetMapping(value = "/userinfo", produces = "application/json; charset=UTF-8")
	public User getUserInfo(Model model, String userId) {
		log.debug("getUserInfo");
		User user = new User();
		user.setUserId(userId);
//		log.debug(user);
		User result = userService.selectUser(user);
		
		model.addAttribute("user", user);
		
		if(result == null ) {
			log.debug("로그인 실패");
		}
		return result;
	}
	
	//회원정보수정
	@PostMapping(value = "/update")
	public String updateHandler(User user, Model model) {
		log.debug("update컨트롤러");
		
		userService.editUser(user);
		return null;
	}
	
	//전체회원 리스트 불러오기
	@GetMapping(value = "/admin")
	public String adminHandler(Model model){
		log.debug("admin컨트롤러");
		List<User> user = userService.allUser();
		 model.addAttribute("user", user);

		return "user/allUser";
	}
	
	//회원 탈퇴
	@DeleteMapping(value = "/")
	public void deleteHandler() {
		userService.deleteUser();
	}

}
