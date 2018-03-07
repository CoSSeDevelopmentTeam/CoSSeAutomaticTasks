package net.comorevi.nukkit.automatictasks;

import net.comorevi.nukkit.automatictasks.utils.ZipCompress;

import java.io.File;

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
                String dataFilePath = automaticTasks.getConfigUtil().getDropboxDir() + File.separator + "backup-" + String.valueOf(this.dayOfTheWeek) + "-" + String.valueOf(automaticTasks.getTime().getTimeHour()) + ".zip";
                ZipCompress.compressDirectory(dataFilePath, automaticTasks.getServer().getFilePath());
            }
        }
    }

    public boolean isFirstServerStartOfDay() {
        int dayOfHour = automaticTasks.getTime().getTimeHour();
        if((dayOfHour == 0) || (dayOfHour == 12)) {
            return true;
        } else {
            return false;
        }
    }

    public boolean isBackUpDay() {
        switch (this.dayOfTheWeek) {
            case 1: //月曜日
            case 2:
            case 3: //水曜日
            case 4:
            case 5: //金曜日
            case 6:
            case 7: //日曜日
                return true;
                default:
                    return false;
        }
    }
}
