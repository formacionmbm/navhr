package com.oola.headhunter.navhr.controllers.api;

import com.oola.headhunter.navhr.entities.Pais;
import com.oola.headhunter.navhr.services.exceptions.ServicioException;
import com.oola.headhunter.navhr.services.interfaces.ServicioBuscadores;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/api/buscador/paises")
public class BuscadorPaisesRest {

    Logger log = LoggerFactory.getLogger(BuscadorPaisesRest.class);

    @Autowired
    ServicioBuscadores servicio;

    @GetMapping({"","/{nombre}"})
    public List<Pais> buscador(@PathVariable(required = false) String nombre) throws ServicioException {
        log.info("[buscador - GET /api/buscador/paises/{nombre}]");
        log.debug("[nombre:{}]", nombre);
        List<Pais> paises =servicio.buscarPaises(nombre);
        return paises;
    }
}
