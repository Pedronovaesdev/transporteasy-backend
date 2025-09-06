package com.transport.easy.transporteasy.entitiesDTO;

import com.transport.easy.transporteasy.entities.Passageiro;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class PassageiroDTO {
    private Long id;
    private String nome;
    private String email;
    private String contato;

    public PassageiroDTO(Passageiro passageiro) {
        this.id = passageiro.getId();
        this.nome = passageiro.getNome();
        this.email = passageiro.getEmail();
        this.contato = passageiro.getTelefone();
    }
}
