package main.java.com.project.httpserver;
import main.java.com.project.httpserver.problemdomain.HttpServerNew;
import java.io.IOException;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) throws IOException {

        // create instance of the server class
         HttpServerNew server = new HttpServerNew(8080);
        // run server
        server.start();
    }
}



// next agenda
// 1. change response based on different url ✅
// 2. handle GEt|POST|PUT|DELETE requests in the code ✅
// 3. handle different data types as response text✅|JSON✅|docs|images|videos|html
// - - create dummy data and apply these methods ✅
// 4. accept different data types as params text✅|int✅
// accept data from response body and perform DRUD operations ✅

// 5. send mail when specific url is hit ✅
// 6. connect to database  ✅
// related operations
// +. connect with frontend
// +. using threads to handle multiple clients ✅
