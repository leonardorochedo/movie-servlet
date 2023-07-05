package org.films;

import org.films.servlets.tmbd.TmdbComedyServlet;
import org.films.servlets.tmbd.TmdbDocumentaryServlet;
import org.films.servlets.tmbd.TmdbNetflixOriginalsServlet;
import org.films.servlets.tmbd.TmdbRomanceServlet;
import org.films.servlets.tmbd.TmdbTopRatedServlet;
import org.films.servlets.tmbd.TmdbTrendingServlet;
import org.films.servlets.user.UserGetTokenServlet;
import org.films.servlets.user.UserSigninServlet;
import org.eclipse.jetty.server.Server;
import org.eclipse.jetty.servlet.FilterHolder;
import org.eclipse.jetty.servlet.ServletContextHandler;
import org.eclipse.jetty.servlet.ServletHolder;
import org.eclipse.jetty.servlets.CrossOriginFilter;

public class Main {
    public static void main(String[] args) throws Exception {
       Server server = new Server(8080); // HTTP Port

       // Create a context
       ServletContextHandler context = new ServletContextHandler();
       context.setContextPath("/");
       server.setHandler(context);
   
       // Configure CORS
       FilterHolder corsFilter = context.addFilter(CrossOriginFilter.class, "/*", null);
       corsFilter.setInitParameter(CrossOriginFilter.ALLOWED_METHODS_PARAM, "GET,POST,PUT,DELETE,HEAD,OPTIONS");
       corsFilter.setInitParameter(CrossOriginFilter.ALLOWED_ORIGINS_PARAM, "http://localhost:5173"); // React DNS
       corsFilter.setInitParameter(CrossOriginFilter.ALLOWED_HEADERS_PARAM, "X-Requested-With,Content-Type,Accept,Origin");
       
       // Servlet's
       
       // User
       context.addServlet(new ServletHolder(new UserSigninServlet()), "/auth/signin");
       context.addServlet(new ServletHolder(new UserGetTokenServlet()), "/auth/whoami");
        
       // Media
       context.addServlet(new ServletHolder(new TmdbTrendingServlet()), "/medias/trending");
       context.addServlet(new ServletHolder(new TmdbNetflixOriginalsServlet()), "/medias/netflixoriginals");
       context.addServlet(new ServletHolder(new TmdbTopRatedServlet()), "/medias/toprated");
       context.addServlet(new ServletHolder(new TmdbComedyServlet()), "/medias/comedy");
       context.addServlet(new ServletHolder(new TmdbRomanceServlet()), "/medias/romance");
       context.addServlet(new ServletHolder(new TmdbDocumentaryServlet()), "/medias/documentary");
        
       server.start();
       server.join();
    }
}