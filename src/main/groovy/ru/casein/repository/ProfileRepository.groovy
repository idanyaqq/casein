package ru.casein.repository

import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.CrudRepository
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository
import ru.casein.model.Profile

@Repository
interface ProfileRepository extends CrudRepository<Profile, Long> {
        
    @Query(value = 'select p from profile p where p.username=:username')
    Profile loadByUsername(@Param('username') String username)

    List<Profile> findByDepartmentId(@Param('departmentId')Long departmentId)
        
}
