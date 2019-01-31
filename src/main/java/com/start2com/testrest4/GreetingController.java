/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.start2com.testrest4;

import java.util.*;
import java.util.concurrent.atomic.AtomicInteger;
import java.util.concurrent.atomic.AtomicLong;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author burik
 */
@RestController
public class GreetingController {

    private static final String template = "Hello, %s!";
    private final AtomicLong counter = new AtomicLong();
    private final AtomicInteger intCounter = new AtomicInteger();
    private final Random random = new Random();

    Logger logger = LogManager.getLogger(Greeting.class);

    @RequestMapping(value = "/greeting", produces = MediaType.APPLICATION_XML_VALUE)
    public Greeting greeting(@RequestParam(value = "name", defaultValue = "World") String name) {
        System.out.println("Call greeting...");
        return new Greeting(counter.incrementAndGet(),
                String.format(template, name));
    }

    @RequestMapping(value = "/balance", produces = MediaType.APPLICATION_XML_VALUE)
    public BalanceResponce balanceResponce(@RequestParam(value = "clientID") String abonentId,
                                           @RequestParam(value = "systemID", defaultValue = "") String systemID) {

        BalanceResponce balanceResponce = new BalanceResponce();
        balanceResponce.setCode(intCounter.incrementAndGet());
        balanceResponce.setError("Some error text");
        balanceResponce.setValue(new BalanceValue());
        balanceResponce.getValue().setAbonentID(abonentId);
        balanceResponce.getValue().setActualDate(Calendar.getInstance());
        balanceResponce.getValue().setAmount(random.nextLong());
        balanceResponce.getValue().setComponentID(systemID);
        logger.error(abonentId);
        return new BalanceResponce();
    }

    @RequestMapping(value = "/mwapi/pending_service_upd_add")
    public rows PendingServiceUpdateAdd(@RequestParam(value = "transactionId", defaultValue = "") String transactionId,
                                        @RequestParam(value = "service_account_number", defaultValue = "") String abonentId,
                                        @RequestParam(value = "service_spec_external_id", defaultValue = "") String systemID,
                                        @RequestParam(value = "service_state_external_id", defaultValue = "") String abonent1Id,
                                        @RequestParam(value = "subscribe_date", defaultValue = "") Date subscribeDate) {
        rows Rows = new rows();
        Rows.message.add(abonentId);
        Rows.message.add(systemID);
        Rows.message.add(abonent1Id);
        Rows.message.add(subscribeDate.toString());
        System.out.println("Call PSUA...");
        return Rows;

    }
    @RequestMapping(value = "/mwapi/pending_service_upd_delete")
    public rows PendingServiceUpdateDelete(@RequestParam(value = "transactionId", defaultValue = "") String transactionId,
                                           @RequestParam(value = "service_account_number", defaultValue = "") String abonentId,
                                           @RequestParam(value = "service_spec_external_id", defaultValue = "") String systemID,
                                           @RequestParam(value = "service_state_external_id", defaultValue = "") String abonent1Id) {
        rows Rows = new rows();
        Rows.message.add(abonentId);
        Rows.message.add(systemID);
        Rows.message.add(abonent1Id);
        System.out.println("Call PSUD...");
        return Rows;

    }


    @RequestMapping(value = "/mwapi/service_upd_v2")
    public rows ServiceUpdateV2(@RequestParam(value = "transactionId", defaultValue = "") String transactionId,
                                @RequestParam(value = "service_account_number", defaultValue = "") String serviceAccountNumber,
                                @RequestParam(value = "service_spec_external_id", defaultValue = "") String serviceSpecExternalId,
                                @RequestParam(value = "service_state_external_id", defaultValue = "") String serviceStateExternalId,
                                @RequestParam(value = "service_available_id", defaultValue = "") String serviceAvaolableId) {
        rows Rows = new rows();
        Rows.message.add(transactionId);
        Rows.message.add(serviceAccountNumber);
        Rows.message.add(serviceSpecExternalId);
        Rows.message.add(serviceStateExternalId);
        Rows.message.add(serviceAvaolableId);
        System.out.println("Call SUV2...");
        return Rows;

    }

    public Greeting Mw1Api(@RequestParam(value = "client1ID") String abonentId,
                           @RequestParam(value = "system1ID", defaultValue = "") String systemID) {

        return new Greeting(1, abonentId);
    }

    public Greeting Mw1Api() {

        return new Greeting();
    }


    @RequestMapping(value = "/log", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public String index() {
        logger.trace("A TRACE Message");
        logger.debug("A DEBUG Message");
        logger.info("An INFO Message");
        logger.warn("A WARN Message");
        logger.error("An ERROR Message");

        return "Howdy! Check out the Logs to see the output...";
    }
}
