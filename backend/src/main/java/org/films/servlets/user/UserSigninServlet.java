package org.films.servlets.user;

import javax.json.Json;
import javax.json.JsonObject;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.films.dtos.UserDTO;
import org.films.entities.User;
import org.films.services.UserService;

import java.io.IOException;

public class UserSigninServlet extends HttpServlet {
	
    private static final long serialVersionUID = 1L;
    
    private UserService userService = new UserService();
    
	@Override
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws IOException {
        // Recieve data from params
        String email = request.getParameter("email");
        String password = request.getParameter("password");

        // Create a DTO instance
        UserDTO user = new UserDTO(email, password);
        
        // Check if user exists
        User userFinded = userService.findUser(user);
        
        if(userFinded == null) {
        	// Create a JSON Object
            JsonObject messageJson = Json.createObjectBuilder()
                    .add("message", "Preencha corretamente os campos!")
                    .build();
        	
        	response.setStatus(HttpServletResponse.SC_BAD_REQUEST);
            response.setContentType("application/json");
            response.getWriter().println(messageJson.toString());
            return;
        }
        
        // Create a JSON Object with User data
        JsonObject userJson = Json.createObjectBuilder()
        		.add("message", "Usuário logado com sucesso!")
                .add("id", userFinded.getId())
                .add("email", userFinded.getEmail())
                .add("password", userFinded.getPassword())
                .build();

        // Send response
        response.setStatus(HttpServletResponse.SC_ACCEPTED);
        response.setContentType("application/json");
        response.getWriter().println(userJson.toString());
        return;
    }
}
