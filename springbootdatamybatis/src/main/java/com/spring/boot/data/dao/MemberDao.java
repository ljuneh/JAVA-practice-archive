package com.spring.boot.data.dao;

import java.util.List;

import com.spring.boot.data.dto.Member;

public interface MemberDao {
	List<Member> findMember();

}
