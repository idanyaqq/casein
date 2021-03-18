package ru.casein.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.*
import ru.casein.model.Department
import ru.casein.service.DepartmentService

@RestController
@RequestMapping('/department')
class DepartmentController {

    @Autowired
    private DepartmentService departmentService

    @PostMapping
    Department create(@RequestBody Department department) {
        departmentService.create(department)
    }

    @GetMapping('/all')
    List<Department> getAll() {
        departmentService.getAll()
    }

    @GetMapping
    Department get(@RequestParam('id') Long id) {
        departmentService.getById(id)
    }


}
