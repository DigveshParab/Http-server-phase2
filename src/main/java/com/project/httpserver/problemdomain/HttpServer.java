package main.java.com.project.httpserver.problemdomain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.Date;

public class HttpServer {
    private final int port;
    private ServerSocket server; // not constant as is a mutable object that needs to be instantiated and closed during the lifecycle of the server.
    private final RequestHandler requestHandler;
    private final ResponseHandler responseHandler;

    public HttpServer(int port) {
        this.port = port;
        this.requestHandler = new RequestHandler();
        this.responseHandler = new ResponseHandler();
    }

    // method to start the server
    public void start(){
        try{
            // create a server socket
            server = new ServerSocket(port);


            // server displaying message
            System.out.println("Server Listening on port " + port);

            // keep the server running forever
            // without this our program will execute and once done executing server will shut down
            while(true){
                // this is responsible for accepting client calls to the server
                // this return a socket instance that represents connection with the client
                // with just the while(true){} our server just listens to requests
                Socket clientSocket = server.accept();

                // accepts request here
                requestHandler.handleRequest(clientSocket); // with this our server now accepts requests

                // respond to the client request
                try{
                    responseHandler.serverResponse(clientSocket);
                }catch(IOException e){
                    e.printStackTrace();
                }
            }

        }catch(IOException e){
            e.printStackTrace();
        }
    }

    // method to stop the server
    public void stop(){
        try{
            // check if server is already closed or the var is null
            if(server != null && !server.isClosed()){
                server.close();
            }
        }catch(IOException e){
            e.printStackTrace();
        }
    }

}

// we follow the following steps whenever a client makes a call
// 1. read the HTTP request from the client
// 2. prepare appropriate response
// 3. send the response to the client
// 4. close the socket with the client

// NOTE: server does not have to remember its previous cliet connection


// ServerSocket(port)
// 1. it implements a socket that can be used to listen to and accept client connections.
// 2. it establishes a port (can be specified) where it waits for connection with clients.