package com.transport.easy.transporteasy.repositories;

import com.transport.easy.transporteasy.entities.Motorista;
import com.transport.easy.transporteasy.entitiesDTO.MotoristaDTO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MotoristaRepository extends JpaRepository<Motorista, Long> {
    List<MotoristaDTO> findyByStatus(String status);
}
