package com.retrapage.servise;

import com.retrapage.dto.EventDTO;
import com.retrapage.entity.Event;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface EventService {
    List<EventDTO> getAllEvents();

    EventDTO getEventById(Long id);
    EventDTO createEvent(Event eventDTO);

    void updateEvent(Long id, EventDTO eventDTO);

    void deleteEvent(Long id);

}

