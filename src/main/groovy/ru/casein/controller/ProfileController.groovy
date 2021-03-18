package ru.casein.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.casein.model.Profile
import ru.casein.service.ProfileService

@RestController
@RequestMapping(path = '/profile')
class ProfileController {

    private def ProfileService profileService

    @Autowired
    ProfileController(ProfileService profileService) {
        this.profileService = profileService
    }

    @PostMapping
    Profile create(@RequestBody Profile profile) {
        profileService.save(profile)
    }

    @PutMapping
    Profile update(@RequestBody Profile profile) {
        profileService.update(profile)
    }

    @GetMapping(path = '/{id}')
    Profile getById(@PathVariable Long id) {
        profileService.getById(id)
    }

    @GetMapping(path = '/all')
    Set<Profile> getAll() {
        profileService.getAll()
    }

    @DeleteMapping(path = '/{id}')
    delete(@PathVariable Long id) {
        profileService.delete(id)
    }

    @GetMapping('/byDep')
    List<Profile> getByDepartment(@RequestParam('depId')Long depId){
        profileService.byDepartment(depId)
    }

}
