package ru.casein.model

import groovy.transform.Canonical

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.Table

@Entity
@Table(name = 'roles')
class ProfileRole {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id

    Role role

    ProfileRole(String role) {
        this.role = Role.valueOf(role)
    }

    ProfileRole() {
    }

    enum Role {
        ADMIN('ADMIN'),
        USER('USER')
        private String value

        Role(String value) {
            this.value = value
        }
    }
}
