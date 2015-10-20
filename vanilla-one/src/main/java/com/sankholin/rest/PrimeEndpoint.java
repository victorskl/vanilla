package com.sankholin.rest;

import com.sankholin.model.Prime;
import com.sankholin.service.IPrimeService;

import javax.inject.Inject;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.concurrent.TimeUnit;

@Path("/prime")
public class PrimeEndpoint {

    @Inject
    private IPrimeService primeService;

    @GET
    @Path("/simple")
    public String simple() {
        return "Simple Prime Service";
    }

    @GET
    @Path("/getPrimes")
    @Produces({MediaType.APPLICATION_XML, MediaType.APPLICATION_JSON})
    public List<Prime> getPrimes() throws InterruptedException {
        TimeUnit.SECONDS.sleep(1); //mimic backend service loading
        return primeService.getPrimes();
    }
}
