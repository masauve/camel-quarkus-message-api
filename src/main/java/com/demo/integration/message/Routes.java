package com.demo.integration.message;

import javax.enterprise.context.ApplicationScoped;

import org.apache.camel.builder.RouteBuilder;

@ApplicationScoped
public class Routes extends RouteBuilder {

    @Override
    public void configure() throws Exception {

        getContext().setManagementName("MessageAPI");
        rest("/get")
        .get()
        .route()
        .log("Message API called!")
        .setBody(simple("SELECT * from messages"))
        .to("jdbc:camel").marshal().json();
       }
}