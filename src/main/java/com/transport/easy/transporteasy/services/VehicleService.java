package com.transport.easy.transporteasy.services;

import com.transport.easy.transporteasy.entities.Vehicle;
import com.transport.easy.transporteasy.entitiesDTO.VehicleDTO;
import com.transport.easy.transporteasy.repositories.VehicleRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class VehicleService {
    private VehicleRepository vehicleRepository;

    public VehicleService(VehicleRepository vehicleRepository) {
        this.vehicleRepository = vehicleRepository;
    }

    public Vehicle addVehicle(VehicleDTO vehicle) {
        Vehicle newVehicle = new Vehicle();

        newVehicle.setPlate(vehicle.getPlate());
        newVehicle.setModel(vehicle.getModel());
        newVehicle.setManufactures(vehicle.getManufactures());
        newVehicle.setYearManufacture(vehicle.getYearManufacture());
        newVehicle.setCapacity(vehicle.getCapacity());
        newVehicle.setStatus(vehicle.getStatus());
        newVehicle.setDateNextMaintenance(vehicle.getRegistrationDate());
        newVehicle.setKmDriven(vehicle.getKmDriven());

        vehicleRepository.save(newVehicle);
        return newVehicle;
    }

    public void removeVehicleById(int id) {
        vehicleRepository.deleteById(id);
    }

    public List<Vehicle> getAllVehicles() {
        return vehicleRepository.findAll();
    }

    public Vehicle getVehicleById(int id) {
        return vehicleRepository.findById(id)
                .orElseThrow(() -> new RuntimeException("ID NOT FULL"));
    }

    public VehicleDTO update(Integer id, VehicleDTO vehicleDTO) {
        Vehicle vehicle = vehicleRepository.findById(id).orElseThrow(() -> new RuntimeException("ID NOT FULL"));
        Vehicle newVehicle = Vehicle.builder()
                .plate(vehicleDTO.getPlate() != null ?
                        vehicleDTO.getPlate() : vehicle.getPlate())
                .model(vehicleDTO.getModel() != null ?
                        vehicleDTO.getModel() : vehicle.getModel())
                .manufactures(vehicleDTO.getManufactures() != null ?
                        vehicleDTO.getManufactures() : vehicle.getManufactures())
                .yearManufacture(vehicleDTO.getYearManufacture() != 0 ?
                        vehicleDTO.getYearManufacture() : vehicle.getYearManufacture())
                .capacity(vehicleDTO.getCapacity() != 0 ?
                        vehicleDTO.getCapacity() : vehicle.getCapacity())
                .status(vehicleDTO.getStatus() != null ?
                        vehicleDTO.getStatus() : vehicle.getStatus())
                .dateNextMaintenance(vehicleDTO.getRegistrationDate() != null ?
                        vehicleDTO.getRegistrationDate() : vehicle.getDateNextMaintenance())
                .kmDriven(vehicleDTO.getKmDriven() != 0 ?
                        vehicleDTO.getKmDriven() : vehicle.getKmDriven())
                .build();

        vehicleRepository.save(newVehicle);
        return vehicleDTO;
    }
}
