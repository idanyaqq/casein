package ru.casein.repository

import org.springframework.data.repository.CrudRepository
import org.springframework.stereotype.Repository
import ru.casein.model.Department

@Repository
interface DepartmentRepository extends  CrudRepository<Department,Long> {

}