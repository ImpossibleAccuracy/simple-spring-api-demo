package com.wsr.business.data.models;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "\"Employee\"")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Employee {
    @Id
    @GeneratedValue
    @Column(name = "\"Id\"", nullable = false, updatable = false)
    private Long id;

    @Nonnull
    @Column(name = "\"Name\"")
    private String name;

    @Nullable
    @Column(name = "\"Surname\"")
    private String surname;

    @Nonnull
    @Column(name = "\"Patronymic\"")
    private String patronymic;

    @Nullable
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"SubdivisionId\"")
    @ToString.Exclude
    private Subdivision subdivision;

    @Nullable
    @Column(name = "\"Department\"")
    @ToString.Exclude
    private String department;

    @Nullable
    @Column(name = "\"Code\"")
    private String code;
}
