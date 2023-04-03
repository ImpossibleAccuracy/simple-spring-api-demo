package com.wsr.business.data.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "image")
@Getter
@Setter
@ToString
public class Document {
    @Id
    @GeneratedValue
    @Column(name = "\"id\"", nullable = false, updatable = false)
    private Long id;

    @Lob
    @Nonnull
    @Column(name = "\"data\"", nullable = false)
    private Byte[] data;

    @Nonnull
    @Column(name = "\"name\"", nullable = false)
    private String name;

    @Nonnull
    @Column(name = "\"type\"", nullable = false)
    private String type;
}
