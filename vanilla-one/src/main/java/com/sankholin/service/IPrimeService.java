package com.sankholin.service;

import com.sankholin.model.Prime;

import java.util.List;

public interface IPrimeService {
    List<Prime> getPrimes();
    void addPrime(Prime prime);
}
