package ru.casein.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import com.fasterxml.jackson.annotation.JsonManagedReference

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.OneToMany

@Entity
class Department {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String name
    @OneToMany(mappedBy = 'department')
    @JsonManagedReference
    Set<Profile> profiles
}
