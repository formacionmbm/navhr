package com.oola.headhunter.navhr.controllers;

import com.oola.headhunter.navhr.controllers.api.BuscadorPaisesRest;
import com.oola.headhunter.navhr.entities.Region;
import com.oola.headhunter.navhr.services.exceptions.ServicioException;
import com.oola.headhunter.navhr.services.interfaces.ServicioComun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/pais")
public class PaisController {
    Logger log = LoggerFactory.getLogger(PaisController.class);


    @Autowired
    ServicioComun servicioComun;

    @GetMapping
    public String irFormularioCreacion(Model model) throws ServicioException {
        log.info("[irFormularioCreacion]");
        List<Region> regiones = servicioComun.findAllRegions();

        log.debug(regiones.toString());
        model.addAttribute("regiones",regiones);
        return "admin/t_pais";
    }
}
