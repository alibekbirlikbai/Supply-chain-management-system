package model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class Component {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //Make id AUTO-INCREMENT
    private int component_id;

    @Column(name="component")
    @NotNull(message = "component can not be empty")
    private String component;

    @Column(name="price")
    @NotNull(message = "price can not be null")
    private int price;
}