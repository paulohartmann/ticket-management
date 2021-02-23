package com.phlab.ticketmanagement.model.payload;

import javax.validation.constraints.NotBlank;

/*
 * Author: phlab
 * Date: 23/02/21
 */

public class LoginRequest {
    @NotBlank
    private String username;

    @NotBlank
    private String password;

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
