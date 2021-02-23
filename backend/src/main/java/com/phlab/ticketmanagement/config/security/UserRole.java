package com.phlab.ticketmanagement.config.security;

import com.google.common.collect.Sets;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;

import java.util.Set;
import java.util.stream.Collectors;

import static com.phlab.ticketmanagement.config.security.UserPermission.*;

/*
 * Author: phlab
 * Date: 23/02/21
 */
public enum UserRole {

    DEFAULT(Sets.newHashSet(PROJECT_READ, TICKET_READ, USER_READ, TICKET_CREATE)),
    MANAGER(Sets.newHashSet(PROJECT_READ, TICKET_READ, USER_READ, TICKET_CREATE,
            TICKET_UPDATE, PROJECT_CREATE, PROJECT_UPDATE)),
    ADMIN(Sets.newHashSet(PROJECT_READ, TICKET_READ, USER_READ, TICKET_CREATE,
            TICKET_UPDATE, PROJECT_CREATE, PROJECT_UPDATE,
            PROJECT_DELETE, USER_WRITE, TICKET_DELETE));

    private final Set<UserPermission> permissions;

    UserRole(Set<UserPermission> permissions) {
        this.permissions = permissions;
    }

    public Set<UserPermission> getPermissions() {
        return permissions;
    }

    //UserDetails User.builder().authorities(MANAGER.getGrantedAuthotities())
    public Set<GrantedAuthority> getGrantedAuthorities(){
        Set<GrantedAuthority> permissions = getPermissions().stream()
                .map(permission -> new SimpleGrantedAuthority(permission.getPermission()))
                .collect(Collectors.toSet());
        permissions.add(new SimpleGrantedAuthority("ROLE_" + this.name()));
        return permissions;
    }
}
