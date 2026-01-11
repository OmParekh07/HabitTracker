package com.example.HabitTracker.dto;

import com.example.HabitTracker.Model.HabitLog;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class HabitDisplay {
        private Long id;

        private String name;

        private LocalDate createdAt;

        private Boolean isActive = true;


}
