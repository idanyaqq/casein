package ru.casein.model

import com.fasterxml.jackson.annotation.JsonBackReference
import com.fasterxml.jackson.annotation.JsonManagedReference

import javax.persistence.CascadeType
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.JoinTable
import javax.persistence.ManyToMany
import javax.persistence.ManyToOne
import java.time.LocalDateTime

@Entity(name = 'profile')
class Profile {
    
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String username
    String password
    String description
    @Column(name = 'creation_date')
    LocalDateTime creationDate
    @Column(name = 'last_login_date')
    LocalDateTime lastLogInDate
    @ManyToMany(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinTable(
            name = "user_roles",
            joinColumns = @JoinColumn(name = "user_id"),
            inverseJoinColumns = @JoinColumn(name = "role_id")
    )
    Set<ProfileRole> roles = new HashSet<>()

    @ManyToOne
    @JsonBackReference
    @JoinColumn(name="department_id", nullable=false)
    Department department

    String phoneNumber

    
}
