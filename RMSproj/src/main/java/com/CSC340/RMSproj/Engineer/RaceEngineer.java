package com.CSC340.RMSproj.Engineer;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Entity
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@Table(name = "track")
public class RaceEngineer {
    @jakarta.persistence.Id
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String surface;
    private String name;
    private double length;

    public void setId(Long id) {
        this.id = id;
    }

    public void setSurface(String surface) {
        this.surface = surface;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLength(double length) {
        this.length = length;
    }

    public Long getId() {
        return id;
    }

    public String getSurface() {
        return surface;
    }

    public String getName() {
        return name;
    }

    public double getLength() {
        return length;
    }
}
