package ru.casein.service


import ru.casein.model.Profile

interface ProfileService {

    Profile save(Profile user)

    Profile update(Profile user)

    Profile getById(Long id)

    Set<Profile> getAll()

    void delete(long id)

    Profile loadByUsername(String username)

    List<Profile> byDepartment(long aLong)

}
