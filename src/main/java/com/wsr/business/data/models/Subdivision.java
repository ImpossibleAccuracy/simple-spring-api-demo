package com.wsr.business.data.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Table(name = "\"Subdivision\"")
@Getter
@Setter
public class Subdivision {
    @Id
    @GeneratedValue
    @Column(name = "\"Id\"", nullable = false, updatable = false)
    private Long id;

    @Nonnull
    @Column(name = "\"Title\"", nullable = false)
    private String title;
}
