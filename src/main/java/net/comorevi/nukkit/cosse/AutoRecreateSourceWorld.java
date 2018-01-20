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
        if (existsSourceWorld()) {
            plugin.getLogger().info("資源ワールド削除");
            //ワールドディレクトリ削除
            plugin.getLogger().info(plugin.getServer().getFilePath().toString() + "worlds\\source");
            deleteOldSourceWorld(new File(plugin.getServer().getFilePath().toString() + "worlds\\source"));
            //ワールド生成
            plugin.getLogger().info("資源ワールド生成");
            plugin.getServer().generateLevel("source", 404, Generator.getGenerator("GEN_FOREST"));
            //読み込み
            plugin.getLogger().info("資源ワールド読み込み");
            plugin.getServer().loadLevel("source");
        } else {
            //ワールド生成
            plugin.getLogger().info("資源ワールド生成");
            plugin.getServer().generateLevel("source", 404, Generator.getGenerator("GEN_FOREST"));
            //読み込み
            plugin.getLogger().info("資源ワールド読み込み");
            plugin.getServer().loadLevel("source");
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

    public int getWorldType (int dayOfTheWeek) {
        switch (dayOfTheWeek) {
            case 1:
                return 1;
            case 2:
                return 2;
            case 3:
                return 3;
            case 4:
                return 4;
            case 5:
                return 5;
            case 6:
                return 6;
            case 7:
                return 7;
            default:
                return 1;
        }
    }
}
