package org.minigames.soulwars.core.jobs;

import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.util.Random;
import org.powerbot.core.script.util.Timer;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.input.Mouse;
import org.powerbot.game.api.methods.widget.Camera;

import java.awt.*;

/**
 * Created with IntelliJ IDEA.
 * User: Luke
 * Date: 22/04/13
 * Time: 23:03
 * To change this template use File | Settings | File Templates.
 */
public class Waiting extends Node {
    @Override
    public boolean activate() {
        return Variables.isInLobby() && !Variables.actionTimer.isRunning();
    }

    @Override
    public void execute() {
        switch(Random.nextInt(0, 1)) {
            case 0:
                final Point randomPoint = Variables.getRandomPoint(Game.getDimensions());
                if (randomPoint != null)
                    Mouse.move(randomPoint);
                break;
            case 1:
                Camera.getAngleTo(Random.nextInt(0, 355));
                break;
        }
        Variables.actionTimer = new Timer(Random.nextInt(40000, 75000));
    }
}
