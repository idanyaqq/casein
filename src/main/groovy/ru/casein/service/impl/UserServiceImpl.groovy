package ru.casein.service.impl


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.core.GrantedAuthority
import org.springframework.security.core.authority.SimpleGrantedAuthority
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Service
import ru.casein.model.Role
import ru.casein.model.User
import ru.casein.repository.UserRepository
import ru.casein.service.UserService

@Service
class UserServiceImpl implements UserService {

    private UserRepository userRepository

    @Autowired
    UserServiceImpl(UserRepository userRepository) {
        this.userRepository = userRepository
    }

    @Override
    User save(User user) {
        userRepository.save(user)
    }

    @Override
    User update(User user) {
        userRepository.save(user)
    }

    @Override
    User getById(Long id) {
        userRepository.findById(id).get()
    }

    @Override
    Set<User> getAll() {
        userRepository.findAll() as Set<User>
    }

    @Override
    delete(long id) {
        userRepository.deleteById(id)
    }

    @Override
    UserDetails loadByUsername(String username) {
        def user = userRepository.loadByUsername(username)
        

}
