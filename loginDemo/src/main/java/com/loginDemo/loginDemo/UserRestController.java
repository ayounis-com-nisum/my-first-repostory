package com.loginDemo.loginDemo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/UserRestController")
public class UserRestController {
	
	UserRestController(){
		System.out.println(">>>>>");
		
	}
	
	@Autowired
	private  UserRepository userRepository;
	
	@RequestMapping(value="/addMethod" ,method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_VALUE)
	  public List<UserModel> addUser()  { 
			System.out.println("Call add method");
	  return userRepository.findAll();
	  }   
}
