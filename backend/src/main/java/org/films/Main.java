package org.films;

import org.films.servlets.tmbd.TmdbComedyServlet;
import org.films.servlets.tmbd.TmdbDocumentaryServlet;
import org.films.servlets.tmbd.TmdbNetflixOriginalsServlet;
import org.films.servlets.tmbd.TmdbRomanceServlet;
import org.films.servlets.tmbd.TmdbTopRatedServlet;
import org.films.servlets.tmbd.TmdbTrendingServlet;
import org.films.servlets.user.UserSigninServlet;
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
       
       // User
       context.addServlet(new ServletHolder(new UserSigninServlet()), "/auth/signin");
        
       // Movie
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