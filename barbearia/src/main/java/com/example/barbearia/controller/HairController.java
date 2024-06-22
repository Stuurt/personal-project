package com.example.barbearia.controller;

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

    @PostMapping
    public void saveHair(@RequestBody HairRequestDTO data){
        Hair hairData = new Hair(data);
        repository.save(hairData);
        return;
    }

    @GetMapping
    public List<HairResponseDTO> getAll(){

        List<HairResponseDTO> hairList = repository.findAll().stream().map(HairResponseDTO::new).toList();
        return hairList;
    }
}
