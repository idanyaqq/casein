package ru.casein.controller


import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.PutMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController
import ru.casein.model.User
import ru.casein.service.UserService

@RestController
@RequestMapping(path = '/user')
class UserController {

    private def UserService userService

    @Autowired
    UserController(UserService userService) {
        this.userService = userService
    }

    @PostMapping
    User create(User user) {
        userService.save(user)
    }

    @PutMapping
    User update(User user) {
        userService.update(user)
    }

    @GetMapping(path = '/{id}')
    User getById(@PathVariable Long id) {
        userService.getById(id)
    }

    @GetMapping(path = '/all')
    Set<User> getAll() {
        userService.getAll()
    }

    @DeleteMapping(path = '/{id}')
    delete(@PathVariable Long id) {
        userService.delete(id)
    }

}
