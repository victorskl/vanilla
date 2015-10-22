package com.sankholin.vanilla.three.ui;

import com.sankholin.vanilla.three.model.Gender;
import com.sankholin.vanilla.three.model.Member;
import com.sankholin.vanilla.three.service.RegistrationService;
import org.zkoss.zk.ui.Component;
import org.zkoss.zk.ui.Executions;
import org.zkoss.zk.ui.select.SelectorComposer;
import org.zkoss.zk.ui.select.annotation.Listen;
import org.zkoss.zk.ui.select.annotation.VariableResolver;
import org.zkoss.zk.ui.select.annotation.Wire;
import org.zkoss.zk.ui.select.annotation.WireVariable;
import org.zkoss.zul.*;

import java.util.UUID;

@VariableResolver(org.zkoss.zkplus.spring.DelegatingVariableResolver.class)
public class RegistrationController extends SelectorComposer<Component> {

    @Wire
    private Textbox nameBox;

    @Wire
    private Radiogroup genderRadio;

    @Wire
    private Datebox birthdayBox;

    @Wire
    private Button submitButton;

    @Wire
    private Checkbox acceptTermBox;

    @WireVariable("registrationServiceImpl")
    private RegistrationService registrationService;

    @Override
    public void doAfterCompose(Component comp) throws Exception {
        super.doAfterCompose(comp);
        getPage().setTitle("Registration Form");
    }

    @Listen("onCheck = #acceptTermBox")
    public void changeSubmitStatus() {
        if (acceptTermBox.isChecked()) {
            submitButton.setDisabled(false);
            submitButton.setIconSclass("z-icon-check");
        } else {
            submitButton.setDisabled(true);
            submitButton.setIconSclass("");
        }
    }

    @Listen("onClick = #submitButton")
    public void submit() {
        Member member = new Member();
        member.setId(UUID.randomUUID().toString());
        member.setName(nameBox.getValue());
        String selectedGender = genderRadio.getSelectedItem().getValue();
        member.setGender(Gender.valueOf(selectedGender.toUpperCase()));
        member.setDob(birthdayBox.getValue());
        registrationService.addMember(member);
        Executions.sendRedirect("/members.zul");
    }
}