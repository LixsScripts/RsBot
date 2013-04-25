package org.minigames.soulwars.core.jobs.game.combat;

import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 24/04/13
 * Time: 23:31
 * To change this template use File | Settings | File Templates.
 */
public class Heal extends Node {
    @Override
    public boolean activate() {
        return Variables.isInGame() && !Variables.needBandages() && (Players.getLocal().getHealthPercent() <= 50);
    }

    @Override
    public void execute() {

    }
}
