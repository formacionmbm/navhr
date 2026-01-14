package com.oola.headhunter.navhr.services;

import com.oola.headhunter.navhr.entities.Pais;
import com.oola.headhunter.navhr.entities.Region;
import com.oola.headhunter.navhr.repositories.PaisRepository;
import com.oola.headhunter.navhr.services.exceptions.CodigoException;
import com.oola.headhunter.navhr.services.exceptions.ServicioException;
import com.oola.headhunter.navhr.services.exceptions.TipoExcepcion;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.ArrayList;
import java.util.List;


import static org.junit.jupiter.api.Assertions.*;
import static org.mockito.Mockito.*;


@ExtendWith(MockitoExtension.class)
class ServicioBuscadoresImplTest {

    @Mock
    private PaisRepository repositorio;

    @InjectMocks
    private ServicioBuscadoresImpl servicio;

    private List<Pais> paises= List.of(new Pais(), new Pais());



    @Test
    void buscarPaises_nombre_null_ok() throws ServicioException {

        when(repositorio.findAll()).thenReturn(paises);

        assertNotNull(servicio.buscarPaises(null));
        assertEquals(2, servicio.buscarPaises(null).size());

        verify(repositorio, times(1)).findAll();
        verify(repositorio, never()).findByNombre(anyString());
    }



    @Test
    void buscarPaises_ok() throws ServicioException {
        String nombre = "XXX";
        when(repositorio.findByNombre(nombre)).thenReturn(paises);


        assertNotNull(servicio.buscarPaises(nombre));
        assertEquals(2, servicio.buscarPaises(nombre).size());
        verify(repositorio, times(1)).findByNombre(nombre);
        verify(repositorio, never()).findAll();
    }

    @Test
    void buscarPaises_ko() {

        when(repositorio.findAll()).thenThrow(new RuntimeException("Error BD"));

        // when / then
        ServicioException exception = assertThrows(
                ServicioException.class,
                () -> servicio.buscarPaises(null)
        );

        assertInstanceOf(ServicioException.class,exception);
        assertEquals("Error BD", exception.getMessage());
        assertEquals(TipoExcepcion.GENERAL, exception.getTipo());
        assertEquals(CodigoException.ERROR_GENERAL, exception.getCodigo());
        verify(repositorio, times(1)).findAll();
    }
}