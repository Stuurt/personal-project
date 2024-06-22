package com.example.barbearia.hair;

public record HairResponseDTO(Long id, String title, String image, Integer price) {

    public HairResponseDTO(Hair hair){
        this(hair.getId(), hair.getTitle(), hair.getImage(), hair.getPrice());
    }
}