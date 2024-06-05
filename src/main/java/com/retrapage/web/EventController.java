package com.retrapage.web;

import com.retrapage.dto.EventDTO;
import com.retrapage.entity.Event;
import com.retrapage.servise.EventService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;



import java.util.List;

@Controller
@RequestMapping("/graphql/events")
public class EventController {

    @Autowired
    private EventService eventService;

    @Query("events")
    public List<EventDTO> getAllEvents() {
        return eventService.getAllEvents();
    }

    @Query("eventById(id: Long!)")
    public EventDTO getEventById(@Argument Long id) {
        return eventService.getEventById(id);
    }

    @MutationMapping("createEvent")
    public EventDTO createEvent(@Argument Event eventInput) {
        Event event = new Event();
        event.setName(eventInput.getName());
        event.setDescription(eventInput.getDescription());
        event.setLocation(eventInput.getLocation());
        event.setSpeaker(eventInput.getSpeaker());
        event.setCapacity(eventInput.getCapacity());
        EventDTO createdEvent = eventService.createEvent(event);

        EventDTO eventDTO = new EventDTO(createdEvent);

        return eventDTO;
    }

    @MutationMapping("updateEvent(id: Long!, event: EventInput!)")
    public EventDTO updateEvent(@Argument Long id, @Argument Event eventInput) {
        EventDTO eventDTO = new EventDTO(id, eventInput.getName(), eventInput.getDescription(), eventInput.getLocation(), eventInput.getSpeaker(), eventInput.getCapacity());
        eventService.updateEvent(id, eventDTO);
        return eventService.getEventById(id);
    }

    @MutationMapping("deleteEvent(id: Long!)")
    public void deleteEvent(@Argument Long id) {
        eventService.deleteEvent(id);
    }
}

