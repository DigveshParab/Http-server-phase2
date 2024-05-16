package main.java.com.project.httpserver.problemdomain;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.Socket;

public class RequestHandler {

    public void handleRequest(Socket clientSocket){
        // read request from client socket
        try {
            InputStreamReader isr = new InputStreamReader(clientSocket.getInputStream());
            BufferedReader reader = new BufferedReader(isr);

            String line = reader.readLine();
            while(line != null && !line.isEmpty())
            // 1. as long as there is data in inout stream there will be data in line
            // 2. once data from client ends line will be null hence null check
            {
                System.out.println(line);
                line = reader.readLine();
            }
            if(line == null)
            // when line is null i.e there are no more line to ready from input stream
            // this indicates connection with client has ended
            {
                System.out.println("Client connection has been closed");
            }


            // using the null check and if condition to perform some action when line is null
            // 1. indication that client connection has ended
            // 2. prevents the server from crashing
        }
        catch(IOException e){
            e.printStackTrace();
        }
    }
}
