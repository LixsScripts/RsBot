package org.minigames.soulwars.core;

import org.minigames.soulwars.core.jobs.JoinTeam;
import org.minigames.soulwars.core.jobs.Waiting;
import org.minigames.soulwars.core.jobs.game.LeaveGrave;
import org.minigames.soulwars.util.Areas;
import org.minigames.soulwars.util.Variables;
import org.minigames.soulwars.util.ui.GUI;
import org.powerbot.core.event.listeners.PaintListener;
import org.powerbot.core.script.ActiveScript;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.util.Random;
import org.powerbot.game.api.Manifest;
import org.powerbot.game.api.methods.input.Mouse;

import java.awt.*;

@Manifest(authors = { "Lix" }, name = "MightySouls", description = "testing", version = 0.02D)
public class MightySouls extends ActiveScript implements PaintListener {

    @Override
    public void onStart() {
        Variables.nodes.add(new JoinTeam());
        Variables.nodes.add(new Waiting());
        Variables.nodes.add(new LeaveGrave());
        Variables.gui = new GUI();
    }

    @Override
    public int loop() {
        if (Variables.start) {
            for (final Node n : Variables.nodes)
                if (!n.isAlive())
                    if (n.activate())
                        n.execute();
        }
        return Random.nextInt(10, 15);
    }

    @Override
    public void onRepaint(final Graphics g) {
        final Point m = Mouse.getLocation();
        g.setColor(Color.WHITE);
        g.drawString("State :" + Variables.getPlayerState() + Variables.state, 10, 20);
        g.drawString("In lobby :" + Variables.isInLobby(), 10, 35);
        g.drawString("In game :" + Variables.isInGame(), 10, 50);
        if (Variables.isInGame())
            g.drawString("In grave :" + Variables.isInArea(Areas.graveList), 10, 65);
        g.setColor(Color.BLACK);
        g.drawLine(m.x - 900, m.y, m.x + 900, m.y);
        g.drawLine(m.x, m.y - 900, m.x, m.y + 900);
    }
}
