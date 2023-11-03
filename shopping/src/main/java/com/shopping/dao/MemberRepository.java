package com.shopping.dao;

import org.springframework.data.repository.CrudRepository;

import com.shopping.entity.Member;

public interface MemberRepository extends CrudRepository<Member, Integer> {

}
