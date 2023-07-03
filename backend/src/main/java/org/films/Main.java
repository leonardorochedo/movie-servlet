package org.films;

import org.films.servlets.UserServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;

public class Main {
    public static void main(String[] args) throws Exception {
    	Server server = new Server(8080); // HTTP Port

    	// Create a context
        ServletContextHandler context = new ServletContextHandler();
        context.setContextPath("/");
        server.setHandler(context);

        // Servlet's
        context.addServlet(new ServletHolder(new UserServlet()), "/users/*");

        server.start();
        server.join();
    }
}