package com.oola.headhunter.navhr.repositories;

import com.oola.headhunter.navhr.entities.Pais;
import com.oola.headhunter.navhr.entities.Region;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface PaisRepository extends JpaRepository<Pais,String> {

     @Query(value="SELECT C.* FROM COUNTRIES C WHERE C.NOMBRE =:nombre",nativeQuery = true)
     public List<Pais> findByNombreNative(@Param("nombre") String nombre);

     @Query("SELECT p FROM Pais p WHERE p.nombre=:nombre")
     public List<Pais> findByNombreJPQL(@Param("nombre") String nombre);

    public List<Pais> findByNombre(@Param("nombre") String nombre);
}
