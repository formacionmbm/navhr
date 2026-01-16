package com.oola.headhunter.navhr.controllers;

import com.oola.headhunter.navhr.controllers.api.BuscadorPaisesRest;
import com.oola.headhunter.navhr.controllers.common.CodigoMensajes;
import com.oola.headhunter.navhr.entities.Pais;
import com.oola.headhunter.navhr.entities.Region;
import com.oola.headhunter.navhr.services.exceptions.ServicioException;
import com.oola.headhunter.navhr.services.interfaces.ServicioAdminBase;
import com.oola.headhunter.navhr.services.interfaces.ServicioComun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import java.util.ArrayList;
import java.util.List;

@Controller
@RequestMapping("/admin/pais")
public class PaisController {
    Logger log = LoggerFactory.getLogger(PaisController.class);


    @Autowired
    ServicioComun servicioComun;

    @Autowired
    ServicioAdminBase servicio;

    @GetMapping
    public String irFormularioCreacion(Model model) throws ServicioException {
        log.info("[irFormularioCreacion]");
        List<Region> regiones = servicioComun.findAllRegions();

        log.debug(regiones.toString());
        model.addAttribute("regiones",regiones);
        return "admin/t_pais";
    }

    @PostMapping
    public String crear(Pais pais, RedirectAttributes redirectAttributes) throws ServicioException{
        log.info("[crear]");
        log.debug("[pais:{}]",pais);

        servicio.crearPais(pais);

        redirectAttributes.addFlashAttribute("msg", CodigoMensajes.CREAR_PAIS_OK); //"MSG_05_001"
        log.debug("[mensaje:{},codigo:{}",CodigoMensajes.CREAR_PAIS_OK,CodigoMensajes.CREAR_PAIS_OK.getCodigo());

        return "redirect:/buscador/paises"; //CUIDADIN PORQUE ES UNA PETICION POST @PostMapping

    }


}
