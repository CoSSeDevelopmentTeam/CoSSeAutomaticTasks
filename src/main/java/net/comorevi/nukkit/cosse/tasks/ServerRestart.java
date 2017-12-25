package net.comorevi.nukkit.cosse.tasks;

import net.comorevi.nukkit.cosse.AutomaticTasks;

public class ServerRestart {

    private AutomaticTasks plugin;

    public ServerRestart (AutomaticTasks plugin) {
        plugin = plugin;
    }

    public void stopCoSSe () {
        plugin.getServer().shutdown();
    }
}
