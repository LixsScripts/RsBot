package org.minigames.soulwars.core.jobs.game.pickup;

import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Keyboard;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.util.Random;
import org.powerbot.game.api.wrappers.node.SceneObject;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 23/04/13
 * Time: 23:57
 * To change this template use File | Settings | File Templates.
 */
public class TakeBandages extends Node {
    @Override
    public boolean activate() {
        return Variables.isInGame() && Variables.needBandages() &&
                SceneEntities.getNearest(Variables.BANDAGE_TABLE_IDS) != null &&
                SceneEntities.getNearest(Variables.BANDAGE_TABLE_IDS).isOnScreen();
    }

    @Override
    public void execute() {
        final SceneObject table = SceneEntities.getNearest(Variables.BANDAGE_TABLE_IDS);
        table.interact("Take - X");
        Variables.waitFor(Widgets.getChild(0).isOnScreen(), Random.nextInt(800, 1300));
        Keyboard.sendText(Integer.toString(Random.nextInt(28, 99)), true);
    }
}
