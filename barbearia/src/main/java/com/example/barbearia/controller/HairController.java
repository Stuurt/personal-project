package com.example.barbearia.controller;

import ch.qos.logback.core.model.Model;
import com.example.barbearia.hair.Hair;
import com.example.barbearia.hair.HairRepository;
import com.example.barbearia.hair.HairRequestDTO;
import com.example.barbearia.hair.HairResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("hair")
public class HairController {

    @Autowired
    private HairRepository repository;

    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @PostMapping
    public void saveHair(@RequestBody HairRequestDTO data){
        Hair hairData = new Hair(data);
        repository.save(hairData);
        return;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping
    public List<HairResponseDTO> getAll(){

        List<HairResponseDTO> hairList = repository.findAll().stream().map(HairResponseDTO::new).toList();
        return hairList;
    }
    @CrossOrigin(origins = "*", allowedHeaders = "*")
    @GetMapping("/delete/{id}")
    public String deleteHair(@PathVariable("id") long id, Model model) {
        Hair hair = repository.findById(id)
                .orElseThrow(() -> new IllegalArgumentException("Invalid hair Id:" + id));
        repository.delete(hair);
        return "Hair excluído com sucesso!";
    }
}
