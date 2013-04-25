package org.minigames.soulwars.util;

import org.powerbot.core.script.util.Random;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.node.SceneObject;

public class Actions {

    public static void leaveGrave(final int[] ids) {
        final SceneObject graveBarrier = SceneEntities.getNearest(ids);
        if (graveBarrier != null) {
            if (!graveBarrier.isOnScreen())
                Walking.walk(graveBarrier);
            graveBarrier.interact("Pass");
            Variables.waitFor(Players.getLocal().isMoving(), Random.nextInt(800, 1000));
            Variables.waitFor(!Players.getLocal().isMoving(), Random.nextInt(2000, 3000));
        }
    }

    public static void passBarrier(final int id) {
        final SceneObject barrier = SceneEntities.getNearest(id);
        if (barrier != null) {
            if (!barrier.isOnScreen())
                Walking.walk(barrier);
            barrier.interact(Variables.teamStr);
            Variables.waitFor(Players.getLocal().isMoving(), Random.nextInt(800, 1000));
            Variables.waitFor(!Players.getLocal().isMoving(), Random.nextInt(2500, 3500));
        }
    }

    public static void walkTo(final Tile destinationTile) {
        if (!destinationTile.canReach()) {
            Walking.walk(destinationTile.randomize(1, 1));
            Variables.waitFor(Calculations.distance(Walking.getDestination(), Players.getLocal()) < 5, Random.nextInt(1200, 2000));
        }
    }
}
