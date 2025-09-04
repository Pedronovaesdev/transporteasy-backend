package com.transport.easy.transporteasy.entitiesDTO;

import com.transport.easy.transporteasy.entities.Motorista;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class MotoristaDTO {

    private Long id;
    private String nome;
    private String email;

    private String contato;

    public MotoristaDTO(Motorista entidade) {
        this.id = entidade.getId();
        this.nome = entidade.getNome();
        this.email = entidade.getEmail();
        this.contato = entidade.getTelefone();
    }
}