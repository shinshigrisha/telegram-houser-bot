package io.proj3ct.entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Table(name = "city")
@Data
public class City {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private Long id;

    @Column(name = "DESCRIPTION", length = 70)
    private String description;

    @Column(name = "ACTIVE")
    private Boolean active;

}
