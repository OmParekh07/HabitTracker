package com.example.HabitTracker.Model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.springframework.stereotype.Component;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Component
@Entity
@Table(name = "habit")
public class Habit {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name;

    private LocalDate createdAt;

    private Boolean isActive = true;

    // One habit → many logs
    @OneToMany(mappedBy = "habit", cascade = CascadeType.ALL)
    private List<HabitLog> logs = new ArrayList<>();
}
