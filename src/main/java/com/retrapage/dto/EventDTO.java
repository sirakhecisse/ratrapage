package com.retrapage.dto;

import com.retrapage.entity.Event;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class EventDTO {

    private Long id;
    private String name;
    private String description;
    private String location;
    private String speaker;
    private int capacity;

    public EventDTO(Event event) {
        this.id = event.getId();
        this.name = event.getName();
        this.description = event.getDescription();

    }


    public EventDTO(EventDTO createdEvent) {
    }
}

