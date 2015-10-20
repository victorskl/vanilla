package com.sankholin.model;

import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
public class Prime {

    private String id;
    private String message;
    private String content;

    public Prime() {
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
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
