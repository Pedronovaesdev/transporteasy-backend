package com.transport.easy.transporteasy.resource;

import com.transport.easy.transporteasy.entitiesDTO.MotoristaDTO;
import com.transport.easy.transporteasy.services.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorista")
public class MotoristaResource {


    private MotoristaService motoristaService;

    public MotoristaResource(MotoristaService motoristaService) {
        this.motoristaService = motoristaService;
    }

    @GetMapping
    public ResponseEntity<List<MotoristaDTO>> findAll(){
        List<MotoristaDTO> list = motoristaService.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<MotoristaDTO> findById(@PathVariable Long id){
        MotoristaDTO obj = motoristaService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<MotoristaDTO> create(@RequestBody MotoristaDTO motoristaDTO){
        MotoristaDTO obj = motoristaService.create(motoristaDTO);
        return ResponseEntity.ok().body(obj);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<MotoristaDTO> update(@PathVariable Long id, @RequestBody MotoristaDTO motoristaDTO){
         MotoristaDTO obj = motoristaService.update(id,motoristaDTO);
        return ResponseEntity.ok().body(obj);
    }
}
