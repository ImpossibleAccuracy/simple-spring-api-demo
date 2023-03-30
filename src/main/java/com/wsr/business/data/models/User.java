package com.wsr.business.data.models;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;

@Entity
@Table(name = "\"User\"")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "\"Id\"", nullable = false, updatable = false)
    private Long id;

    @Nullable
    @Column(name = "\"Email\"", unique = true)
    private String email;

    @Nullable
    @Column(name = "\"Login\"")
    private String login;

    @Nullable
    @Column(name = "\"Phone\"")
    private String phone;

    @Nullable
    @Column(name = "\"Password\"")
    private String password;

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
    @Column(name = "\"Organization\"")
    private String organization;

    @Nonnull
    @Column(name = "\"Comment\"")
    private String comment;

    @Nonnull
    @Column(name = "\"BirthDate\"")
    private Instant birthDate = Instant.now();

    @Nonnull
    @Column(name = "\"PassportSeries\"")
    private String passportSeries;

    @Nonnull
    @Column(name = "\"PassportNumber\"")
    private String passportNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"PhotoId\"")
    @ToString.Exclude
    private Document photo;

    @Nonnull
    @Column(name = "\"CreationTime\"", nullable = false)
    private Instant creationTime = Instant.now();
}
