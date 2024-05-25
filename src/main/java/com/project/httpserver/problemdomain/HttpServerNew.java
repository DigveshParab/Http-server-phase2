package main.java.com.project.httpserver.problemdomain;

import com.sun.net.httpserver.HttpServer;
import main.java.com.project.httpserver.handlers.*;
import main.java.com.project.httpserver.handlers.MailHandler;

import java.io.IOException;
import java.net.InetSocketAddress;

public class HttpServerNew {
    private final int port;
    private final HttpServer server;

    // most of the settings and configurations that are required for the server are to be implemented in constructor itself
    // as whenever the class loads constructor makes the configuration as the very first task
    public HttpServerNew(int port) throws IOException {
        this.port = port;
        this.server = HttpServer.create(new InetSocketAddress(port), 0);

        // creating context
        createContextRoutes(server);

        // setting executor
        setExecutor(server);
    }

    // helper functions
    private void createContextRoutes(HttpServer server){
        server.createContext("/", new RootHandler());
        server.createContext("/hello", new HelloHandler());
        server.createContext("/goodbye", new GoodbyeHandler());
        server.createContext("/employee", new EmployeeHandler());
        server.createContext("/item", new ItemHandler());
        server.createContext("/mail", new MailHandler());
        server.createContext("/db", new DatabaseHandler());

    }

    private void setExecutor(HttpServer server){
        // when executor is set to null which is a default setting
        // by default server will create a new thread for each request that comes to the server
        // this is inorder to ensure concurrency of the requests
        // resource efficiency and thread management
        server.setExecutor(null);
    }


//    logical functions
    public void start(){
        this.server.start();
        System.out.println("Server started on port " + this.port);
    }

    public void stop(){
        // by setting delay we can specify a delay before stopping the server
        // 1. inorder to give server some time to process ongoing requests
        // 2. give time for clean-up operations or shutdown tasks
        this.server.stop(0);
    }
}
