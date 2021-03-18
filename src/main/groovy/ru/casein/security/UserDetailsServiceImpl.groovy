package ru.casein.security

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.User
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.security.core.userdetails.UsernameNotFoundException
import org.springframework.stereotype.Component
import ru.casein.model.ProfileRole
import ru.casein.repository.ProfileRepository

@Component
class UserDetailsServiceImpl implements UserDetailsService {

    private ProfileRepository repository

    @Autowired
    UserDetailsServiceImpl(ProfileRepository repository) {
        this.repository = repository
    }

    @Override
    UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        def user = repository.loadByUsername(username)
        new User(
                user.username, user.getPassword(), getAuthorities(user.roles))
    }

    private static Collection<? extends GrantedAuthority> getAuthorities(Collection<ProfileRole> roles) {
        roles.collect { new SimpleGrantedAuthority(it.role.name()) }
    }

}
