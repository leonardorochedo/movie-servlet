package org.films.databases;

import java.util.ArrayList;

import org.films.entities.User;

public class UserDB {
	ArrayList<User> users = new ArrayList();
	
	public UserDB() {
		User user1 = new User(1, "Leonardo Rochedo", 20, "leonardo@email.com", "123321");
	    User user2 = new User(2, "Arthur Oliveira", 10, "arthur@email.com", "123321");
	    User user3 = new User(3, "Gabriel Manoel", 8, "gabriel@email.com", "123321");
	    User user4 = new User(4, "Augusto Luengo", 35, "augusto@email.com", "123321");
	    
	    users.add(user1);
	    users.add(user2);
	    users.add(user3);
	    users.add(user4);
	}
	
	public ArrayList<User> getUsers() {
		return users;
	}
}
