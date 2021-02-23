package com.phlab.ticketmanagement.config.security;

/*
 * Author: phlab
 * Date: 23/02/21
 */
public enum UserPermission {

    TICKET_READ("ticket:read"),
    TICKET_CREATE("ticket:create"),
    TICKET_UPDATE("ticket:update"),
    TICKET_DELETE("ticket:delete"),
    PROJECT_READ("project:read"),
    PROJECT_CREATE("project:create"),
    PROJECT_UPDATE("project:update"),
    PROJECT_DELETE("project:delete"),
    USER_READ("user:read"),
    USER_WRITE("user:write");

    private final String permission;

    UserPermission(String permission) {
        this.permission = permission;
    }

    public String getPermission() {
        return permission;
    }
}
