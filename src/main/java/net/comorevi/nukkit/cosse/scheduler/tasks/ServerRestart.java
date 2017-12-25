package net.comorevi.nukkit.cosse.scheduler.tasks;

import net.comorevi.nukkit.cosse.AutomaticTasks;

public class ServerRestart {

    private AutomaticTasks plugin;

    public ServerRestart (AutomaticTasks plugin) {
        this.plugin = plugin;
    }

    public void stopCoSSe () {
        plugin.getServer().shutdown();
    }
}
