package net.comorevi.nukkit.automatictasks;

import cn.nukkit.level.generator.Generator;
import cn.nukkit.plugin.PluginBase;
import net.comorevi.nukkit.automatictasks.level.MainGenerator;
import net.comorevi.nukkit.automatictasks.level.generator.WorldGenJungle;
import net.comorevi.nukkit.automatictasks.scheduler.MainScheduler;
import net.comorevi.nukkit.automatictasks.scheduler.tasks.*;
import net.comorevi.nukkit.automatictasks.utils.ConfigUtil;
import net.comorevi.nukkit.automatictasks.utils.Time;
import net.comorevi.nukkit.automatictasks.utils.ZipCompress;

public class AutomaticTasks extends PluginBase {

    ConfigUtil configUtil;
    Time time;
    AutoBackUp autoBackUp;
    AutoCommissionManager autoCommissionManager;
    MainGenerator mainGenerator;
    AutoRecreateSourceWorld autoRecreateSourceWorld;
    ZipCompress zipCompress;
    ServerEntityCleaner serverEntityCleaner;
    ServerKickPlayers serverKickPlayers;
    ServerRestart serverRestart;
    ServerRestartMessage serverRestartMessage;

    public void onEnable () {
        this.getDataFolder().mkdir();
        this.configUtil = new ConfigUtil(this);
        this.time = new Time(this);
        this.autoBackUp = new AutoBackUp(this);
        this.autoCommissionManager = new AutoCommissionManager(this);
        this.mainGenerator = new MainGenerator(this);
        //this.autoRecreateSourceWorld = new AutoRecreateSourceWorld(this);
        this.zipCompress = new ZipCompress(this);
        this.serverEntityCleaner = new ServerEntityCleaner(this);
        this.serverKickPlayers = new ServerKickPlayers(this);
        this.serverRestart = new ServerRestart(this);
        this.serverRestartMessage = new ServerRestartMessage(this);
        this.getServer().getScheduler().scheduleRepeatingTask(new MainScheduler(this), 1200);
        Generator.addGenerator(WorldGenJungle.class, WorldGenJungle.GENERATOR_NAME, WorldGenJungle.GENERATOR_ID);
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

    public ServerKickPlayers getServerKickPlayers() {
        return serverKickPlayers;
    }

    public ServerRestart getServerRestart() {
        return serverRestart;
    }

    public ServerRestartMessage getServerRestartMessage() {
        return serverRestartMessage;
    }
}
