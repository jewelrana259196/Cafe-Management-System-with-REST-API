package com.in.cafe.service;

import com.in.cafe.POJO.BkashData;
import org.springframework.http.ResponseEntity;

import java.util.List;
import java.util.Map;

public interface BkashDataService {

    ResponseEntity<String> addNewBkashData(BkashData requestMap);

    ResponseEntity<List<BkashData>> getAllBkashData(String filterValue);

}
