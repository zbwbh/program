package com.baseframe.dao;

import java.util.List;

import com.baseframe.entity.Member;

public interface MemberDao {

    public void insertMember(Member member);
    
    public List<Member> selectAllMembers();
    
    public List<Member> selectMembersByName(String name);
}
