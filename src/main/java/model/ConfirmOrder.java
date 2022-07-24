package model;

import lombok.*;

import javax.persistence.*;
import javax.validation.constraints.NotNull;

@Entity @Data
@AllArgsConstructor
@NoArgsConstructor
public class ConfirmOrder {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)    //Make id AUTO-INCREMENT
    private int order_id;

    @Column(name="videoCard")
    @NotNull(message = "videoCard can not be empty")
    private String videoCard;

    @Column(name="processor")
    @NotNull(message = "processor can not be empty")
    private String processor;

    @Column(name="ram")
    @NotNull(message = "ram can not be empty")
    private String ram;



    @Column(name="confirm")
    private Boolean confirm;
}
