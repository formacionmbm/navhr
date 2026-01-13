package com.oola.headhunter.navhr.repositories;

import com.oola.headhunter.navhr.services.ServicioBuscadoresImpl;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PaisRepositoryTest {
    Logger log = LoggerFactory.getLogger(PaisRepositoryTest.class);

    @Autowired
    PaisRepository repositorio;

    @BeforeEach
    void antesDeCadaTest(){
        log.info("[antesDeCadaTest]");
    }

    @Test
    void findByNombre_ok() {
        log.info("[findByNombre_ok]");
        assertEquals("AU",repositorio.findByNombre("Australia").get(0).getId());
        assertEquals(1,repositorio.findByNombre("Australia").size());

    }

    @Test
    void findByNombre_ko() {
        log.info("[findByNombre_ko]");
        assertEquals(0,repositorio.findByNombre("XX").size());
    }

    @AfterEach
    void despuesDeCadaTest(){
        log.info("[despuesDeCadaTest]");
    }
}