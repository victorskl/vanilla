package com.sankholin.core.dao;

import java.math.BigDecimal;
import java.util.LinkedList;
import java.util.List;

import javax.annotation.PostConstruct;

import org.springframework.stereotype.Repository;

import com.sankholin.core.model.Car;

@Repository
public class CarDaoImpl implements CarDao {

    private List<Car> carList = new LinkedList<Car>();

    @PostConstruct
    private void init() {
        Car car1 = new Car();
        car1.setName("Mercedes SL");
        car1.setPrice(new BigDecimal(123400));
        carList.add(car1);

        Car car2 = new Car();
        car2.setName("BMW M6 Coupé");
        car2.setPrice(new BigDecimal(125000));
        carList.add(car2);

        Car car3 = new Car();
        car3.setName("Audi R8");
        car3.setPrice(new BigDecimal(136100));
        carList.add(car3);
    }

    @Override
    public List<Car> findAll() {
        return carList;
    }

    @Override
    public void add(Car car) {
        carList.add(car);
    }
}
