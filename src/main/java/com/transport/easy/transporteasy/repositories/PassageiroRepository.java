package com.transport.easy.transporteasy.repositories;

import com.transport.easy.transporteasy.entities.Passageiro;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface PassageiroRepository extends JpaRepository<Passageiro, Long> {
}
