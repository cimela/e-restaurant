package com.github.cimela.e.restaurant.base.model;

import java.util.Arrays;
import java.util.Collections;
import java.util.Set;
import java.util.stream.Collectors;


public enum UserRole {
    ADMIN(10), MANAGER(8), USER(3), UNKNOWN(1);

    private int level;
    private Set<UserRole> availableRoles = Collections.emptySet();

    private UserRole(int level) {
        this.level = level;
    }

    static {
        for (UserRole userRole : UserRole.values()) {
            userRole.availableRoles = Arrays.stream(UserRole.values())
                                            .filter(role -> userRole.level >= role.level)
                                            .collect(Collectors.toSet());
        }
    }

    public static boolean checkRoleAvailable(UserRole checkedRole, UserRole baseRole) {
        return checkedRole.level >= baseRole.level;
    }

    public static Set<UserRole> getAvailableRoles(UserRole userRole) {
        return userRole.availableRoles;
    }
}
