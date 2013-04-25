package org.minigames.soulwars.core.jobs.game.walking;

import org.minigames.soulwars.util.Actions;
import org.minigames.soulwars.util.Areas;
import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.node.SceneEntities;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 23/04/13
 * Time: 02:13
 * To change this template use File | Settings | File Templates.
 */
public class WalkToSupplies extends Node {
    @Override
    public boolean activate() {
        return Variables.isInGame() && Variables.needBandages() && !Variables.isInArea(Areas.graveList);
    }

    @Override
    public void execute() {
        Actions.walkTo(SceneEntities.getNearest(Variables.BANDAGE_TABLE_IDS).getLocation());
    }
}
