package ru.casein.service


import ru.casein.model.User

interface UserService {

    User save(User user)

    User update(User user)

    User getById(Long id)

    Set<User> getAll()

    void delete(long id)

    User loadByUsername(String username)
}
