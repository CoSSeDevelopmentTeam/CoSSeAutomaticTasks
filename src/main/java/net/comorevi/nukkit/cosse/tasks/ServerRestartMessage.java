package net.comorevi.nukkit.cosse.tasks;

import net.comorevi.nukkit.cosse.AutomaticTasks;

public class ServerRestartMessage {

    private AutomaticTasks plugin;

    public ServerRestartMessage (AutomaticTasks plugin) {
        plugin = plugin;
    }

    public void sendServerRestartMessage (int minute) {
        int timetorestart = 60 - minute;
        System.out.println(timetorestart);
        plugin.getServer().broadcastMessage("システム>> 再起動まで残り"+ timetorestart +"分です。");
    }
}
