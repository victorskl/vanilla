package com.sankholin.views;

import java.io.Serializable;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Named;

@Named
@ViewScoped
public class PrimeView implements Serializable {

    private String message;
    private String content;

    @PostConstruct
    public void init() {
        System.out.println("\tPrime view will be constructed.");
    }

    @PreDestroy
    private void destroy() {
        System.out.println("\tPrime view will be destroyed.");
    }

    public String process() {
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Your message: " + message) );
        return "prime";
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }
}
