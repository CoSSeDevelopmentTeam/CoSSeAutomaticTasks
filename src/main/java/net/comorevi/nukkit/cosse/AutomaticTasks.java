package net.comorevi.nukkit.cosse;

import cn.nukkit.plugin.PluginBase;
import net.comorevi.nukkit.cosse.level.MainGenerator;
import net.comorevi.nukkit.cosse.scheduler.MainScheduler;
import net.comorevi.nukkit.cosse.scheduler.tasks.*;
import net.comorevi.nukkit.cosse.utils.ConfigUtil;
import net.comorevi.nukkit.cosse.utils.Time;
import net.comorevi.nukkit.cosse.utils.ZipCompress;

public class AutomaticTasks extends PluginBase {

    ConfigUtil configUtil;
    Time time;
    AutoBackUp autoBackUp;
    MainGenerator mainGenerator;
    AutoRecreateSourceWorld autoRecreateSourceWorld;
    ZipCompress zipCompress;
    ServerEntityCleaner serverEntityCleaner;
    ServerRestart serverRestart;
    ServerRestartMessage serverRestartMessage;

    public void onEnable () {
        this.getDataFolder().mkdir();
        this.configUtil = new ConfigUtil(this);
        this.time = new Time(this);
        this.autoBackUp = new AutoBackUp(this);
        this.mainGenerator = new MainGenerator(this);
        this.autoRecreateSourceWorld = new AutoRecreateSourceWorld(this);
        this.zipCompress = new ZipCompress(this);
        this.serverEntityCleaner = new ServerEntityCleaner(this);
        this.serverRestart = new ServerRestart(this);
        this.serverRestartMessage = new ServerRestartMessage(this);
        this.getServer().getScheduler().scheduleRepeatingTask(new MainScheduler(this), 1200);
    }

    public ConfigUtil getConfigUtil() {
        return configUtil;
    }

    public Time getTime() {
        return this.time;
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
