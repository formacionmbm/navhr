package com.oola.headhunter.navhr.controllers;

import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@Slf4j
public class LoginController {

    @GetMapping("/login")
    public String irLogin(){
        log.info(("[irLogin]"));
        return "login.html";
    }

//    @PostMapping("/login")
//    public String irPaginaInicio(){
//        log.info(("[irPaginaInicio]"));
//        return "redirect:/buscador/paises";
//    }

    @RequestMapping("/loginError")
    public String irLoginError(Model model){
        log.info(("[irLoginError]"));
        model.addAttribute("error","No te has logado");
        return "login.html";
    }
}
