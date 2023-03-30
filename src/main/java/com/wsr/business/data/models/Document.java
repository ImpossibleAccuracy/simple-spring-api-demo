package com.wsr.business.data.models;

import jakarta.annotation.Nonnull;
import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Entity
@Table(name = "\"Image\"")
@Getter
@Setter
@ToString
public class Document {
    @Id
    @GeneratedValue
    @Column(name = "\"Id\"", nullable = false, updatable = false)
    private Long id;

    @Lob
    @Nonnull
    @Column(name = "\"Data\"", nullable = false)
    private Byte[] data;

    @Nonnull
    @Column(name = "\"Name\"", nullable = false)
    private String name;

    @Nonnull
    @Column(name = "\"Type\"", nullable = false)
    private String type;
}
