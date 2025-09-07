package com.transport.easy.transporteasy.resource;

import com.transport.easy.transporteasy.entities.Vehicle;
import com.transport.easy.transporteasy.entitiesDTO.VehicleDTO;
import com.transport.easy.transporteasy.services.VehicleService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/vehicle")
public class VehicleResource {
    private VehicleService vehicleService;

    public VehicleResource(VehicleService vehicleService) {
        this.vehicleService = vehicleService;
    }

    @GetMapping
    public ResponseEntity<List<Vehicle>> getAllVehicles() {
        List<Vehicle> vehicles = vehicleService.getAllVehicles();
        return ResponseEntity.ok().body(vehicles);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<Vehicle> getVehicleById(@PathVariable int id) {
        Vehicle vehicle = vehicleService.getVehicleById(id);
        return ResponseEntity.ok().body(vehicle);
    }

    @PostMapping
    public ResponseEntity<Vehicle> createVehicle(@RequestBody VehicleDTO vehicle) {
        Vehicle vehicle1 = vehicleService.addVehicle(vehicle);

        return ResponseEntity.ok().body(vehicle1);
    }

    @PutMapping
    public ResponseEntity<Vehicle> updateVehicle(@PathVariable int id, @RequestBody VehicleDTO vehicle) {
        vehicle = vehicleService.update(id, vehicle);

        return (ResponseEntity<Vehicle>) ResponseEntity.ok();
    }
}
