package com.sankholin.vanilla.three.dao;

import com.sankholin.vanilla.three.model.Member;

import java.util.List;

public interface MemberDao {
    void addMember(Member member);

    List<Member> getAllMembers();

    Member findMemberByName(String name);
}