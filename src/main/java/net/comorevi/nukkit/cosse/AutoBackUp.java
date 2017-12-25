package net.comorevi.nukkit.cosse;

import net.comorevi.nukkit.cosse.utils.ZipCompress;

public class AutoBackUp {

    AutomaticTasks automaticTasks;

    public AutoBackUp (AutomaticTasks plugin) {
        this.automaticTasks = plugin;
        this.backUp();
    }

    public void backUp() {
        if (isBackUpDay()) {
            if (isFirstServerStartOfDay()) {
                String dataFilePath = automaticTasks.getDataFolder().toString();
                String filePath = dataFilePath + "\backup.zip";
                ZipCompress.compressDirectory(filePath, automaticTasks.getServer().getFilePath());
            }
        }
    }

    public boolean isFirstServerStartOfDay() {
        int dayOfHour = automaticTasks.getTime().getTimeHour();
        if(dayOfHour == 22) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBackUpDay() {
        int dayOfTheWeek = automaticTasks.getTime().getDayOfTheWeek();
        switch (dayOfTheWeek) {
            case 2:
            case 4: //水曜日
            case 7: //土曜日
                return true;
                default:
                    return false;
        }
    }
}
