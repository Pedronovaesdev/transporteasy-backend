package com.transport.easy.transporteasy.services;

import com.transport.easy.transporteasy.entities.Motorista;
import com.transport.easy.transporteasy.entitiesDTO.MotoristaDTO;
import com.transport.easy.transporteasy.repositories.MotoristaRepository;
import com.transport.easy.transporteasy.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class MotoristaService {

    @Autowired
    private MotoristaRepository motoristaRepository;


    public List<MotoristaDTO> findAll(){
        List<Motorista> motoristas = motoristaRepository.findAll();

        List<MotoristaDTO> motoristasDTOs = motoristas.stream()
                .map(entidade -> new MotoristaDTO(entidade))
                .collect(Collectors.toList());

        return motoristasDTOs;
    }

    public MotoristaDTO findById(Long id){
        Optional<Motorista> motorista = motoristaRepository.findById(id);

        Motorista entidade = motorista.orElseThrow(()-> new ResourceNotFoundException("Motorista nao encontrado"));

        return new MotoristaDTO(entidade);
    }

    public MotoristaDTO create(MotoristaDTO dto) {

        Motorista novaEntidade = new Motorista();
        novaEntidade.setNome(dto.getNome());
        novaEntidade.setEmail(dto.getEmail());
        novaEntidade.setTelefone(dto.getContato());

        novaEntidade = motoristaRepository.save(novaEntidade);

        return new MotoristaDTO(novaEntidade);
    }


    public MotoristaDTO update(Long id, MotoristaDTO dto) {
         Motorista entidade = motoristaRepository.getReferenceById(id);
         entidade.setNome(dto.getNome());
         entidade.setEmail(dto.getEmail());
         entidade.setTelefone(dto.getContato());

         entidade = motoristaRepository.save(entidade);

         return new MotoristaDTO(entidade);

    }

    public List<MotoristaDTO> findByDriverStatus(String status){
        List<MotoristaDTO> driver = motoristaRepository.findByStatus(status);
        return driver;
    }

}

