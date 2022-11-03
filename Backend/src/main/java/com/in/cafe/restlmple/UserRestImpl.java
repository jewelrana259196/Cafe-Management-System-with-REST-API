package com.in.cafe.restlmple;

import com.in.cafe.constents.CafeConstents;
import com.in.cafe.rest.UserRest;
import com.in.cafe.service.UserService;
import com.in.cafe.utils.CafeUtils;
import com.in.cafe.wrapper.UserWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@RestController
public class UserRestImpl implements UserRest {

    @Autowired
    UserService userService;

    @Override
    public ResponseEntity<String> signUp(@RequestBody(required = true) Map<String, String> requiredMap) {
       try{
            return userService.signUp(requiredMap);
       }catch (Exception ex){
           ex.printStackTrace();
       }
        return CafeUtils.getResponseEntity(CafeConstents.SOMETETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> login(Map<String, String> requiredMap) {
       try {

           return userService.login(requiredMap);
       }catch (Exception ex){
        ex.printStackTrace();
       }
        return CafeUtils.getResponseEntity(CafeConstents.SOMETETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<List<UserWrapper>> getAllUser() {
        try {
            return userService.getAllUser();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new ResponseEntity<List<UserWrapper>>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> update(Map<String, String> requiredMap) {
        try{
            return userService.update(requiredMap);
        } catch (Exception ex){
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstents.SOMETETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<String> checkToken() {
        try{
            return userService.checkToken();
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstents.SOMETETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);

    }

    @Override
    public ResponseEntity<String> ChangePassword(Map<String, String> requiredMap) {
        try{
            return userService.ChangePassword(requiredMap);
        }catch (Exception ex){
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstents.SOMETETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }



}

