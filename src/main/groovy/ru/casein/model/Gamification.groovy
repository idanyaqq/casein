package ru.casein.model

import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.GenerationType
import javax.persistence.Id


class Gamification {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    Long id
    String title
    List<Document> documents

}
