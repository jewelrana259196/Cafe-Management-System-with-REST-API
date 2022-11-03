package com.in.cafe.restlmple;

import com.in.cafe.POJO.BkashData;
import com.in.cafe.constents.CafeConstents;
import com.in.cafe.rest.BkashDataRest;
import com.in.cafe.service.BkashDataService;
import com.in.cafe.utils.CafeUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
public class BkashDataRestImpl implements BkashDataRest {


    @Autowired
    BkashDataService categoryService;

    @Override
    public ResponseEntity<String> addNewBkashData(BkashData requestMap) {
        try{
            return categoryService.addNewBkashData(requestMap);
        }
        catch (Exception ex){
            ex.printStackTrace();
             }
        return CafeUtils.getResponseEntity(CafeConstents.SOMETETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @Override
    public ResponseEntity<List<BkashData>> getAllBkashData(String filterValue) {
        try{
            return categoryService.getAllBkashData(filterValue);

        }catch (Exception ex){
            ex.printStackTrace();
        }
        return new  ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);
    }

}

