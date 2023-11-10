package com.shopping.sales.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.shopping.sales.entity.SalesInfo;

public interface SalesInfoRepository extends JpaRepository<SalesInfo, Integer> {

}
