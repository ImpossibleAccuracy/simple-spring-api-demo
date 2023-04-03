package com.wsr.business.data.models;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.sql.Timestamp;
import java.time.Instant;

@Entity
@Table(name = "\"user\"")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class User {
    @Id
    @GeneratedValue
    @Column(name = "\"id\"", nullable = false, updatable = false)
    private Long id;

    @Nullable
    @Column(name = "\"email\"", unique = true)
    private String email;

    @Nullable
    @Column(name = "\"login\"")
    private String login;

    @Nullable
    @Column(name = "\"phone\"")
    private String phone;

    @Nullable
    @Column(name = "\"password\"")
    private String password;

    @Nonnull
    @Column(name = "\"name\"")
    private String name;

    @Nullable
    @Column(name = "\"surname\"")
    private String surname;

    @Nonnull
    @Column(name = "\"patronymic\"")
    private String patronymic;

    @Nullable
    @Column(name = "\"organization\"")
    private String organization;

    @Nonnull
    @Column(name = "\"comment\"")
    private String comment;

    @Nonnull
    @Column(name = "\"birthDate\"")
    private Timestamp birthDate = Timestamp.from(Instant.now());

    @Nonnull
    @Column(name = "\"passport_series\"")
    private String passportSeries;

    @Nonnull
    @Column(name = "\"passport_number\"")
    private String passportNumber;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"photo_id\"")
    @ToString.Exclude
    private Document photo;

    @Nonnull
    @Column(name = "\"creation_time\"", nullable = false)
    private Timestamp creationTime = Timestamp.from(Instant.now());
}
