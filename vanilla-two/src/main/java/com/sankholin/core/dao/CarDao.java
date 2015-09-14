package com.sankholin.core.dao;

import java.util.List;

import com.sankholin.core.model.Car;

public interface CarDao {
    List<Car> findAll();
    void add(Car car);
}
