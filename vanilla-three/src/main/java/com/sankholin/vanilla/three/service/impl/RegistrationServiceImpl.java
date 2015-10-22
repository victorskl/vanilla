package com.sankholin.vanilla.three.service.impl;

import com.sankholin.vanilla.three.dao.MemberDao;
import com.sankholin.vanilla.three.model.Member;
import com.sankholin.vanilla.three.service.RegistrationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class RegistrationServiceImpl implements RegistrationService {

    @Autowired
    private MemberDao memberDao;

    @Override
    public void addMember(Member member) {
        memberDao.addMember(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return memberDao.getAllMembers();
    }

    @Override
    public Member findMemberByName(String name) {
        return memberDao.findMemberByName(name);
    }
}