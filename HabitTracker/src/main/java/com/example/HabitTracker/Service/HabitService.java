package com.example.HabitTracker.Service;

import com.example.HabitTracker.Model.Habit;
import com.example.HabitTracker.Model.HabitLog;
import com.example.HabitTracker.Repository.HabitRepo;
import com.example.HabitTracker.dto.HabitDisplay;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.SQLOutput;
import java.util.ArrayList;
import java.util.List;

@Service
public class HabitService {
    private HabitRepo hrepo;

    public HabitRepo getHrepo() {
        return hrepo;
    }

    @Autowired
    public void setHrepo(HabitRepo hrepo) {
        this.hrepo = hrepo;
    }

    public List<HabitDisplay> getAllHabits() {
        List<Habit> habits = hrepo.findAll();

        List<HabitDisplay> result = new ArrayList<>();

        for(Habit h:habits){
            HabitDisplay hd = new HabitDisplay();
            hd.setId(h.getId());
            hd.setName(h.getName());
            hd.setCreatedAt(h.getCreatedAt());
            hd.setIsActive(h.getIsActive());
            result.add(hd);
        }

        return result;
    }


    public void addHabit(Habit habit) {
        hrepo.save(habit);
    }
}
