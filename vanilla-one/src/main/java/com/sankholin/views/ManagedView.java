package com.sankholin.views;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

import com.sankholin.service.IManagedTestService;
import com.sankholin.service.ITestService;

@ManagedBean
public class ManagedView {

    @ManagedProperty(value = "#{managedTestService}")
    private IManagedTestService managedTestService;

    private String message;

    @PostConstruct
    public void init() {
        message = "Hello JSF Managed backing bean @ManagedBean! -> " + managedTestService.multiply(3, 3);
    }

    @PreDestroy
    public void destroy() {
        System.out.println("\tManaged view will be destroyed!");
    }

    // JSF DI is Setter DI
    public void setManagedTestService(IManagedTestService managedTestService) {
        this.managedTestService = managedTestService;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }


    /**
     * This won't work. Calling CDI from JSF ManagedBean context.
     */

    @Inject
    private ITestService testService;

    public void callTestService() {
        message = " iTestService call: " + testService.add(2, 3); // will throw java.lang.NullPointerException
    }
}
