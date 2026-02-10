package com.oola.headhunter.navhr.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
@RequestMapping({"/","/public"})
public class PublicController {

    @GetMapping
    public String getInicio(){
        log.info("[getInicio]");

        return "public/inicio";
    }
}
