package com.retrapage.servise;

import com.retrapage.dto.InscriptionDTO;

import java.util.List;


public interface InscriptionService {

    public List<InscriptionDTO> getAllRegistrations(Long eventId, Long userId);
}