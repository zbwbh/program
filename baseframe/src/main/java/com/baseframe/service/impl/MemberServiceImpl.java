package com.baseframe.service.impl;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.baseframe.dao.MemberDao;
import com.baseframe.entity.Member;
import com.baseframe.service.MemberService;

@Service
public class MemberServiceImpl implements MemberService {

    @Resource
    private MemberDao memberDao;
    
    public void insertMember(Member member) {
        memberDao.saveMember(member);
    }

    public String checkName(String name) {
        List<Member> members = memberDao.listMembersByName(name);
        if(null!=members &&!members.isEmpty()&&members.size()==1) {
            return "1";
        }
        return "2";
    }
}
