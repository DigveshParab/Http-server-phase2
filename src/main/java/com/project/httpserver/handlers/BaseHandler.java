package main.java.com.project.httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.*;

// if this class is not made abstract then we'll have to implement the methods in the interface HttpHandler
public abstract class BaseHandler implements HttpHandler
{
    // inorder to make our server handle different requests we will override the handle() method from Httphandler here instead of individual handlers

    @Override
    public void handle(HttpExchange exchange) throws IOException {
        // this will return the Method type
        String method = exchange.getRequestMethod();
        switch (method){
            case "GET":
                 handleGet(exchange);
                 break;
            case "POST":
                handlePost(exchange);
                break;
            case "PUT":
                handlePut(exchange);
                break;
            case "DELETE":
                handleDelete(exchange);
                break;
            default:
                sendResponse(exchange,"Unsupported HTTP method",405);
        }
    }


    // initially these methods wont have much we will override them in individual handlers
    abstract protected  void handleDelete(HttpExchange exchange) throws IOException;

    abstract protected void handlePut(HttpExchange exchange) throws IOException;

    abstract protected void handlePost(HttpExchange exchange) throws IOException;

    abstract protected void handleGet(HttpExchange exchange) throws IOException;


    // it is made protected coz only the class that inherits this class will be able to use its methods
    protected void sendResponse(HttpExchange exchange, String response,int statusCode) throws IOException
    {
        // send http response header to client
        exchange.sendResponseHeaders(statusCode,response.getBytes().length);

        // accessing response body of the current request
        // this method is used to get the output stream that allows to write data to the response body of the current request
        // output stream - where we write the content that is to be sent to client
        OutputStream os = exchange.getResponseBody();

        // writing to output
        os.write(response.getBytes());
        // close the stream
        os.close();
    }

    // method to handle sending JSON data
    protected void sendJsonResponse(HttpExchange exchange,String jsonResponse,int StatusCode) throws IOException{
        exchange.getResponseHeaders().set("Content-Type", "application/json");
        exchange.sendResponseHeaders(StatusCode,jsonResponse.getBytes().length);
        OutputStream os = exchange.getResponseBody();
        os.write(jsonResponse.getBytes());
        os.close();
    }

    // function to handle sending image data




    protected String generateResponse(String message)
    {
        String response = "<html><body><h1>"+ message +"</h1></body></html>";
        return response;
    }


}


// HttpExchange is a class that can be used to access the details of incoming request