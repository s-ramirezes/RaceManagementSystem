package com.CSC340.RMSproj.Budget;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

/**
 * Represents an item mapped to the
 * "budget" table in the database.
 */
@Entity
@Table(name = "budget")
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
public class Budget {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String datePurchased;
    private String itemName;
    private String description;
    private Double price;
}
