package com.oola.headhunter.navhr.services;

import com.oola.headhunter.navhr.controllers.api.BuscadorPaisesRest;
import com.oola.headhunter.navhr.entities.Pais;
import com.oola.headhunter.navhr.repositories.PaisRepository;
import com.oola.headhunter.navhr.services.interfaces.ServicioBuscadores;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioBuscadoresImpl implements ServicioBuscadores {

    Logger log = LoggerFactory.getLogger(ServicioBuscadoresImpl.class);

    @Autowired
    PaisRepository repositorio ;

    @Override
    public List<Pais> buscarPaises(String nombre) {
        log.info("[buscarPaises]");
        if(nombre==null)
            return repositorio.findAll();
        return repositorio.findByNombre(nombre);
    }
}
