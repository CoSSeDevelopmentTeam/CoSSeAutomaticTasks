package net.comorevi.nukkit.cosse.utils;

import java.util.Calendar;
import net.comorevi.nukkit.cosse.AutomaticTasks;

public class Time {

    private Calendar cal;

    public Time (AutomaticTasks plugin) {

    }

    public int getTimeHour() {
        this.cal = getCal();
        return this.cal.get(Calendar.HOUR_OF_DAY);
    }

    public int getTimeMinute() {
        this.cal = getCal();
        return this.cal.get(Calendar.MINUTE);
    }

    public int getTimeSecond() {
        this.cal = getCal();
        return this.cal.get(Calendar.SECOND);
    }

    public int getDayOfTheWeek() {
        this.cal = getCal();
        int dayOfTheWeek = this.cal.get(Calendar.DAY_OF_WEEK);
        return dayOfTheWeek;
    }

    public Calendar getCal() {
        return this.cal = Calendar.getInstance();
    }
}
