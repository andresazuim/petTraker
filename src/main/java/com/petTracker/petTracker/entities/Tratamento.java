package com.petTracker.petTracker.entities;
import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name = "tratamentos")
public class Tratamento {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false)
    private String nome;

    private String tipo;
    private Date data_aplicacao;
    private Date proxima_aplicacao;

    @ManyToOne
    @JoinColumn(name = "animal_id", nullable = false)
    private Animal animal;
}
