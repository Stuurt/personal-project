package com.example.barbearia.controller;

import com.example.barbearia.hair.Hair;
import com.example.barbearia.hair.HairRepository;
import com.example.barbearia.hair.HairRequestDTO;
import com.example.barbearia.hair.HairResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hair")
public class HairController {

    @Autowired
    private HairRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public ResponseEntity <?> create(@RequestBody HairRequestDTO data){
        Hair hairData = new Hair(data);
        repository.save(hairData);
        return ResponseEntity.ok().body("Hair criado com sucesso!");
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<HairResponseDTO> getAll(){

        List<HairResponseDTO> hairList = repository.findAll().stream()
                .map(HairResponseDTO::new).toList();
        return hairList;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PutMapping(value="/{id}")
    public ResponseEntity <?> update(@PathVariable("id") long id,
                                 @RequestBody Hair hair) {
        return repository.findById(id)
                .map(record -> {
                    record.setTitle(hair.getTitle());
                    record.setImage(hair.getImage());
                    record.setPrice(hair.getPrice());
                    repository.save(record);
                    return ResponseEntity.ok().body("Hair alterado com sucesso!");
                }).orElse(ResponseEntity.notFound().build());
    }

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @DeleteMapping(path ={"/{id}"})
    public ResponseEntity <?> delete(@PathVariable long id) {
        return repository.findById(id)
                .map(record -> {
                    repository.deleteById(id);
                    return ResponseEntity.ok().body("Hair excluído com sucesso!");
                }).orElse(ResponseEntity.notFound().build());
    }
}
