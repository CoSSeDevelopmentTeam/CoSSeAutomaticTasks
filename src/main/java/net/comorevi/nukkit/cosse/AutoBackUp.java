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
            case 1: //月曜日
            case 3: //水曜日
            case 5: //金曜日
            case 7: //日曜日
                return true;
                default:
                    return false;
        }
    }
}
