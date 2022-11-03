package com.in.cafe.dao;

import com.in.cafe.POJO.BkashData;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface BkashDataDao extends JpaRepository<BkashData, Integer> {

}

