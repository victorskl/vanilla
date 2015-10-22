package com.sankholin.vanilla.three.service;

import com.sankholin.vanilla.three.model.Member;

import java.util.List;

public interface RegistrationService {
    void addMember(Member member);

    List<Member> getAllMembers();

    Member findMemberByName(String name);
}