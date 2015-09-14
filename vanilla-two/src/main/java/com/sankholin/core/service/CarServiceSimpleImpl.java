package com.sankholin.core.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sankholin.core.dao.CarDao;
import com.sankholin.core.model.Car;

@Service
public class CarServiceSimpleImpl implements ICarService {

    @Autowired
    private CarDao carDao;

    @Override
    public List<Car> findAll() {
        return carDao.findAll();
    }

    @Override
    public void add(Car car) {
        carDao.add(car);
    }
}
