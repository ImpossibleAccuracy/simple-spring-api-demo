package com.wsr.business.data.models;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "request")
@Getter
@Setter
@ToString
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Request {
    @Id
    @GeneratedValue
    @Column(name = "\"Id\"", nullable = false, updatable = false)
    private Long id;

    @Nonnull
    private Instant startTime;

    @Nullable
    private Instant endTime;

    @Nonnull
    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"objective_id\"")
    private RequestObjective objective;

    private Instant confirmationTime;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"place_id\"")
    private Subdivision place;

    @ToString.Exclude
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"employee_id\"")
    private Employee employee;

    @ToString.Exclude
    private Set<User> visitors;

    public User getSingleVisitor() {
        if (isSingleRequest()) {
            return visitors.iterator().next();
        }

        return null;
    }

    public boolean isSingleRequest() {
        return visitors.size() == 1;
    }

    public boolean isConfirmed() {
        return confirmationTime != null;
    }
}
