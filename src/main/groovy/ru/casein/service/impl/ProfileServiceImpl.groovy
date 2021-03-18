package ru.casein.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service
import ru.casein.model.Profile
import ru.casein.model.ProfileRole
import ru.casein.repository.ProfileRepository
import ru.casein.service.ProfileService

@Service
class ProfileServiceImpl implements ProfileService {

    private ProfileRepository userRepository
    @Autowired
    private BCryptPasswordEncoder bCrypt;

    @Autowired
    ProfileServiceImpl(ProfileRepository userRepository) {
        this.userRepository = userRepository
    }

    @Override
    Profile save(Profile user) {
        user.setPassword(bCrypt.encode(user.password))
        user.setRoles(user.roles? user.roles :  new HashSet<ProfileRole>(){{ProfileRole.Role.USER}})
        userRepository.save(user)
    }

    @Override
    Profile update(Profile user) {
        save(user)
    }

    @Override
    Profile getById(Long id) {
        userRepository.findById(id).get()
    }

    @Override
    Set<Profile> getAll() {
        userRepository.findAll() as Set<Profile>
    }

    @Override
    void delete(long id) {
        userRepository.deleteById(id)
    }

    @Override
    Profile loadByUsername(String username) {
        def user = userRepository.loadByUsername(username)
    }

    @Override
    List<Profile> byDepartment(long depId) {
        userRepository.findByDepartmentId(depId)
    }
}