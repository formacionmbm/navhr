package com.oola.headhunter.navhr.services.interfaces;

import com.oola.headhunter.navhr.entities.Pais;
import com.oola.headhunter.navhr.services.exceptions.ServicioException;

import java.util.List;

public interface ServicioBuscadores {
    List<Pais> buscarPaises(String nombre) throws ServicioException;
}
