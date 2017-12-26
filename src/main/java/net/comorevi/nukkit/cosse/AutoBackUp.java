package net.comorevi.nukkit.cosse;

import net.comorevi.nukkit.cosse.utils.ZipCompress;

public class AutoBackUp {

    AutomaticTasks automaticTasks;
    private int dayOfTheWeek;

    public AutoBackUp (AutomaticTasks plugin) {
        this.automaticTasks = plugin;
        this.dayOfTheWeek = automaticTasks.getTime().getDayOfTheWeek();
        this.backUp();
    }

    public void backUp() {
        if (isBackUpDay()) {
            if (isFirstServerStartOfDay()) {
                String dataFilePath = automaticTasks.getConfigUtil().getDropboxDir() + "\\backup-" + String.valueOf(this.dayOfTheWeek) + ".zip";
                ZipCompress.compressDirectory(dataFilePath, automaticTasks.getServer().getFilePath());
            }
        }
    }

    public boolean isFirstServerStartOfDay() {
        int dayOfHour = automaticTasks.getTime().getTimeHour();
        if(dayOfHour == 00) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBackUpDay() {
        switch (this.dayOfTheWeek) {
            case 1:
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
            case 7:
                return true;
                default:
                    return false;
        }
    }
}
