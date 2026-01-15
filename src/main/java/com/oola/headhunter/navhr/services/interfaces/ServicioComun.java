package com.oola.headhunter.navhr.services.interfaces;

import com.oola.headhunter.navhr.entities.Region;
import com.oola.headhunter.navhr.services.exceptions.ServicioException;

import java.util.List;

public interface ServicioComun {
    List<Region> findAllRegions() throws ServicioException;
}
