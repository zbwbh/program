package com.baseframe.dao;

import java.util.List;

import com.baseframe.entity.Member;

public interface MemberDao {

    public void saveMember(Member member);
    
    public List<Member> listAllMembers();
    
    public List<Member> listMembersByName(String name);
}
