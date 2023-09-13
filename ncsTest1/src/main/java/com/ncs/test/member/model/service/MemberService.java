package com.ncs.test.member.model.service;

import com.ncs.test.member.model.vo.Member;

public interface MemberService {
    
    Member loginMember(String memberId, String memberPwd);
    
}

