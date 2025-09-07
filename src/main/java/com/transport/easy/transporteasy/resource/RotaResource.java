package com.transport.easy.transporteasy.resource;

import com.transport.easy.transporteasy.entities.Rota;
import com.transport.easy.transporteasy.entitiesDTO.RotaDTO;
import com.transport.easy.transporteasy.services.RotaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/rota")
public class RotaResource {

    @Autowired
    private RotaService rotaService;

    @GetMapping
    public ResponseEntity<List<RotaDTO>> findAll(){
        List<RotaDTO> list = rotaService.findAll();
        return ResponseEntity.ok().body(list);
    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<RotaDTO> findById(@PathVariable Long id){
        RotaDTO obj = rotaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<RotaDTO> create(@RequestBody RotaDTO rotaDTO){
        RotaDTO obj = rotaService.create(rotaDTO);
        return ResponseEntity.ok().body(obj);
    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<RotaDTO> update(@PathVariable Long id, @RequestBody RotaDTO rotaDTO){
        RotaDTO obj = rotaService.update(id, rotaDTO);
        return ResponseEntity.ok().body(obj);
    }


}
