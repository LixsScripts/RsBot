package org.minigames.soulwars.core.jobs.game.walking;

import org.minigames.soulwars.util.Actions;
import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.state.Node;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 24/04/13
 * Time: 20:15
 * To change this template use File | Settings | File Templates.
 */
public class WalkToObelisk extends Node {
    @Override
    public boolean activate() {
        return Variables.isInGame() && Variables.moveToObelisk() && Variables.collecting && Variables.isReadyDump() ||
                Variables.isInGame() && Variables.moveToObelisk() && !Variables.collecting;
    }

    @Override
    public void execute() {
        Actions.walkTo(Variables.Objects.SOUL_OBELISK.getSceneObject().getLocation());
    }
}
