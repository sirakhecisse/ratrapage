package com.retrapage.entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Time;
import java.util.Date;

@Entity
@Data
@Table(name = "events")
public class Event {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = false, length = 255)
    private String name;

    @Column(nullable = false, length = 1000)
    private String description;


    @Column(nullable = false, length = 255)
    private String location;

    @Column(length = 255)
    private String speaker;

    @Column(nullable = false)
    private int capacity;

}
