package ru.hogwarts.school.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Profile;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


@RestController
@RequestMapping("/getPort")
//@Profile("Production")
public class InfoController {
    @Value("${local.server.port}")
    private Integer port;

    @GetMapping
    public Integer getPort() {
        return port;
    }
}
