package com.baseframe.service;

import com.baseframe.entity.Member;

public interface MemberService {

    void insertMember(Member member);
    
    String checkName(String name);
}
