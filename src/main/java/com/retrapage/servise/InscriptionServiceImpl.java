package com.retrapage.servise;

import com.retrapage.dto.InscriptionDTO;
import com.retrapage.repository.InscriptionRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class InscriptionServiceImpl implements InscriptionService{

    @Autowired
    private InscriptionRepository inscriptionRepository;

    @Autowired
    private EventService eventService;

    @Autowired
    private UserService userService;

    @Override
    public List<InscriptionDTO> getAllRegistrations(Long eventId, Long userId) {
        return inscriptionRepository.findAll().stream()
                .map(InscriptionDTO::new)
                .collect(Collectors.toList());
    }

}