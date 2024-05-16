package main.java.com.project.httpserver.problemdomain;

import java.io.IOException;
import java.net.Socket;
import java.net.http.HttpRequest;
import java.nio.charset.StandardCharsets;


public class ResponseHandler {

    public void serverResponse(Socket clientSocket) throws IOException {
        try{
            String response = generateResponse("Pokemon");
            clientSocket.getOutputStream().write(response.getBytes("UTF-8"));

        }
        finally{
            clientSocket.close();
        }
    }


    private String generateResponse(String message){
        String response;
        // Example: Generate a simple HTML response
        String htmlResponse = "<html><body><h1>" + message + "</h1></body></html>";
        response = "HTTP/1.1 200 OK\r\nContent-Type: text/html\r\nContent-Length: " + htmlResponse.length() + "\r\n\r\n" + htmlResponse;

        return response;

    }



}
