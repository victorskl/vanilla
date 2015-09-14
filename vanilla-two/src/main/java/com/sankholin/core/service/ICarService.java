package com.sankholin.core.service;

import java.util.List;

import com.sankholin.core.model.Car;

public interface ICarService {
    List<Car> findAll();
    void add(Car car);
}
