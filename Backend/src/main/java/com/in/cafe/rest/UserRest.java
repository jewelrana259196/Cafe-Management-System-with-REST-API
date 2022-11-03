package com.in.cafe.rest;

import java.util.List;
import java.util.Map;

import com.in.cafe.wrapper.UserWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping; 

@RequestMapping(path = "/user")
public interface UserRest {
	@PostMapping(path = "/signup")
	public ResponseEntity<String>signUp(@RequestBody(required = true)Map<String, String> requiredMap);

	@PostMapping(path = "/login")
	public ResponseEntity<String> login(@RequestBody(required= true)Map<String, String> requiredMap);

	@GetMapping(path = "/get")
	public ResponseEntity<List<UserWrapper>>getAllUser();

	@PostMapping(path = "/update")
	public ResponseEntity<String> update(@RequestBody(required = true)Map<String, String> requiredMap);

	@GetMapping(path = "/checkToken")
	ResponseEntity<String> checkToken();

	@PostMapping(path = "/ChangePassword")
	ResponseEntity<String> ChangePassword(@RequestBody(required = true)Map<String, String> requiredMap);




}
