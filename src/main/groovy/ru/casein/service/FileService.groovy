package ru.casein.service

import org.springframework.web.multipart.MultipartFile

interface FileService {

    def upload(MultipartFile multipartFile)

}