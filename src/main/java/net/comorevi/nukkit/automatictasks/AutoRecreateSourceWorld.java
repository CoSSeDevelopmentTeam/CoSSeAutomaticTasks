package net.comorevi.nukkit.automatictasks;

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
            long seed = System.currentTimeMillis();
            if (existsSourceWorld()) {
                //ワールドディレクトリ削除
                plugin.getServer().getLogger().info("delete");
                deleteOldSourceWorld(new File(plugin.getServer().getFilePath().toString() + "worlds" + File.separator + "source"));
                //ワールド生成
                plugin.getServer().getLogger().info("create");
                plugin.getServer().generateLevel("source", seed, Generator.getGenerator(getGeneratorName(dayOfTheWeek)));
                //ワールド読み込み
                plugin.getServer().loadLevel("source");
            } else {
                //ワールド生成
                plugin.getServer().getLogger().info("create");
                plugin.getServer().generateLevel("source", seed, Generator.getGenerator(getGeneratorName(dayOfTheWeek)));
                //ワールド読み込み
                plugin.getServer().loadLevel("source");
            }
        }
    }

    public boolean existsSourceWorld () {
        if (new File(plugin.getServer().getFilePath().toString() + "worlds" + File.separator + "source").exists()) {
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
        /*
        int dayOfHour = plugin.getTime().getTimeHour();
        if((dayOfHour == 1)) {
            return true;
        } else {
            return false;
        }
        */
        return true;
    }
}
