package com.example.HabitTracker;

import com.example.HabitTracker.Model.Habit;
import com.example.HabitTracker.Model.HabitLog;
import com.example.HabitTracker.Repository.HabitLogRepo;
import com.example.HabitTracker.Repository.HabitRepo;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

import java.time.LocalDate;

@SpringBootApplication
public class HabitTrackerApplication {

	public static void main(String[] args) {

		ApplicationContext context =
				SpringApplication.run(HabitTrackerApplication.class, args);

//		HabitRepo habitRepo =
//				context.getBean(HabitRepo.class);
//
//		HabitLogRepo habitLogRepo =
//				context.getBean(HabitLogRepo.class);
//
//		// 1️⃣ Create Habit
//		Habit habit = new Habit();
//		habit.setName("Gym");
//		habit.setCreatedAt(LocalDate.now());
//
//		habitRepo.save(habit);  // habit saved first
//
//		// 2️⃣ Create HabitLog
//		HabitLog log = new HabitLog();
//		log.setLogDate(LocalDate.now());
//		log.setStatus(true);
//		log.setHabit(habit);    // IMPORTANT: set object, not ID
//
//		habitLogRepo.save(log); // habit_log saved
//
//		System.out.println("Dummy habit and habit log saved successfully!");


	}

}
