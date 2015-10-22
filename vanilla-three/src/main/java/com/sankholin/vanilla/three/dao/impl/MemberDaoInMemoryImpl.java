package com.sankholin.vanilla.three.dao.impl;

import com.sankholin.vanilla.three.dao.MemberDao;
import com.sankholin.vanilla.three.model.Gender;
import com.sankholin.vanilla.three.model.Member;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

@Repository
public class MemberDaoInMemoryImpl implements MemberDao {

    private List<Member> inMemoryMemberDB = new ArrayList<>();

    public MemberDaoInMemoryImpl() {
        Member user = new Member();
        user.setId(UUID.randomUUID().toString());
        user.setName("Alex the Wanderer");
        user.setGender(Gender.MALE);
        user.setDob(new Date());
        inMemoryMemberDB.add(user);
    }

    @Override
    public void addMember(Member member) {
        inMemoryMemberDB.add(member);
    }

    @Override
    public List<Member> getAllMembers() {
        return inMemoryMemberDB;
    }

    @Override
    public Member findMemberByName(String name) {
        for (Member member : inMemoryMemberDB) {
            if (member.getName().equalsIgnoreCase(name)) {
                return member;
            }
        }
        return null;
    }
}