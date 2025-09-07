package com.transport.easy.transporteasy.entitiesDTO;

import com.transport.easy.transporteasy.entities.Rota;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class RotaDTO {
    private Long id;
    private String rua;
    private String bairro;
    private String cidade;
    private int numero;

    public RotaDTO(Rota Rota){
        this.id = Rota.getId();
        this.rua = Rota.getRua();
        this.bairro = Rota.getBairro();
        this.cidade = Rota.getCidade();
        this.numero = Rota.getNumero();
    }
}
