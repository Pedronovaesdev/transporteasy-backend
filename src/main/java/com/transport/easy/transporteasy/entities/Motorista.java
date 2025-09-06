package com.transport.easy.transporteasy.entities;

import com.transport.easy.transporteasy.entities.enums.StatusMotorista;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "tb_motorista")
public class Motorista implements Serializable {
    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String nome;
    private String email;
    private String telefone;

    @Enumerated(EnumType.STRING)
    private StatusMotorista status;

}
