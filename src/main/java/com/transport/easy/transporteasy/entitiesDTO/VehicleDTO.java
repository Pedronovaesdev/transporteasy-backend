package com.transport.easy.transporteasy.entitiesDTO;

import com.transport.easy.transporteasy.entities.enums.StatusVehicle;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class VehicleDTO {
    private Long id_vehicle;
    private String plate;
    private String model;
    private String manufactures;
    private int yearManufacture;
    private int capacity;
    private StatusVehicle status;
    private LocalDate registrationDate;
    private int kmDriven;
    private MotoristaDTO motorista;
}
