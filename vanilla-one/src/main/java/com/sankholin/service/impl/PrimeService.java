package com.sankholin.service.impl;

import com.sankholin.model.Prime;
import com.sankholin.service.IPrimeService;

import javax.annotation.PostConstruct;
import javax.enterprise.context.ApplicationScoped;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@ApplicationScoped
public class PrimeService implements IPrimeService {

    private List<Prime> primes;

    @PostConstruct
    public void init() {
        //In real world, this will link up to persistent data tier.
        primes = new ArrayList<>();
        Prime prime = new Prime();
        prime.setId(UUID.randomUUID().toString());
        prime.setMessage("Initial message");
        prime.setContent("<strong>Probably</strong> initial content from persistent store.");
        primes.add(prime);

        prime = new Prime();
        prime.setId(UUID.randomUUID().toString());
        prime.setMessage("Second message");
        prime.setContent("This is <font color=\"#ff0000\">second</font> message. This should have " +
                "<font style=\"background-color: rgb(255, 255, 0);\">highlighted with yellow background</font>.");
        primes.add(prime);
    }

    @Override
    public List<Prime> getPrimes() {
        return primes;
    }

    @Override
    public void addPrime(Prime prime) {
        primes.add(prime);
    }
}