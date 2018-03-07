package net.comorevi.nukkit.automatictasks.level;

import cn.nukkit.level.generator.Generator;

import net.comorevi.nukkit.automatictasks.AutomaticTasks;
import net.comorevi.nukkit.automatictasks.level.generator.*;

public class MainGenerator {

    AutomaticTasks plugin;

    public MainGenerator (AutomaticTasks plugin) {
        this.plugin = plugin;
        Generator.addGenerator(WorldGenDesert.class, "GEN_DESERT", WorldGenDesert.GENERATOR_ID);
        Generator.addGenerator(WorldGenForest.class, "GEN_FOREST", WorldGenForest.GENERATOR_ID);
        Generator.addGenerator(WorldGenIcePlains.class, "GEN_ICE_PLAINS", WorldGenIcePlains.GENERATOR_ID);
        //Generator.addGenerator(WorldGenJungle.class, "GEN_JUNGLE", WorldGenJungle.JUNGLE);
        Generator.addGenerator(WorldGenSwamp.class, "GEN_SWAMP", WorldGenSwamp.GENERATOR_ID);
    }

}
