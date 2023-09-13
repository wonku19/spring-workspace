package com.ncs.test.member.model.dao;

import com.ncs.test.member.model.vo.Member;
import org.mybatis.spring.SqlSessionTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

@Repository
public class MemberDAO {

    @Autowired
    private SqlSessionTemplate sqlSession;

    public Member loginMember(String memberId, String memberPwd) {
        Member member = new Member();
        member.setMemberId(memberId);
        member.setMemberPwd(memberPwd);
        
        return sqlSession.selectOne("memberMapper.loginMember", member);
    }
}