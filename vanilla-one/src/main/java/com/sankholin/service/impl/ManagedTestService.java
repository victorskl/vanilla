package com.sankholin.service.impl;

import javax.faces.bean.ManagedBean;

import com.sankholin.service.IManagedTestService;

@ManagedBean
public class ManagedTestService implements IManagedTestService {

    @Override
    public int multiply(int a, int b) {
        return a * b;
    }
}
