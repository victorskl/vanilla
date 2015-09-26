package com.sankholin.web.rest;

import java.util.List;
import java.util.concurrent.TimeUnit;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sankholin.core.model.Car;
import com.sankholin.core.service.ICarService;

@RestController
public class CarRestController {

    @Autowired
    private ICarService iCarService;

    @RequestMapping(value = "/rest/getCars", produces = "application/json")
    public List<Car> getCars() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1); //mimic backend service loading
        return iCarService.findAll();
    }
}