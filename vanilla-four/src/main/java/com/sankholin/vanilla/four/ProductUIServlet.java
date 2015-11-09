package com.sankholin.vanilla.four;

import com.vaadin.spring.server.SpringVaadinServlet;

import javax.servlet.annotation.WebServlet;

@WebServlet(urlPatterns = {"/product/*", "/VAADIN/*"}, name = "ProductUIServlet", asyncSupported = true)
public class ProductUIServlet extends SpringVaadinServlet {
}