package org.films.services;

import java.util.ArrayList;

import org.films.databases.UserDB;
import org.films.dtos.UserDTO;
import org.films.entities.User;

public class UserService {
	ArrayList<User> listOfUsers = new UserDB().getUsers();
	
	public User findUser(UserDTO user) {		
		// check if any user in list is equal to user
		for (User userList: listOfUsers) {
			UserDTO userListDTO = transformUserInUserDTO(userList);
			
			if(userListDTO.equals(user)) {
				return userList;
			}
		}
		
		return null;
	}
	
	public User getUserByIdToken(Integer id) {
		for (User userList: listOfUsers) {			
			if(userList.getId() == id) {
				return userList;
			}
		}
		
		return null;
	}
	
	// Helper's
	private UserDTO transformUserInUserDTO(User user) {
		return new UserDTO(user.getEmail(), user.getPassword());
	}
	
}
