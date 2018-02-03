package net.comorevi.nukkit.cosse.scheduler.tasks;

import net.comorevi.nukkit.cosse.AutomaticTasks;

import java.util.UUID;

public class ServerKickPlayers {

    private AutomaticTasks plugin;

    public ServerKickPlayers(AutomaticTasks plugin) {
        this.plugin = plugin;
    }

    public void kickPlayers() {
        plugin.getServer().getOnlinePlayers().forEach((UUID, player) -> player.kick("システム>> 再起動のため自動的に退出しました。"));
    }
}
