package com.example.HabitTracker.Repository;

import com.example.HabitTracker.Model.HabitLog;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDate;
import java.util.List;
import java.util.Optional;


@Repository
public interface HabitLogRepo extends JpaRepository<HabitLog,Long> {
    List<HabitLog> findByHabitIdOrderByLogDateDesc(Long habitId);

    Optional<HabitLog> findByHabitIdAndLogDate(Long habitId, LocalDate date);

    @Transactional
    void deleteByHabitIdAndLogDate(Long habitId, LocalDate date);

    List<HabitLog> findByHabitIdAndStatusOrderByLogDateAsc(Long habitId,boolean status);

}
