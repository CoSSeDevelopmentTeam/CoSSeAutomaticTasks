package net.comorevi.nukkit.cosse.utils;

import net.comorevi.nukkit.cosse.AutomaticTasks;
import cn.nukkit.utils.Config;

import java.io.File;
import java.util.LinkedHashMap;

public class ConfigUtil {

    AutomaticTasks automaticTasks;
    private Config config;

    public ConfigUtil (AutomaticTasks plugin) {
        this.automaticTasks = plugin;
        this.createConfigFile();
    }

    public void createConfigFile() {
        this.config = new Config(
                new File(automaticTasks.getDataFolder(), "config.yml"),
                Config.YAML,
                //Default values (not necessary)
                new LinkedHashMap<String, Object>() {
                    {
                        put("dropboxDir", "");
                    }
                });
    }

    public String getDropboxDir() {
        Object dropboxDirObj =  this.config.get("dropboxDir");
        if (dropboxDirObj != null) {
            String dropboxDirStr = String.valueOf(dropboxDirObj);
            return dropboxDirStr;
        }
        return null;
    }
}
