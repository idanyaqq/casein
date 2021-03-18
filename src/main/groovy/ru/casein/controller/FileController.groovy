package ru.casein.controller

import org.springframework.beans.factory.annotation.Autowired
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController
import org.springframework.web.multipart.MultipartFile
import ru.casein.service.FileService

@RestController
@RequestMapping('/file')
class FileController {

    @Autowired
    FileService fileService

    @PostMapping('/uploadFile')
    public String submit(@RequestParam("file") MultipartFile file) {
        int a  = 0
    }

}
