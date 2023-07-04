package org.films.services;

import java.io.IOException;

import org.films.databases.TmdbApi;
import org.json.simple.JSONArray;

public class TmdbService {
   private TmdbApi tmdbApi = new TmdbApi();
   
   public JSONArray trendingMovies() {
      try {
         JSONArray movies = tmdbApi.searchMovies("/trending/all/week", "&language=pt-BR");
         
         return movies;
      }
      catch (IOException e) {
         e.printStackTrace();
         return null;
      }
   }
   
   public JSONArray netflixOriginalsMovies() {
      try {
         JSONArray movies = tmdbApi.searchMovies("/discover/tv", "&language=pt-BR&with_networks=213");
         
         return movies;
      }
      catch (IOException e) {
         e.printStackTrace();
         return null;
      }
   }
   
   public JSONArray topRatedMovies() {
      try {
         JSONArray movies = tmdbApi.searchMovies("/movie/top_rated", "&language=pt-BR");
         
         return movies;
      }
      catch (IOException e) {
         e.printStackTrace();
         return null;
      }
   }
   
   public JSONArray comedyMovies() {
      try {
         JSONArray movies = tmdbApi.searchMovies("/discover/tv", "&language=pt-BR&with_genres=35");
         
         return movies;
      }
      catch (IOException e) {
         e.printStackTrace();
         return null;
      }
   }
   
   public JSONArray romanceMovies() {
      try {
         JSONArray movies = tmdbApi.searchMovies("/discover/tv", "&language=pt-BR&with_genres=10749");
         
         return movies;
      }
      catch (IOException e) {
         e.printStackTrace();
         return null;
      }
   }
   
   public JSONArray documentaryMovies() {
      try {
         JSONArray movies = tmdbApi.searchMovies("/discover/tv", "&language=pt-BR&with_genres=99");
         
         return movies;
      }
      catch (IOException e) {
         e.printStackTrace();
         return null;
      }
   }
   
}
