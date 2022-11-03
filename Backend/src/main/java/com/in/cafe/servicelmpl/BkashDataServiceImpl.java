package com.in.cafe.servicelmpl;

import com.in.cafe.JWT.JwtFilter;
import com.in.cafe.POJO.BkashData;
import com.in.cafe.constents.CafeConstents;
import com.in.cafe.dao.BkashDataDao;
import com.in.cafe.service.BkashDataService;
import com.in.cafe.utils.CafeUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class BkashDataServiceImpl implements BkashDataService {

    @Autowired
    BkashDataDao bkashDataDao;

    @Autowired
    JwtFilter jwtFilter;

    @Override
    public ResponseEntity<String> addNewBkashData(BkashData requestMap) {
        try {
            if (jwtFilter.isAdmin()) {
                bkashDataDao.save(requestMap);
                return CafeUtils.getResponseEntity("BkashData added successfully", HttpStatus.OK);
            } else {
                return CafeUtils.getResponseEntity(CafeConstents.UNAUTHORIZED_ACCESS, HttpStatus.UNAUTHORIZED);
            }
        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return CafeUtils.getResponseEntity(CafeConstents.SOMETETHING_WENT_WRONG, HttpStatus.INTERNAL_SERVER_ERROR);
    }


    private boolean validateBkashDataMap(Map<String, String> requestMap, boolean validateId) {
        if (requestMap.containsKey("name")) {
            if (requestMap.containsKey("id") && validateId) {
                return true;
            } else if (!validateId) {
                return true;
            }
        }
        return false;
    }

    @Override
    public ResponseEntity<List<BkashData>> getAllBkashData(String filterValue) {
        try {
            if (filterValue == null || filterValue.isEmpty()) {
                log.info("Inside if");
                return new ResponseEntity<>(bkashDataDao.findAll(), HttpStatus.OK);
            } else {

                return new ResponseEntity<>(bkashDataDao.findAll(), HttpStatus.OK);
            }

        } catch (Exception ex) {
            ex.printStackTrace();
        }
        return new ResponseEntity<>(new ArrayList<>(), HttpStatus.INTERNAL_SERVER_ERROR);

    }

}








