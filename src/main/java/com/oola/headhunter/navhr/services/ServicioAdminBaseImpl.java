package com.oola.headhunter.navhr.services;

import com.oola.headhunter.navhr.controllers.PaisController;
import com.oola.headhunter.navhr.entities.Pais;
import com.oola.headhunter.navhr.repositories.PaisRepository;
import com.oola.headhunter.navhr.services.exceptions.CodigoException;
import com.oola.headhunter.navhr.services.exceptions.ServicioException;
import com.oola.headhunter.navhr.services.exceptions.TipoExcepcion;
import com.oola.headhunter.navhr.services.interfaces.ServicioAdminBase;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class ServicioAdminBaseImpl implements ServicioAdminBase {

    PaisRepository repositorio;

    //Inyeccion por constructor
    public ServicioAdminBaseImpl(PaisRepository repositorio){
       this.repositorio=repositorio;
    }

    @Override
    public void crearPais(Pais pais) throws ServicioException {
        log.info("[crearPais]");
        log.debug("[pais:{}]",pais);

        try{
            validar(pais);
            repositorio.save(pais);
        }catch(Exception e){
            log.error(e.getMessage(),e);
            throw new ServicioException(e.getMessage(), TipoExcepcion.GENERAL, CodigoException.ERROR_GENERAL);
        }
    }

    private void validar(Pais pais) throws ServicioException{
        //TODO aumentar la validacion
    }
}
