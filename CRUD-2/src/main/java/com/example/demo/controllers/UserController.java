package com.example.demo.controllers;

import java.util.Optional;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.example.demo.models.User;
import com.example.demo.models.UserDAO;
import com.example.demo.services.UserService;

@Controller
public class UserController {
	@Autowired
    UserService userService;
	
	@Autowired
	User userBean;
	@GetMapping("/")
	public String addOrEdit(ModelMap model) {
		User u = new User();
		
		model.addAttribute("USER", u);
		model.addAttribute("ACTION", "saveOrUpdate");
		
		return "register";
	}
	@PostMapping("/saveOrUpdate")
	public String saveOrUpdate(ModelMap model, @ModelAttribute("USER") User user) {
		//UserDAO dao = new UserDAO();
		//dao.save(user);
		userService.save(user);
		return "register";
	}
	@RequestMapping("/list")
	public String list(ModelMap model,HttpSession session) {
		//UserDAO dao = new UserDAO();
		//model.addAttribute("USERS", dao.getAll());
		//userService.findAll();
		if(session.getAttribute("USERNAME")!=null) {
			model.addAttribute("USERS", userService.findAll());
			return "view-user";
		}
		return "login";
	}
	
	@RequestMapping("/edit/{username}")
	public String edit(ModelMap model, @PathVariable(name = "username") String username) {
		//UserDAO dao = new UserDAO();
		//User u = dao.findByUsername(username);
		//model.addAttribute("USER", u);
		//model.addAttribute("ACTION", "/saveOrUpdate");
		
		Optional<User> u = userService.findById(username);
		if(u.isPresent()) {
			model.addAttribute("USER", u.get());
			
		}else {
			model.addAttribute("USER", new User());
		}
		model.addAttribute("ACTION", "/saveOrUpdate");
		return "register";
	}

	@RequestMapping("/delete/{username}")
	public String delete(ModelMap model, @PathVariable(name = "username") String username) {
		//UserDAO dao = new UserDAO();
		//dao.delete(username);
		userService.deleteById(username);
		model.addAttribute("USERS", userService.findAll());
		return "view-user";
	}
	
	@RequestMapping("/login")
	public String showLogin() {
		return "login";
	}
	
	@PostMapping("/checklogin")
	public String checkLogin(ModelMap model,@RequestParam("username") String username, @RequestParam("password") String password,
			HttpSession session) {
//		if(userBean.getUsername().equals(username)&& userBean.getPassword().equals(pasword)) {
//			System.out.println("login thanh cong");
//			return "index";
//		}else {
//			System.out.println("fail");
//		}
		if(userService.checkLogin(username, password)) {
			if(username.equals("admin")) {
				System.out.println("login ok");
				session.setAttribute("USERNAME", username);
				model.addAttribute("USERS", userService.findAll());
				return "view-user";
			}else {
				return "page-user";
			}
			
		}else {
			System.out.println("fail");
			model.addAttribute("ERROR", "Username and password not exist");
		}
		return "login";
	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session){
		session.removeAttribute("USERNAME");
		return "login";
	}
}
