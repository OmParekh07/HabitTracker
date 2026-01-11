package com.example.HabitTracker.Controller;

import com.example.HabitTracker.Model.Habit;
import com.example.HabitTracker.Service.HabitService;
import com.example.HabitTracker.dto.HabitDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin("http://localhost:5173")

public class HabitController {
    private HabitService service;

    public HabitService getService() {
        return service;
    }
    @Autowired
    public void setService(HabitService service) {
        this.service = service;
    }





    @GetMapping("/habits")
    public List<HabitDisplay> habits(){
        return service.getAllHabits();
    }

    @PostMapping("/habits")
    public ResponseEntity<Void> addHabit(@RequestBody Habit habit){
        service.addHabit(habit);
        return ResponseEntity.ok().build();
    }

}
