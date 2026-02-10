package com.oola.headhunter.navhr.controllers;

import com.oola.headhunter.navhr.entities.Pais;
import com.oola.headhunter.navhr.services.exceptions.ServicioException;
import com.oola.headhunter.navhr.services.interfaces.ServicioBuscadores;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/buscador/paises")
public class BuscadorPaisesController {
    Logger log = LoggerFactory.getLogger(BuscadorPaisesController.class);

    @Autowired
    ServicioBuscadores servicio;

    @RequestMapping
    public String buscador(@RequestParam(required = false) String nombre, Model model) throws ServicioException {
        log.info("[buscador]");
        List<Pais> paises = servicio.buscarPaises(nombre);

        model.addAttribute("listado",paises);
        log.debug("[msg:{}",model.getAttribute("msg"));

        return "buscadores/t_b_paises";

    }
}
