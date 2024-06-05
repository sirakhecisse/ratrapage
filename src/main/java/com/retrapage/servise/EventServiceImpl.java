package com.retrapage.servise;

import com.retrapage.dto.EventDTO;
import com.retrapage.entity.Event;
import com.retrapage.repository.EventRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EventServiceImpl implements EventService{

    @Autowired
    private EventRepository eventRepository;
    @Override
    public List<EventDTO> getAllEvents() {
        return eventRepository.findAll().stream()
                .map(event -> new EventDTO(event))
                .collect(Collectors.toList());
    }

    @Override
    public EventDTO getEventById(Long id) {
        return null;
    }

    @Override
    public EventDTO createEvent(Event eventDTO) {
        Event event = new Event();
        event.setName(eventDTO.getName());
        event.setDescription(eventDTO.getDescription());
        event.setLocation(eventDTO.getLocation());
        event.setSpeaker(eventDTO.getSpeaker());
        event.setCapacity(eventDTO.getCapacity());

        Event savedEvent = eventRepository.save(event);
        return new EventDTO(savedEvent);
    }
    @Override
    public void updateEvent(Long id, EventDTO eventDTO) {
        eventRepository.findById(id)
                .ifPresent(event -> {
                    event.setName(eventDTO.getName());
                    event.setDescription(eventDTO.getDescription());
                    event.setLocation(eventDTO.getLocation());
                    event.setSpeaker(eventDTO.getSpeaker());
                    event.setCapacity(eventDTO.getCapacity());

                    eventRepository.save(event);
                });
    }
    @Override
    public void deleteEvent(Long id) {
        eventRepository.deleteById(id);
    }

}

