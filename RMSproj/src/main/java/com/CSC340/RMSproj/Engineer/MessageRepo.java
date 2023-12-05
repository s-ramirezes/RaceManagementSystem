package com.CSC340.RMSproj.Engineer;

import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface MessageRepo extends JpaRepository<Message, Long> {
    Optional<Message> findById(Long aLong);
}
