package com.example.barbearia.controller;

import com.example.barbearia.hair.HairRepository;
import com.example.barbearia.hair.HairResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("hair")
public class HairController {

    @Autowired
    private HairRepository repository;

    @GetMapping
    public List<HairResponseDTO> getAll(){

        List<HairResponseDTO> hairList = repository.findAll().stream().map(HairResponseDTO::new).toList();
        return hairList;
    }
}
