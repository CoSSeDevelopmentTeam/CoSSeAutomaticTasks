package net.comorevi.nukkit.cosse.scheduler;

import cn.nukkit.scheduler.PluginTask;
import net.comorevi.nukkit.cosse.AutomaticTasks;

import static oshi.util.Util.sleep;

public class MainScheduler extends PluginTask<AutomaticTasks> {

    public MainScheduler (AutomaticTasks owner) {
        super(owner);
    }

    public void onRun (int currentTick) {
        int min = this.owner.getTime().getTimeMinute();
        int sec = this.owner.getTime().getTimeSecond();
        switch (min) {
            case 10:
            case 20:
            case 40:
            case 50:
                this.owner.getServerEntityCleaner().cleanEntities();
                break;
            case 15:
            case 30:
            case 45:
            case 55:
            case 58:
                this.owner.getServerRestartMessage().sendServerRestartMessage(min);
                break;
            case 59:
                this.owner.getServerKickPlayers().kickPlayers();
                sleep((60 - sec) * 1000);
                this.owner.getServerRestart().stopCoSSe();
                break;
        }
    }
}
