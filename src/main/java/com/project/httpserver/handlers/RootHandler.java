package main.java.com.project.httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class RootHandler extends BaseHandler
{
    @Override
    public void handle(HttpExchange exchange) throws IOException {
        String response = generateResponse("welcome to my server.");
        sendResponse(exchange,response);
    }
}
