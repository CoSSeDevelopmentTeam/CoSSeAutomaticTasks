package net.comorevi.nukkit.automatictasks.tasks;

import net.comorevi.nukkit.automatictasks.AutomaticTasks;

public class ServerRestart {

    private AutomaticTasks plugin;

    public ServerRestart (AutomaticTasks plugin) {
        plugin = plugin;
    }

    public void stopCoSSe () {
        plugin.getServer().shutdown();
    }
}
