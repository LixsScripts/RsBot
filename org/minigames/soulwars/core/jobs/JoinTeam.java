package org.minigames.soulwars.core.jobs;

import org.minigames.soulwars.util.Actions;
import org.minigames.soulwars.util.Variables;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.input.Keyboard;

public class JoinTeam extends Node {
    @Override
    public boolean activate() {
        return !Variables.isInGame() && !Variables.isInLobby();
    }

    @Override
    public void execute() {
        Variables.state = "& joining " + Variables.teamColor + "team.";
        while(!Variables.isInLobby()) {
            Actions.passBarrier(Variables.teamBarrierId);
            Task.sleep(450, 650);
            if (Widgets.canContinue()) {
                Widgets.clickContinue();
                while(!Widgets.getChild(77856771).isOnScreen())
                    Task.sleep(50, 100);
                Keyboard.sendText("1", false);
            }
        }
        Variables.state = ".";
        Task.sleep(800, 1000);
    }
}
