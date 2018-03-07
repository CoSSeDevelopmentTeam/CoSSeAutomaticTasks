package net.comorevi.nukkit.automatictasks.scheduler.tasks;

import net.comorevi.nukkit.automatictasks.AutomaticTasks;

public class ServerRestart {

    private AutomaticTasks plugin;

    public ServerRestart (AutomaticTasks plugin) {
        this.plugin = plugin;
    }

    public void stopCoSSe () {
        plugin.getServer().shutdown();
    }
}
