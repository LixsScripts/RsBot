package org.minigames.soulwars.core.jobs.game.pickup;

import org.minigames.soulwars.util.Areas;
import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.util.Random;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.node.GroundItems;
import org.powerbot.game.api.wrappers.node.GroundItem;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 24/04/13
 * Time: 23:42
 * To change this template use File | Settings | File Templates.
 */
public class TakeSouls extends Node {
    @Override
    public boolean activate() {
        return Variables.isInGame() && !Variables.isInArea(Areas.graveList) && Variables.collecting &&
                GroundItems.getNearest(Variables.Items.SOUL_FRAGMENTS.getId()) != null;

    }

    @Override
    public void execute() {
        final GroundItem groundItem = GroundItems.getNearest(Variables.Items.SOUL_FRAGMENTS.getId());
        if (!groundItem.isOnScreen())
            Walking.walk(groundItem);
        groundItem.interact("Take");
        Variables.waitFor(!groundItem.isOnScreen(), Random.nextInt(1200, 2000));
    }
}
