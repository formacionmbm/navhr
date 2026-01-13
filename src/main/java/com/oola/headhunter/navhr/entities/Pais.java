package com.oola.headhunter.navhr.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name="COUNTRIES")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Pais {
    @Id
    @Column(name="COUNTRY_ID")
    private String id;

    @Column(name="COUNTRY_NAME")
    private String nombre;

    @ManyToOne
    @JoinColumn(name="REGION_ID")
    private Region region;
}

