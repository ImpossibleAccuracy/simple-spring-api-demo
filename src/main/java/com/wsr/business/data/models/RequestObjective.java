package com.wsr.business.data.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "request_objective")
@Getter
@Setter
@ToString
public class RequestObjective {
    @Id
    @GeneratedValue
    @Column(name = "\"Id\"", nullable = false, updatable = false)
    private Long id;

    @Nonnull
    private String title;
}
