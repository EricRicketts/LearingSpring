package com.example.model;

import com.example.services.LoggedUserManagementService;
import org.springframework.stereotype.Component;
import org.springframework.web.context.annotation.RequestScope;

@Component
@RequestScope
public class LoginProcessor {
    private final LoggedUserManagementService loggedUserManagementService;
    private String username;
    private String password;

    public LoginProcessor(
        LoggedUserManagementService loggedUserManagementService
    ) {
        this.loggedUserManagementService = loggedUserManagementService;
    }

    public String getUsername() { return username; }
    public String getPassword() { return password; }
    public void setUsername(String username) { this.username = username; }
    public void setPassword(String password) { this.password = password; }

    public boolean login() {
        boolean loginResult = false;
        String username = this.getUsername();
        String password = this.getPassword();

        if ("natalie".equals(username) && "password".equals(password)) {
            loginResult = true;
            this.loggedUserManagementService.setUsername(username);
        }

        return loginResult;
    }
}
