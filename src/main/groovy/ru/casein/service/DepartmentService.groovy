package ru.casein.service

import ru.casein.model.Department

interface DepartmentService {

    Department create(Department department)

    List<Department> getAll()

    Department getById(Long id)
}
