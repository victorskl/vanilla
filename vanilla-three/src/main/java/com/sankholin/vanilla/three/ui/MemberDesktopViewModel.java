package com.sankholin.vanilla.three.ui;

import com.sankholin.vanilla.three.model.Gender;
import com.sankholin.vanilla.three.model.Member;
import com.sankholin.vanilla.three.service.RegistrationService;
import org.zkoss.bind.annotation.Command;
import org.zkoss.bind.annotation.Init;
import org.zkoss.bind.annotation.NotifyChange;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.WireVariable;

import java.util.List;
import java.util.UUID;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class MemberDesktopViewModel {

    private List<Member> memberList;
    private Member member;
    private String selectedGender;
    private boolean winRegClose = false;

    @WireVariable("registrationServiceImpl")
    private RegistrationService registrationService;

    @Init
    public void init() {
        memberList = registrationService.getAllMembers();
        member = new Member();
    }

    @NotifyChange({"memberList", "member", "winRegClose"})
    @Command
    public void cmdSubmit() {
        member.setId(UUID.randomUUID().toString());
        member.setGender(Gender.valueOf(selectedGender.toUpperCase()));
        memberList.add(member);
        member = new Member();
        this.winRegClose = false;
    }

    //getter/setter

    public List<Member> getMemberList() {
        return memberList;
    }

    public void setMemberList(List<Member> memberList) {
        this.memberList = memberList;
    }

    public Member getMember() {
        return member;
    }

    public void setMember(Member member) {
        this.member = member;
    }

    public String getSelectedGender() {
        return selectedGender;
    }

    public void setSelectedGender(String selectedGender) {
        this.selectedGender = selectedGender;
    }

    public boolean isWinRegClose() {
        return winRegClose;
    }

    public void setWinRegClose(boolean winRegClose) {
        this.winRegClose = winRegClose;
    }
}