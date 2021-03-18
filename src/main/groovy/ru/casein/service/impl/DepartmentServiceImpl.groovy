package ru.casein.service.impl

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import org.springframework.web.client.HttpClientErrorException
import ru.casein.model.Department
import ru.casein.repository.DepartmentRepository
import ru.casein.service.DepartmentService

@Service
class DepartmentServiceImpl implements DepartmentService {

    @Autowired
    private DepartmentRepository repository

    @Override
    Department create(Department department) {
        repository.save(department)
    }

    @Override
    List<Department> getAll() {
        repository.findAll()
    }

    @Override
    Department getById(Long id) {
        repository.findById(id).orElseThrow(HttpClientErrorException.BadRequest::new)
    }
}
