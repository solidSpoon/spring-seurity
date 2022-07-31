package xyz.solidspoon.sc.auth;

import java.util.Optional;

public interface ApplicationUserDao {
    public Optional<ApplicationUser> selectApplicationUserByUserName(String userName);
}
