package main.java.com.project.httpserver.handlers;

import com.sun.net.httpserver.HttpExchange;
import com.sun.net.httpserver.HttpHandler;

import java.io.IOException;
import java.io.OutputStream;

// if this class is not made abstract then we'll have to implement the methods in the interface HttpHandler
public abstract class BaseHandler implements HttpHandler
{
    // it is made protected coz only the class that inherits this class will be able to use its methods
    protected void sendResponse(HttpExchange exchange, String response) throws IOException
    {
        // send http response header to client
        exchange.sendResponseHeaders(200,response.getBytes().length);

        // accessing response body of the current request
        // this method is used to get the output stream that allows to write data to the response body of the current request
        // output stream - where we write the content that is to be sent to client
        OutputStream os = exchange.getResponseBody();

        // writing to output
        os.write(response.getBytes());
        // close the stream
        os.close();
    }

    protected String generateResponse(String message)
    {
        String response = "<html><body><h1>"+ message +"</h1></body></html>";
        return response;
    }
}


// HttpExchange is a class that can be used to access the details of incoming request