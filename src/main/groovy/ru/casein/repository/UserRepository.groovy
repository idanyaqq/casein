package ru.casein.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import ru.casein.model.User

@Repository
interface UserRepository extends CrudRepository<User, Long> {
        
    @Query(value = 'select u from User u where u.username=:username')
    User loadByUsername(@Param('username') String username)
        
}
