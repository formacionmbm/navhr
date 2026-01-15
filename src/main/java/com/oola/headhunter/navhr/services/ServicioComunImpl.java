package com.oola.headhunter.navhr.services;

import com.oola.headhunter.navhr.controllers.PaisController;
import com.oola.headhunter.navhr.entities.Region;
import com.oola.headhunter.navhr.repositories.RegionRepository;
import com.oola.headhunter.navhr.services.exceptions.CodigoException;
import com.oola.headhunter.navhr.services.exceptions.ServicioException;
import com.oola.headhunter.navhr.services.exceptions.TipoExcepcion;
import com.oola.headhunter.navhr.services.interfaces.ServicioComun;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ServicioComunImpl implements ServicioComun {
    Logger log = LoggerFactory.getLogger(ServicioComunImpl.class);

    RegionRepository regionRepositorio;

    public ServicioComunImpl(RegionRepository regionRepositorio){
        this.regionRepositorio=regionRepositorio;
    }
    @Override
    public List<Region> findAllRegions() throws ServicioException {
        log.info("[findAllRegions]");

        try{
            return regionRepositorio.findAll();
        }catch(Exception e){
            log.error(e.getMessage(),e);
            throw new ServicioException(e.getMessage(), TipoExcepcion.GENERAL, CodigoException.ERROR_GENERAL);
        }
    }
}
