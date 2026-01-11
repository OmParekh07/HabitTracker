package com.example.HabitTracker.Controller;


import com.example.HabitTracker.Service.HabitLogService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@CrossOrigin("http://localhost:5173")

public class HabitLogController {
  private   HabitLogService service;

  @Autowired
    public void setService(HabitLogService service) {
        this.service = service;
    }

    @GetMapping("/habits/{id}/streak")
    public int getStreak(@PathVariable("id") long id){
        return service.getStreak(id);
    }

    @PostMapping("/habits/{id}/mark")
    public ResponseEntity<Void> markHabit(@PathVariable("id") long id){
        service.markHabit(id);

        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/habits/{id}/unmark")
    public ResponseEntity<Void> unmarkHabit(@PathVariable("id") long id){
        service.unmarkHabit(id);
        return ResponseEntity.ok().build();
    }

    @GetMapping("/habits/{id}/lstreak")
    public int getLongStreak(@PathVariable("id") long id){

      return service.getLongStreak(id);
    }



}
