package com.example.barbearia.hair;

import jakarta.persistence.*;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;

@Table(name= "hairs")
@Entity(name= "hairs")
@Getter
@NoArgsConstructor
@EqualsAndHashCode(of = "id")
public class Hair {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;
}
