package org.minigames.soulwars.core.jobs.game.combat;

import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Filter;
import sk.action.ActionBar;
import sk.action.BarNode;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 24/04/13
 * Time: 20:47
 * To change this template use File | Settings | File Templates.
 */
public class Fighting extends Node {
    @Override
    public boolean activate() {
        return Variables.isInGame() && Players.getLocal().getInteracting() != null && Players.getLocal().getInteracting().isInCombat();
    }

    @Override
    public void execute() {
        ActionBar.getNode(new Filter<BarNode>() {
            @Override
            public boolean accept(BarNode barNode) {
                return barNode != null && barNode.canUse();
            }
        }).use();
    }
}
