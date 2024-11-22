package com.javarush;

import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.SerializationFeature;
import com.javarush.controller.IndexController;
import com.javarush.controller.MessageController;
import com.javarush.repository.MessageRepository;
import com.javarush.service.MessageService;
import com.sun.net.httpserver.HttpHandler;
import com.sun.net.httpserver.HttpServer;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.util.Map;

public class HttpStarter {

    public static void main(String[] args) throws IOException {

        int port = 1234;
        InetSocketAddress addr = new InetSocketAddress(port);
        HttpServer httpServer = HttpServer.create(addr, 0);

        ObjectMapper objectMapper = new ObjectMapper()
                .enable(SerializationFeature.INDENT_OUTPUT);
        MessageRepository repository = new MessageRepository();
        MessageService messageService = new MessageService(repository);
        Map<String, HttpHandler> controllerMap = Map.of(
                "/", new IndexController(),
                "/messages/", new MessageController(objectMapper, messageService)
        );
        controllerMap.forEach(httpServer::createContext);
        httpServer.start();
    }
}