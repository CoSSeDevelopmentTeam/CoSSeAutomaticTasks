package net.comorevi.nukkit.cosse;

import cn.nukkit.level.generator.Generator;

import java.io.File;

public class AutoRecreateSourceWorld {

    private AutomaticTasks plugin;
    private int dayOfTheWeek;

    public AutoRecreateSourceWorld(AutomaticTasks plugin) {
        this.plugin = plugin;
        this.dayOfTheWeek = plugin.getTime().getDayOfTheWeek();
        reCreateSourceWorld();
    }

    public void reCreateSourceWorld () {
        if (isFirstServerStartOfDay()) {
            if (existsSourceWorld()) {
                //ワールドディレクトリ削除
                plugin.getLogger().info(plugin.getServer().getFilePath().toString() + "worlds\\source");
                deleteOldSourceWorld(new File(plugin.getServer().getFilePath().toString() + "worlds\\source"));
                //ワールド生成
                plugin.getServer().generateLevel("source", 404, Generator.getGenerator(getGeneratorName(dayOfTheWeek)));
                //読み込み
                plugin.getServer().loadLevel("source");
            } else {
                //ワールド生成
                plugin.getServer().generateLevel("source", 404, Generator.getGenerator(getGeneratorName(dayOfTheWeek)));
                //読み込み
                plugin.getServer().loadLevel("source");
            }
        }
    }

    public boolean existsSourceWorld () {
        if (new File(plugin.getServer().getFilePath().toString() + "worlds\\source").exists()) {
            return true;
        } else {
            return false;
        }
    }

    public void deleteOldSourceWorld (File worldDirectory) {
        if (worldDirectory.isDirectory()) {
            for (File child : worldDirectory.listFiles()) {
                deleteOldSourceWorld(child);
            }
        }
        worldDirectory.delete();
    }

    public String getGeneratorName (int dayOfTheWeek) {
        switch (dayOfTheWeek) {
            case 1:
            case 3:
            case 5:
                return "GEN_FOREST";
            case 2:
                return "GEN_DESERT";
            case 4:
                return "GEN_SWAMP";
            case 6:
                return "GEN_ICE_PLAINS";
            case 7:
                return "GEN_JUNGLE";
            default:
                return "GEN_FOREST";
        }
    }

    public boolean isFirstServerStartOfDay() {
        int dayOfHour = plugin.getTime().getTimeHour();
        if((dayOfHour == 0)) {
            return true;
        } else {
            return false;
        }
    }
}
