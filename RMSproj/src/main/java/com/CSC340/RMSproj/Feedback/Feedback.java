package com.CSC340.RMSproj.Feedback;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDateTime;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "feedback")
public class Feedback {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    // Example of other fields (add your actual fields here)
    private String message;

    // Field to track when each feedback was created
    private LocalDateTime dateField;

    // Getters and Setters

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalDateTime getCreatedAt() {
        return dateField;
    }

    public void setCreatedAt(LocalDateTime dateFiels) {
        this.dateField = dateField;
    }
    // Getter and setter for submittedByUsername
    @Getter
    private String submittedByUsername;



    public void setSubmittedByUsername(String submittedByUsername) {
        this.submittedByUsername = submittedByUsername;
    }
}