package com.example.barbearia.hair;

import jakarta.persistence.*;
import lombok.*;

@Table(name= "hairs")
@Entity(name= "hairs")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@EqualsAndHashCode(of = "id")
public class Hair {

    @Id @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String title;
    private String image;
    private Integer price;

    public Hair(HairRequestDTO data){
        this.title = data.title();
        this.image = data.image();
        this.price = data.price();
    }

}
