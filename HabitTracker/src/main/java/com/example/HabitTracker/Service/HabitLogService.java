package com.example.HabitTracker.Service;


import com.example.HabitTracker.Model.Habit;
import com.example.HabitTracker.Model.HabitLog;
import com.example.HabitTracker.Repository.HabitLogRepo;
import com.example.HabitTracker.Repository.HabitRepo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.*;

@Service
public class HabitLogService {
    private HabitLogRepo hlrepo;
    private HabitRepo hrepo;

    @Autowired
    public void setHrepo(HabitRepo hrepo) {
        this.hrepo = hrepo;
    }

    public HabitLogRepo getHlrepo() {
        return hlrepo;
    }
    @Autowired
    public void setHlrepo(HabitLogRepo hlrepo) {
        this.hlrepo = hlrepo;
    }

    public int getStreak(long id) {
        List<HabitLog> logs = hlrepo.findByHabitIdOrderByLogDateDesc(id);
        int index = 0;
        int streak = 0;
        if (logs.isEmpty()) {
            return 0;
        }
        LocalDate prevDate = logs.getFirst().getLogDate();
        LocalDate today = LocalDate.now();

        if(prevDate.equals(today)){
            if(logs.get(0).getStatus()){
                streak++;
            }else{
                index++;
            }
        }else{
            if(logs.get(0).getStatus()){
                streak++;
                index++;
            }else{
                return 0;
            }
        }
        while(index < logs.size()){
                HabitLog hl = logs.get(index);
                if(hl.getLogDate().plusDays(1L).equals(prevDate)){
                    if(hl.getStatus()){
                        streak++;
                    }else{
                        break;
                    }
                }else{
                    break;
                }


                prevDate = hl.getLogDate();
                index++;
        }

        return streak;

    }

    public void markHabit(long id) {
        LocalDate today = LocalDate.now();
        Optional<HabitLog> todayLog = hlrepo.findByHabitIdAndLogDate(id,today);
        if(todayLog.isPresent()){
            HabitLog log = todayLog.get();
            log.setStatus(true);
            hlrepo.save(log);
        }else{
            Habit habit = hrepo.findById(id).orElseThrow(()->new RuntimeException("Habit Not Found"));
            HabitLog log = new HabitLog();
            log.setLogDate(today);
            log.setHabit(habit);
            log.setStatus(true);
            hlrepo.save(log);
        }
    }

    public void unmarkHabit(long id) {
        hlrepo.deleteByHabitIdAndLogDate(id,LocalDate.now());
    }

    public int getLongStreak(long id) {
        List<HabitLog> logs = hlrepo.findByHabitIdAndStatusOrderByLogDateAsc(id,true);
        Set<Integer> streaks = new HashSet<>();
        int index = 0;
        int streak = 0;

        if(logs.isEmpty()) return 0;


            streaks.add(1);
            index = 1;


        LocalDate prevDay = logs.getFirst().getLogDate();

        while(index < logs.size()){
            HabitLog log = logs.get(index);

            if(log.getLogDate().minusDays(1).equals(prevDay)){
                streak++;
                streaks.add(streak);
            }else{
                streak = 0;
            }

            prevDay = log.getLogDate();
            index++;
        }

        return Collections.max(streaks);
    }
}
