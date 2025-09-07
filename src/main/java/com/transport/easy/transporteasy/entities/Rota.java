package com.transport.easy.transporteasy.entities;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;
import java.util.Set;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_rota")
public class Rota implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String rua;
    private String bairro;
    private String cidade;
    private int numero;

    @ManyToOne
    @JoinColumn(name = "motorista_id")
    private Motorista motorista;

   @OneToOne(mappedBy = "rota",cascade = CascadeType.ALL)
    private Passageiro passageiro;
}