package net.comorevi.nukkit.automatictasks.utils;

import java.util.Calendar;
import net.comorevi.nukkit.automatictasks.AutomaticTasks;

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
    
    public int getDayOfTheMonth() {
        this.cal = getCal();
        int dayOfTheMonth = this.cal.get(Calendar.DATE);
        return dayOfTheMonth;
    }
    
    public int getLastDayOfMonth() {
        this.cal = getCal();
        int lastDayOfMonth = cal.getActualMaximum(Calendar.DATE);
        return lastDayOfMonth;
    }

    public Calendar getCal() {
        return this.cal = Calendar.getInstance();
    }
}
