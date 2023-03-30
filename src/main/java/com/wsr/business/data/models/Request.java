package com.wsr.business.data.models;

import jakarta.annotation.Nonnull;
import jakarta.annotation.Nullable;
import jakarta.persistence.*;
import lombok.*;

import java.time.Instant;
import java.util.Set;

@Entity
@Table(name = "\"Request\"")
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
    @Column(name = "\"StartTime\"", nullable = false)
    private Instant startTime;

    @Nullable
    @Column(name = "\"EndTime\"", nullable = false)
    private Instant endTime;

    @Nonnull
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "\"ObjectiveId\"", nullable = false)
    @ToString.Exclude
    private RequestObjective objective;

    @Column(name = "\"ConfirmationTime\"")
    private Instant confirmationTime;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"PlaceId\"", nullable = false)
    @ToString.Exclude
    private Subdivision place;

    @ManyToOne(fetch = FetchType.LAZY, optional = false)
    @JoinColumn(name = "\"EmployeeId\"", nullable = false)
    @ToString.Exclude
    private Employee employee;

    @ManyToMany(fetch = FetchType.LAZY)
    @JoinTable(
            name = "\"Request_Visitor\"",
            joinColumns = @JoinColumn(name = "\"VisitorId\""),
            inverseJoinColumns = @JoinColumn(name = "\"RequestId\"")
    )
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
