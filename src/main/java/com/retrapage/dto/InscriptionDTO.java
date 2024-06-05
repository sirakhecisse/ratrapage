package com.retrapage.dto;

import com.retrapage.entity.Inscription;
import com.retrapage.enums.RegistrationStatus;
import lombok.Data;

@Data
public class InscriptionDTO {
    private Long id;
    private Long eventId;
    private Long userId;
    private RegistrationStatus status;

    public InscriptionDTO(Inscription inscription) {
        this.id = inscription.getId();
        this.eventId = inscription.getEvent().getId();
        this.userId = inscription.getUser().getId();
        this.status = inscription.getStatus();
    }
}
