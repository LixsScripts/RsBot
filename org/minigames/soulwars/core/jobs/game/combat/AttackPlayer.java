package org.minigames.soulwars.core.jobs.game.combat;

import org.minigames.soulwars.util.Areas;
import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.interactive.Player;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 24/04/13
 * Time: 20:13
 * To change this template use File | Settings | File Templates.
 */
public class AttackPlayer extends Node {
    @Override
    public boolean activate() {
        return Variables.isInGame() && !Variables.isInArea(Areas.graveList) && Variables.isInArea(Areas.SOUL_OBELISK) &&
                !Players.getLocal().isInCombat() && Players.getLocal().getInteracting() == null;
    }

    @Override
    public void execute() {
        Players.getNearest(new Filter<Player>() {
            @Override
            public boolean accept(Player player) {
                return player != null && player.getTeam() != Players.getLocal().getTeam() &&
                        Areas.SOUL_OBELISK.contains(player);
            }
        }).interact("Attack");
        Variables.waitFor(Players.getLocal().isInCombat(), 1500);
    }
}
