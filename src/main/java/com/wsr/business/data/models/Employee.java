package com.wsr.business.data.models;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

@Entity
@Table(name = "employee")
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
    private String name;

    @Nullable
    private String surname;

    @Nonnull
    private String patronymic;

    @Nullable
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"subdivision_id\"")
    private Subdivision subdivision;

    @Nullable
    @ToString.Exclude
    private String department;

    @Nullable
    private String code;
}
