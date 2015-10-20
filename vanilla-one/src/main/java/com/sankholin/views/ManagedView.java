package com.sankholin.views;

import com.sankholin.service.IManagedTestService;
import com.sankholin.service.ITestService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.ManagedProperty;
import javax.inject.Inject;

@ManagedBean
public class ManagedView {

    @ManagedProperty(value = "#{managedTestService}")
    private IManagedTestService managedTestService;

    private String message;

    @PostConstruct
    public void init() {
        message = "Calling JSF @ManagedProperty managedTestService -> " + managedTestService.multiply(3, 3);
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
        message = "Calling testService: " + testService.add(2, 3); // will throw java.lang.NullPointerException
    }
}
