package com.transport.easy.transporteasy.services;

import com.transport.easy.transporteasy.entities.Motorista;
import com.transport.easy.transporteasy.entities.Passageiro;
import com.transport.easy.transporteasy.entitiesDTO.MotoristaDTO;
import com.transport.easy.transporteasy.entitiesDTO.PassageiroDTO;
import com.transport.easy.transporteasy.repositories.MotoristaRepository;
import com.transport.easy.transporteasy.repositories.PassageiroRepository;
import com.transport.easy.transporteasy.services.exceptions.ResourceNotFoundException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class PassageiroService {

    @Autowired
    private PassageiroRepository passageiroRepository;


    public List<PassageiroDTO> findAll(){
        List<Passageiro> passageiros = passageiroRepository.findAll();

        List<PassageiroDTO> passageirosDTOs = passageiros.stream()
                .map(entidade -> new PassageiroDTO(entidade))
                .collect(Collectors.toList());

        return passageirosDTOs;

    }

    public PassageiroDTO findById(Long id){
        Optional<Passageiro> passageiro = passageiroRepository.findById(id);

        Passageiro entidade = passageiro.orElseThrow(()-> new ResourceNotFoundException("Passageiro nao encontrado"));

        return new PassageiroDTO(entidade);
    }

    public PassageiroDTO create(PassageiroDTO dto) {

        Passageiro novaEntidade = new Passageiro();
        novaEntidade.setNome(dto.getNome());
        novaEntidade.setEmail(dto.getEmail());
        novaEntidade.setTelefone(dto.getContato());

        novaEntidade = passageiroRepository.save(novaEntidade);

        return new PassageiroDTO(novaEntidade);
    }


    public PassageiroDTO update(Long id, PassageiroDTO dto) {
         Passageiro entidade = passageiroRepository.getReferenceById(id);
         entidade.setNome(dto.getNome());
         entidade.setEmail(dto.getEmail());
         entidade.setTelefone(dto.getContato());

         entidade = passageiroRepository.save(entidade);

         return new PassageiroDTO(entidade);

    }


}

