package com.retrapage.repository;

import com.retrapage.entity.Event;
import com.retrapage.entity.Inscription;
import com.retrapage.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.List;

public interface InscriptionRepository extends JpaRepository<Inscription, Long> {

    static List<Inscription> findByEvent(Event event) {
        return null;
    }

    List<Inscription> findByUser(User user);
}

