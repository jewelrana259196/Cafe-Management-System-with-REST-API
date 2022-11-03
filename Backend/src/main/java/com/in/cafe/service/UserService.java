package com.in.cafe.service;

import java.util.List;
import java.util.Map;

import com.in.cafe.wrapper.UserWrapper;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;

public interface UserService {

	ResponseEntity<String> signUp(Map<String, String> requestMap);

	ResponseEntity<String> login(Map<String, String> requestMap);

	ResponseEntity<List<UserWrapper>> getAllUser();

	ResponseEntity<String> update(Map<String, String> requestMap);

	ResponseEntity<String> checkToken();

	ResponseEntity<String> ChangePassword(Map<String, String> requestMap);


}
