package org.minigames.soulwars.core.jobs.game.misc;

import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.util.Filter;
import org.powerbot.game.api.wrappers.interactive.Player;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 25/04/13
 * Time: 00:13
 * To change this template use File | Settings | File Templates.
 */
public class HealPlayer extends Node {
    @Override
    public boolean activate() {
        return Variables.isInGame() && !Variables.needBandages() && Variables.healer;
    }

    @Override
    public void execute() {
        Inventory.getItem(Variables.Items.BANDAGE.getId()).getWidgetChild().interact("Use");
        Players.getNearest(new Filter<Player>() {
            @Override
            public boolean accept(Player player) {
                return player != null && player.getTeam() == Players.getLocal().getTeam() && player.getHealthPercent() < 90;
            }
        }).interact("Heal");
    }
}
