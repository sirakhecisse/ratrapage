package com.retrapage.entity;

import com.retrapage.enums.RegistrationStatus;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "registrations")
public class Inscription {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "event_id", nullable = false)
    private Event event;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", nullable = false)
    private User user;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    private RegistrationStatus status;

    // Getters and setters omitted for brevity
}
