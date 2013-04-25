package org.minigames.soulwars.core.jobs.game;

import org.minigames.soulwars.util.Actions;
import org.minigames.soulwars.util.Areas;
import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.methods.Players;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 22/04/13
 * Time: 23:22
 * To change this template use File | Settings | File Templates.
 */
public class LeaveGrave extends Node {
    @Override
    public boolean activate() {
        return Variables.isInGame() && Variables.isInArea(Areas.graveList) && Players.getLocal().getAnimation() == -1;
    }

    @Override
    public void execute() {
        Actions.leaveGrave(Variables.GRAVE_BARRIER_IDS);
    }
}
