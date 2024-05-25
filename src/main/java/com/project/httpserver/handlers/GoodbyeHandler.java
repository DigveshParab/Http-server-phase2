package main.java.com.project.httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;

import java.io.IOException;

public class GoodbyeHandler extends BaseHandler
{

    // since handle() method is implemented in the parent class i.e BaseHandler
    // we no longer need to separately handle it here as it is inherited
//    @Override
//    public void handle(HttpExchange exchange) throws IOException {
//        String response = generateResponse("Goodbye Mates.");
//        sendResponse(exchange,response,200);
//    }

    // we OVERRIDE each method form the parent class as per to individual handlers need
    @Override
    protected void handleDelete(HttpExchange exchange) throws IOException {
        String response = generateResponse("Goodbye Mates (DELETE)");
        sendResponse(exchange,response,200);
    }

    @Override
    protected void handlePut(HttpExchange exchange) throws IOException {
        String response = generateResponse("Goodbye Mates. (PUT)");
        sendResponse(exchange,response,200);
    }

    @Override
    protected void handlePost(HttpExchange exchange) throws IOException {
        String response = generateResponse("Goodbye Mates. (POST)");
        sendResponse(exchange,response,200);
    }

    @Override
    protected void handleGet(HttpExchange exchange) throws IOException {
        String response = generateResponse("Goodbye Mates. (GET)");
        sendResponse(exchange,response,200);
    }
}
