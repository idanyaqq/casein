package ru.casein.model

import org.springframework.web.multipart.MultipartFile

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id

class Document {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    MultipartFile file

}
