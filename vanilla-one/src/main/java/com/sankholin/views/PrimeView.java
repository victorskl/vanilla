package com.sankholin.views;

import com.sankholin.model.Prime;
import com.sankholin.service.IPrimeService;

import javax.annotation.PostConstruct;
import javax.annotation.PreDestroy;
import javax.faces.application.FacesMessage;
import javax.faces.context.FacesContext;
import javax.faces.view.ViewScoped;
import javax.inject.Inject;
import javax.inject.Named;
import java.io.Serializable;
import java.util.List;
import java.util.UUID;

@Named
@ViewScoped
public class PrimeView implements Serializable {

    @Inject
    private IPrimeService primeService;

    private List<Prime> primes;

    private Prime prime;

    @PostConstruct
    public void init() {
        System.out.println("\tPrime view will be constructed.");
        primes = primeService.getPrimes();
        prime = new Prime();
        prime.setId(UUID.randomUUID().toString());
    }

    @PreDestroy
    private void destroy() {
        System.out.println("\tPrime view will be destroyed.");
    }

    public String process() {
        primeService.addPrime(prime);
        FacesContext context = FacesContext.getCurrentInstance();
        context.addMessage(null, new FacesMessage("Successful",  "Added Message: " + prime.getMessage()));
        return "prime";
    }

    public List<Prime> getPrimes() {
        return primes;
    }

    public Prime getPrime() {
        return prime;
    }

    public void setPrime(Prime prime) {
        this.prime = prime;
    }
}