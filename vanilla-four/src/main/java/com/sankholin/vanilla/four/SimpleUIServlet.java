package com.sankholin.vanilla.four;

import com.vaadin.annotations.VaadinServletConfiguration;
import com.vaadin.server.VaadinServlet;

import javax.servlet.annotation.WebServlet;

/**
 * NOTES:
 * If not multi servlet and using sub-path, servlet has to map /VAADIN/* as well.
 *
 *     urlPatterns = {"/simple/*", "/VAADIN/*"}
 *
 * But this has to be done only once on any VaadinServlet.
 * Hence here ProductUIServlet already done that. So omit in this servlet.
 *
 * 4.9.5. Servlet Mapping with URL Patterns
 * https://vaadin.com/book/-/page/application.environment.html
 */
@WebServlet(urlPatterns = {"/simple/*"}, name = "SimpleUIServlet", asyncSupported = true)
@VaadinServletConfiguration(ui = SimpleUI.class, productionMode = false)
public class SimpleUIServlet extends VaadinServlet {
}