package ru.casein.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import ru.casein.model.Role
import ru.casein.service.UserService

@Component
class UserDetailsServiceImpl implements UserDetailsService {
    
    private UserService userService
    
    @Autowired
    UserDetailsServiceImpl(UserService userService) {
        this.userService = userService
    }

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        def user = userService.loadByUsername(username)
        new User(
                user.username, user.getPassword(), getAuthorities(user.roles));
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Collection<Role> roles) {
        roles.collect { new SimpleGrantedAuthority(it.name()) }
    }

}
