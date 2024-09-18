package org.xuaxpedia.simplewebserver;

import com.sun.net.httpserver.HttpServer;
import com.sun.net.httpserver.SimpleFileServer;
import java.net.InetSocketAddress;
import java.nio.file.Path;

// The new API offers a basic HTTP server for quick testing and rapid web application development without
// a full setup. It's useful for prototyping but does not support HTTP/2 or HTTPS, so servers like Apache
// Tomcat or Jetty are recommended for applications that need greater security and advanced features.

public class SimpleWebServer {

    public static void main(String[] args) {

        InetSocketAddress address = new InetSocketAddress(8080);
        Path basePath = Path.of("").toAbsolutePath(); // Gets the current working directory
        Path resourcePath = basePath.resolve("src").resolve("main").resolve("resources");
        HttpServer server = SimpleFileServer.createFileServer(address, resourcePath, SimpleFileServer.OutputLevel.VERBOSE);
        System.out.println("Open the following address in a browser: http://127.0.0.1:8080/");
        server.start();

    }

}