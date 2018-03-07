package net.comorevi.nukkit.automatictasks.scheduler.tasks;

import net.comorevi.nukkit.automatictasks.AutomaticTasks;

public class ServerRestartMessage {

    private AutomaticTasks plugin;

    public ServerRestartMessage (AutomaticTasks plugin) {
        this.plugin = plugin;
    }

    public void sendServerRestartMessage (int minute) {
        int timetorestart = 60 - minute;
        plugin.getServer().broadcastMessage("システム>> 再起動まで残り"+ timetorestart +"分です。");
    }
}
