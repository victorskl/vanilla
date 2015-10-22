package com.sankholin.vanilla.three.ui;

import com.sankholin.vanilla.three.model.Member;
import com.sankholin.vanilla.three.service.RegistrationService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.util.Clients;
import org.zkoss.zkplus.spring.SpringUtil;
import org.zkoss.zul.ListModelList;
import org.zkoss.zul.Listbox;

import java.util.List;

public class MembersController extends SelectorComposer<Component> {

    @Wire
    private Listbox memberListbox;

    //alternative way of getting Spring Bean
    private RegistrationService registrationService = (RegistrationService) SpringUtil.getBean("registrationServiceImpl");

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);

        getPage().setTitle("Member List");
        Clients.showNotification("Welcome to V3 Enterprise Member Registration System!");

        List<Member> members = registrationService.getAllMembers();
        memberListbox.setModel(new ListModelList<>(members));
    }
}