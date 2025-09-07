package com.transport.easy.transporteasy.entitiesDTO;

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
    private int num;
}
