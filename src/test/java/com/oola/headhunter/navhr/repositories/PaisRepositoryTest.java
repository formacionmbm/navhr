package com.oola.headhunter.navhr.repositories;

import com.oola.headhunter.navhr.entities.Pais;
import com.oola.headhunter.navhr.entities.Region;
import com.oola.headhunter.navhr.services.ServicioBuscadoresImpl;
import org.junit.jupiter.api.*;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.data.jpa.test.autoconfigure.DataJpaTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest
class PaisRepositoryTest {
  private static Logger log = LoggerFactory.getLogger(PaisRepositoryTest.class);

    @Autowired
    PaisRepository repositorio;

    @BeforeAll
    static void antesDeTodos(){
        log.info("[antesDeTodos]");
    }

    @BeforeEach
    void antesDeCadaTest(){
        log.info("[antesDeCadaTest]");
        Pais pais = new Pais("ES","España",new Region(1,""));
        repositorio.save(pais);
    }

    @Test
    void findByNombre_ok() {
        log.info("[findByNombre_ok]");
        assertEquals("ES",repositorio.findByNombre("España").get(0).getId());
        assertEquals(1,repositorio.findByNombre("España").size());

    }

    @Test
    @DisplayName("encontrar por nombre - fallido")
    void findByNombre_ko() {
        log.info("[findByNombre_ko]");
        assertEquals(0,repositorio.findByNombre("XX").size());
    }


    @ParameterizedTest
    @ValueSource(ints = { 1, 2, 3 })
    void countByRegion_ok(int region_id) {
        log.info("[countByRegion_ok]");
        Region region=new Region(region_id,"");
        List<Pais> paises= repositorio.findAll();
        long num_pais= paises.stream().filter(p -> p.getRegion().getId()==region_id).count(); //PASAR INTERFAZ STREAM - LAMBDAS
        assertEquals(num_pais,repositorio.countByRegion(region));
    }

    @Test
    void countByRegion_ko() {
        log.info("[countByRegion_ko]");
        Region region=new Region(0,"");
        assertEquals(0,repositorio.countByRegion(region));
    }

    @AfterEach
    void despuesDeCadaTest(){
        log.info("[despuesDeCadaTest]");
    }
    @AfterAll
    static void despuesDeTodos(){
        log.info("[despuesDeTodos]");
    }
}