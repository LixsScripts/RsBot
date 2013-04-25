package org.minigames.soulwars.core.jobs.game.combat;

import org.minigames.soulwars.util.Areas;
import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.methods.Players;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.NPCs;
import org.powerbot.game.api.wrappers.interactive.NPC;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 24/04/13
 * Time: 23:08
 * To change this template use File | Settings | File Templates.
 */
public class AttackNPC extends Node {
    @Override
    public boolean activate() {
        return Variables.isInGame() && !Variables.isInArea(Areas.graveList) && !Players.getLocal().isInCombat();
    }

    @Override
    public void execute() {
        final NPC npc = NPCs.getNearest(Variables.npcId);
        if (npc != null) {
            if (!npc.isOnScreen())
                Walking.walk(npc);
            while(!npc.isOnScreen() && npc.getHealthPercent() > 0)
                Task.sleep(50, 100);
            npc.interact("Attack");
            Variables.waitFor(Players.getLocal().isInCombat(), 1500);
        }
    }
}
