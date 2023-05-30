package com.assignment.api.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.assignment.api.configuration.JwtUtil;
import com.assignment.api.configuration.UserCustomConfigService;
import com.assignment.api.dao.UserRepository;
import com.assignment.api.model.UserModel;

@RestController
public class UserController {
	
	@Autowired
	private JwtUtil jwtUtil;
	@Autowired
	private UserCustomConfigService userCustomConfigService;
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;
	@Autowired
	private UserRepository  userRepository;
	@Autowired
	AuthenticationManager authenticationManager;
	
	
	
	//user can register using this url
	@PostMapping("/signUp")
	public Object saveNewUser(@RequestBody UserModel user) {
		try {
			user.setPassword(bCryptPasswordEncoder.encode(user.getPassword()));
			user.setRole("ROLE_NORMAL");
			userRepository.save(user);
			return "User registered successfully...";
		}catch(Exception e) {
			e.printStackTrace();
			return "ERROR : "+e.getMessage();
		}
	}
	
	
	//user can login using this url
	@PostMapping("/login")
	public ResponseEntity<String> generateToken(@RequestBody UserModel user) throws Exception{
		try {
			this.authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(user.getEmail() , user.getPassword()));
		}catch(Exception e){
			e.printStackTrace();
			return ResponseEntity.ok("{\"message\" : \"Invalid email or password..\",\"status\":1}");
		}
		//generate the token
		UserDetails userDetails= this.userCustomConfigService.loadUserByUsername(user.getEmail());
		String token=this.jwtUtil.generateToken(userDetails);
		return ResponseEntity.ok("{ \"Token\" : \""+token+"\", \"status\":0, \"message\": \"user can successfully login.\"}");
	}
	
	
	//this url access those user who can login success full
	@GetMapping("/securePage")
	public Object accessToSecurePage() {
		return "you'r login to server, so you access this secure page....";
	}
	
}
