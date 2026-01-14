package com.oola.headhunter.navhr.services;

import com.oola.headhunter.navhr.controllers.api.BuscadorPaisesRest;
import com.oola.headhunter.navhr.entities.Pais;
import com.oola.headhunter.navhr.repositories.PaisRepository;
import com.oola.headhunter.navhr.repositories.RegionRepository;
import com.oola.headhunter.navhr.services.exceptions.CodigoException;
import com.oola.headhunter.navhr.services.exceptions.ServicioException;
import com.oola.headhunter.navhr.services.exceptions.TipoExcepcion;
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

    //@Autowired
    PaisRepository repositorio ;


    public ServicioBuscadoresImpl(PaisRepository repositorio){
        this.repositorio=repositorio;
    }

    @Override
    public List<Pais> buscarPaises(String nombre) throws ServicioException {
        log.info("[buscarPaises]");
        log.debug("[nombre:{}]",nombre);
        try {
            if (nombre == null)
                return repositorio.findAll();
            return repositorio.findByNombre(nombre);
        }catch(Exception e){
            log.error(e.getMessage(),e);
            throw new ServicioException(e.getMessage(), TipoExcepcion.GENERAL, CodigoException.ERROR_GENERAL);
        }
    }

}
