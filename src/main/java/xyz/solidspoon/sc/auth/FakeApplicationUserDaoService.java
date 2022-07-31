package xyz.solidspoon.sc.auth;

import com.google.common.collect.Lists;
import lombok.RequiredArgsConstructor;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

import static xyz.solidspoon.sc.security.ApplicationUserRole.*;

@Repository("fake")
@RequiredArgsConstructor
public class FakeApplicationUserDaoService implements ApplicationUserDao {

    private final PasswordEncoder passwordEncoder;

    @Override
    public Optional<ApplicationUser> selectApplicationUserByUserName(String userName) {
        Optional<ApplicationUser> first = getApplicationUsers().stream()
                .filter(applicationUser -> userName.equals(applicationUser.getUsername()))
                .findFirst();
        return first;
    }

    private List<ApplicationUser> getApplicationUsers() {
        List<ApplicationUser> applicationUsers = Lists.newArrayList(
                ApplicationUser.builder()
                        .username("annasmith")
                        .password(passwordEncoder.encode("password"))
                        .grantedAuthorities(STUDENT.getGrantedAuthorities())
                        .isAccountNonExpired(true)
                        .isAccountNonLocked(true)
                        .isCredentialsNonExpired(true)
                        .isEnabled(true)
                        .build(),
                ApplicationUser.builder()
                        .username("linda")
                        .password(passwordEncoder.encode("password"))
                        .grantedAuthorities(ADMIN.getGrantedAuthorities())
                        .isAccountNonExpired(true)
                        .isAccountNonLocked(true)
                        .isCredentialsNonExpired(true)
                        .isEnabled(true)
                        .build(),
                ApplicationUser.builder()
                        .username("tom")
                        .password(passwordEncoder.encode("password"))
                        .grantedAuthorities(ADMINTRAINEE.getGrantedAuthorities())
                        .isAccountNonExpired(true)
                        .isAccountNonLocked(true)
                        .isCredentialsNonExpired(true)
                        .isEnabled(true)
                        .build()
        );
        return applicationUsers;
    }
}
