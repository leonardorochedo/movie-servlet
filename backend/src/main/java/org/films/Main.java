package org.films;

import org.films.entities.User;

public class Main {
    public static void main(String[] args) {
    	// Create users
        User user1 = new User(1, "Leonardo Rochedo", 20, "leonardo@email.com", "123321");
        User user2 = new User(2, "Arthur Oliveira", 10, "arthur@email.com", "123321");
        User user3 = new User(3, "Gabriel Manoel", 8, "gabriel@email.com", "123321");
    }
}