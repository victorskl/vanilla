package com.sankholin.servlet;

import com.sankholin.service.ITestService;

import javax.inject.Inject;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

@WebServlet(name = "testServlet", urlPatterns = {"/testcdi"})
public class TestServlet extends HttpServlet {

    @Inject
    private ITestService testService;

    protected void doGet(HttpServletRequest request, HttpServletResponse response)
        throws ServletException, IOException {
        PrintWriter out = response.getWriter();
        out.println("[TestServlet] Calling injected testService: " + testService.add(2, 3));
        out.close();
    }
}