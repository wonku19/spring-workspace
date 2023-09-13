package com.ncs.test.member.model.service;

import com.ncs.test.member.model.dao.MemberDAO;
import com.ncs.test.member.model.vo.Member;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MemberServiceImpl implements MemberService {
    
    @Autowired
    private MemberDAO memberDAO;

    @Override
    public Member loginMember(String memberId, String memberPwd) {
        return memberDAO.loginMember(memberId, memberPwd);
    }
}