package main.java.com.project.httpserver;

import main.java.com.project.httpserver.problemdomain.HttpServer;

import java.io.IOException;
import java.net.ServerSocket;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        // create instance of the server class
        HttpServer server = new HttpServer(8080);
        // run server
        server.start();
    }
}