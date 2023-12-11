/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package edu.neu.csye6200;

/**
 *
 * @author Admin
 */
import java.util.HashMap;
import java.util.Map;

public class UserService {
    private Map<String, User> users;

    public UserService() {
        users = new HashMap<>();
        String adminSalt = SecurityUtils.generateSalt();
        String doctorSalt = SecurityUtils.generateSalt();
        String patientSalt = SecurityUtils.generateSalt();
        users.put("admin", new User("admin", SecurityUtils.hashPassword("admin123", adminSalt), adminSalt, "admin"));
        users.put("doctor", new User("doctor", SecurityUtils.hashPassword("doc123", doctorSalt), doctorSalt, "doctor"));
        users.put("patient", new User("patient", SecurityUtils.hashPassword("pat123", patientSalt), patientSalt, "patient"));
    }

    public User authenticateUser(String username, String password) throws AuthenticationException {
        User user = users.get(username);
        if (user != null && user.checkPassword(password)) {
            return user;
        }
        throw new AuthenticationException("Invalid username or password");
    }

    public boolean authorizeUser(User user, String requiredRole) {
        return user != null && user.getRole().equals(requiredRole);
    }
}


