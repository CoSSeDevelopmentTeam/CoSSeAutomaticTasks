package net.comorevi.nukkit.cosse;

import cn.nukkit.plugin.PluginBase;
import net.comorevi.nukkit.cosse.scheduler.MainScheduler;
import net.comorevi.nukkit.cosse.tasks.*;
import net.comorevi.nukkit.cosse.utils.Time;

public class AutomaticTasks extends PluginBase {

    Time time;
    ServerEntityCleaner servereintitycleaner;
    ServerRestart serverrestart;
    ServerRestartMessage serverrestartmessage;

    public void onEnable () {
        this.time = new Time(this);
        this.servereintitycleaner = new ServerEntityCleaner(this);
        this.serverrestart = new ServerRestart(this);
        this.serverrestartmessage = new ServerRestartMessage(this);
        this.getServer().getScheduler().scheduleRepeatingTask(new MainScheduler(this), 1200);
    }

    public Time getTime() {
        return this.time;
    }

    public ServerEntityCleaner getServerEntityCleaner() {
        return servereintitycleaner;
    }

    public ServerRestart getServerRestart() {
        return serverrestart;
    }

    public ServerRestartMessage getServerRestartMessage() {
        return serverrestartmessage;
    }
}
