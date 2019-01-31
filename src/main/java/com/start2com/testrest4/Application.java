/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.start2com.testrest4;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

/**
 *
 * @author burik
 */
@Configuration
@ComponentScan
@EnableAutoConfiguration
//@SpringBootApplication
public class Application {

    public static void main(String[] args) {
        System.out.println("------- START RUNNING --------");
        SpringApplication application = new SpringApplication(Application.class);
//        application.setDefaultProperties(Collections.singletonMap("server.port", "18083"));
        application.run(args);
        System.out.println("------- END RUNNING --------");
        //SpringApplication.run(Application.class, args);
    }
}
