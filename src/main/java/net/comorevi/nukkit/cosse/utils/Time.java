package net.comorevi.nukkit.cosse.utils;

import java.util.Calendar;
import net.comorevi.nukkit.cosse.AutomaticTasks;

public class Time {

    private Calendar cal;

    public Time (AutomaticTasks plugin) {

    }

    public int getTimeMinute() {
        this.cal = getCal();
        return this.cal.get(12);
    }

    public Calendar getCal() {
        return this.cal = Calendar.getInstance();
    }
}
