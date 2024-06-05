package com.retrapage.web;

import com.retrapage.dto.InscriptionDTO;
import com.retrapage.servise.InscriptionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.repository.Query;
import org.springframework.graphql.data.method.annotation.Argument;
import org.springframework.graphql.data.method.annotation.MutationMapping;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping("/graphql/registrations")
public class InscriptionController {

    @Autowired
    private InscriptionController inscriptionController;

    @Autowired
    private InscriptionService inscriptionService;



    @Query("registrationsByEvent(eventId: Long!)")
    public List<InscriptionDTO> getRegistrationsByEvent(@Argument Long eventId) {
        return inscriptionService.getAllRegistrations(eventId, eventId);
    }

    @Query("registrationsByUser(userId: Long!)")
    public List<InscriptionDTO> getRegistrationsByUser(@Argument Long userId) {
        return inscriptionService.getAllRegistrations(userId, userId);
    }

    @MutationMapping("registerUserForEvent(eventId: Long!, userId: Long!)")
    public InscriptionDTO registerUserForEvent(@Argument Long eventId, @Argument Long userId) {
        return (InscriptionDTO) inscriptionService.getAllRegistrations(eventId, userId);
    }
}

