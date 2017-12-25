package net.comorevi.nukkit.cosse;

import cn.nukkit.plugin.PluginBase;
import net.comorevi.nukkit.cosse.scheduler.MainScheduler;
import net.comorevi.nukkit.cosse.scheduler.tasks.*;
import net.comorevi.nukkit.cosse.utils.Time;
import net.comorevi.nukkit.cosse.utils.ZipCompress;

public class AutomaticTasks extends PluginBase {

    Time time;
    AutoBackUp autoBackUp;
    ZipCompress zipCompress;
    ServerEntityCleaner serverEntityCleaner;
    ServerRestart serverRestart;
    ServerRestartMessage serverRestartMessage;

    public void onEnable () {
        this.getDataFolder().mkdir();
        this.time = new Time(this);
        this.autoBackUp = new AutoBackUp(this);
        this.zipCompress = new ZipCompress(this);
        this.serverEntityCleaner = new ServerEntityCleaner(this);
        this.serverRestart = new ServerRestart(this);
        this.serverRestartMessage = new ServerRestartMessage(this);
        this.getServer().getScheduler().scheduleRepeatingTask(new MainScheduler(this), 1200);
    }

    public Time getTime() {
        return this.time;
    }

    public ZipCompress getZipCompress() {
        return zipCompress;
    }

    public ServerEntityCleaner getServerEntityCleaner() {
        return serverEntityCleaner;
    }

    public ServerRestart getServerRestart() {
        return serverRestart;
    }

    public ServerRestartMessage getServerRestartMessage() {
        return serverRestartMessage;
    }
}
