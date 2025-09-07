package com.transport.easy.transporteasy.entities;

import com.transport.easy.transporteasy.entities.enums.StatusVehicle;
import jakarta.persistence.*;
import lombok.*;

import java.time.LocalDate;

@AllArgsConstructor
@Getter
@Setter
@NoArgsConstructor
@Entity
@Builder
@Table(name = "tb_vehicle")
public class Vehicle {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id_vehicle;
    private String plate;
    private String model;
    private String manufactures;
    private int yearManufacture;
    private int capacity;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private StatusVehicle status;

    private LocalDate dateNextMaintenance;

    private int kmDriven;

    @OneToOne
    private Motorista motorista;
}


