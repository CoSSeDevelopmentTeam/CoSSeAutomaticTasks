package net.comorevi.nukkit.cosse.level;

import cn.nukkit.level.generator.Generator;

import net.comorevi.nukkit.cosse.AutomaticTasks;
import net.comorevi.nukkit.cosse.level.generator.*;

public class MainGenerator {

    AutomaticTasks plugin;

    public MainGenerator (AutomaticTasks plugin) {
        this.plugin = plugin;
        Generator.addGenerator(WorldGenDesert.class, "GEN_DESERT", Generator.TYPE_INFINITE);
        Generator.addGenerator(WorldGenForest.class, "GEN_FOREST", Generator.TYPE_INFINITE);
        Generator.addGenerator(WorldGenIcePlains.class, "GEN_ICE_PLAINS", Generator.TYPE_INFINITE);
        Generator.addGenerator(WorldGenJungle.class, "GEN_JUNGLE", Generator.TYPE_INFINITE);
        Generator.addGenerator(WorldGenSwamp.class, "GEN_SWAMP", Generator.TYPE_INFINITE);
    }

}
