package com.CSC340.RMSproj.Stats;

import jakarta.persistence.*;
import lombok.*;
import java.text.DecimalFormat;

import org.springframework.boot.autoconfigure.web.WebProperties;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "stats")
public class Stats {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    private String driverName;
    private int totalRaces;
    private int wins;
    public Stats(String driverName, int totalRaces, int wins) {
        this.driverName = driverName;
        this.totalRaces = totalRaces;
        this.wins = wins;
    }
    public double getWinPercentage() {
        if (totalRaces == 0) return 0;

        double winPercentage = ((double) wins / totalRaces) * 100;

        // Create a DecimalFormat instance with the desired format pattern
        DecimalFormat df = new DecimalFormat("0.00");

        // Format the winPercentage to have two decimal places
        return Double.parseDouble(df.format(winPercentage));
    }
}