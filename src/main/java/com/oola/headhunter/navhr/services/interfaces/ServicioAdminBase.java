package com.oola.headhunter.navhr.services.interfaces;

import com.oola.headhunter.navhr.entities.Pais;
import com.oola.headhunter.navhr.services.exceptions.ServicioException;

public interface ServicioAdminBase {
    void crearPais(Pais pais) throws ServicioException;
}
