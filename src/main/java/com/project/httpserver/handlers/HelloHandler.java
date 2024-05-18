package main.java.com.project.httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class HelloHandler extends BaseHandler
{

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = generateResponse("Hello World");
        sendResponse(exchange,response);
    }
}
