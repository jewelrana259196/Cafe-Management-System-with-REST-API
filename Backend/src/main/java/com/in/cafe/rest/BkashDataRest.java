package com.in.cafe.rest;

import com.in.cafe.POJO.BkashData;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequestMapping(path = "/bkash-data")
public interface BkashDataRest {

    @PostMapping(path = "/add")
    ResponseEntity<String> addNewBkashData(@RequestBody (required = true)
                                          BkashData requestMap);

    @GetMapping(path = "/get")
    ResponseEntity<List<BkashData>> getAllBkashData(@RequestParam(required = false)
                                                String filterValue);
}
