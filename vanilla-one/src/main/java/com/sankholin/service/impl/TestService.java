package com.sankholin.service.impl;

import com.sankholin.service.ITestService;

public class TestService implements ITestService {

    @Override
    public int add(int a, int b) {
        return a + b;
    }
}