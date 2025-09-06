package com.transport.easy.transporteasy.resource;

import com.transport.easy.transporteasy.entities.Passageiro;
import com.transport.easy.transporteasy.entitiesDTO.MotoristaDTO;
import com.transport.easy.transporteasy.entitiesDTO.PassageiroDTO;
import com.transport.easy.transporteasy.services.MotoristaService;
import com.transport.easy.transporteasy.services.PassageiroService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/passageiro")
public class PassageiroResource {

    @Autowired
    private PassageiroService passageiroService;

    @GetMapping
    public ResponseEntity<List<PassageiroDTO>> findAll(){
        List<PassageiroDTO> list = passageiroService.findAll();
        return ResponseEntity.ok().body(list);

    }

    @GetMapping(value = "/{id}")
    public ResponseEntity<PassageiroDTO> findById(@PathVariable Long id){
        PassageiroDTO obj = passageiroService.findById(id);
        return ResponseEntity.ok().body(obj);
    }

    @PostMapping
    public ResponseEntity<PassageiroDTO> create(@RequestBody PassageiroDTO passageiroDTO){
        PassageiroDTO obj = passageiroService.create(passageiroDTO);
        return ResponseEntity.ok().body(obj);

    }

    @PutMapping(value = "/{id}")
    public ResponseEntity<PassageiroDTO> update(@PathVariable Long id, @RequestBody PassageiroDTO passageiroDTO){
        passageiroDTO = passageiroService.update(id,passageiroDTO);
        return ResponseEntity.ok().body(passageiroDTO);
    }
}
