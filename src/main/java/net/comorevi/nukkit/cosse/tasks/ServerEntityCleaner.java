package net.comorevi.nukkit.cosse.tasks;

import net.comorevi.nukkit.cosse.AutomaticTasks;
import entitiescleaner.cleaner.CleanerManager;
import entitiescleaner.cleaner.EntityCleaner;

public class ServerEntityCleaner {

    private AutomaticTasks plugin;

    public ServerEntityCleaner (AutomaticTasks plugin) {
        plugin = plugin;
        CleanerManager.addCleaner(new EntityCleaner());
    }

    public void cleanEntities () {
        CleanerManager.cleanEntities();
        plugin.getServer().broadcastMessage("システム>> サーバー内のドロップしているアイテムを削除しました。");
    }
}
