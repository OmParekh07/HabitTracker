package com.example.HabitTracker.Repository;

import com.example.HabitTracker.Model.Habit;
import com.example.HabitTracker.Model.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface HabitRepo extends JpaRepository<Habit, Long> {


}
