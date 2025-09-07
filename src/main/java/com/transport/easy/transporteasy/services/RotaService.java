package com.transport.easy.transporteasy.services;

import com.transport.easy.transporteasy.entities.Motorista;
import com.transport.easy.transporteasy.entities.Rota;
import com.transport.easy.transporteasy.entitiesDTO.MotoristaDTO;
import com.transport.easy.transporteasy.entitiesDTO.RotaDTO;
import com.transport.easy.transporteasy.repositories.RotaRepository;
import com.transport.easy.transporteasy.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class RotaService {

    @Autowired
    private RotaRepository rotaRepository;


    public List<RotaDTO> findAll(){
        List<Rota> rotas = rotaRepository.findAll();

        List<RotaDTO> rotaDTOS = rotas.stream()
                .map(entidade -> new RotaDTO(entidade))
                .collect(Collectors.toList());

        return rotaDTOS;
    }

    public RotaDTO findById(Long id){
        Optional<Rota> rota = rotaRepository.findById(id);

        Rota entidade = rota.orElseThrow(()-> new ResourceNotFoundException("rota nao encontrado"));

        return new RotaDTO(entidade);
    }

    public RotaDTO create(RotaDTO dto) {

        Rota entidade = new Rota();
        entidade.setRua(dto.getRua());
        entidade.setBairro(dto.getBairro());
        entidade.setCidade(dto.getCidade());
        entidade.setNumero(dto.getNumero());

        entidade = rotaRepository.save(entidade);

        return new RotaDTO(entidade);
    }


    public RotaDTO update(Long id, RotaDTO dto) {
         Rota entidade = rotaRepository.getReferenceById(id);
         entidade.setRua(dto.getRua());
         entidade.setBairro(dto.getBairro());
         entidade.setCidade(dto.getCidade());
         entidade.setNumero(dto.getNumero());

         entidade = rotaRepository.save(entidade);

         return new RotaDTO(entidade);

    }



}

