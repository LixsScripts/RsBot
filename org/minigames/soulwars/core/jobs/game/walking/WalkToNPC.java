package org.minigames.soulwars.core.jobs.game.walking;

import org.minigames.soulwars.util.Actions;
import org.minigames.soulwars.util.Areas;
import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.NPCs;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 24/04/13
 * Time: 19:30
 * To change this template use File | Settings | File Templates.
 */
public class WalkToNPC extends Node {
    @Override
    public boolean activate() {
        return Variables.isInGame() && !Variables.isInArea(Areas.graveList) &&
                NPCs.getNearest(Variables.npcId) != null && !NPCs.getNearest(Variables.npcId).isOnScreen();
    }

    @Override
    public void execute() {
        Actions.walkTo(NPCs.getNearest(Variables.npcId).getLocation());
    }
}
