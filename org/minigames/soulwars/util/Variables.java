package org.minigames.soulwars.util;

import org.minigames.soulwars.util.ui.GUI;
import org.powerbot.core.script.job.Task;
import org.powerbot.core.script.job.state.Node;
import org.powerbot.core.script.util.Random;
import org.powerbot.core.script.util.Timer;
import org.powerbot.game.api.methods.Calculations;
import org.powerbot.game.api.methods.Game;
import org.powerbot.game.api.methods.Widgets;
import org.powerbot.game.api.methods.interactive.Players;
import org.powerbot.game.api.methods.node.SceneEntities;
import org.powerbot.game.api.methods.tab.Inventory;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Locatable;
import org.powerbot.game.api.wrappers.Tile;
import org.powerbot.game.api.wrappers.map.LocalPath;
import org.powerbot.game.api.wrappers.node.SceneObject;

import java.awt.*;
import java.util.ArrayList;

public class Variables {

    public enum Objects {
        GREEN_PORTAL(42031, "Join-team"),
        RED_BARRIER(42030, "Pass"),
        BLUE_BARRIER(42029, "Pass"),
        SOUL_OBELISK(8593, "Use"),
        BARRACADE(8601, "Attack");

        private int id;
        private String str;

        private Objects(final int objId, final String objStr) {
            this.id = objId;
            this.str = objStr;
        }

        public int getId() {
            return this.id;
        }

        public String getStr() {
            return this.str;
        }

        public SceneObject getSceneObject() {
            return SceneEntities.getNearest(getId());
        }
    }

    public enum Items {
        BANDAGE(1460),
        BONE(14638),
        SOUL_FRAGMENTS(14639);

        private int id;

        private Items(final int itemId) {
            this.id = itemId;
        }

        public int getId() {
            return this.id;
        }
    }

    public static ArrayList<Node> nodes = new ArrayList<Node>();

    public static String teamColor, teamStr, state;
    public static String getPlayerState() {
        if (Players.getLocal().isMoving()) {
            return "player is moving ";
        } else if (Players.getLocal().isInCombat()) {
            return "player is is combat ";
        } else if (Variables.isInLobby()) {
            return "waiting in lobby ";
        }
        return "player is idle...";
    }

    public final static int PRYE_FEIND_ID = 8598, JELLY_ID = 8599;
    public final static int[] BANDAGE_TABLE_IDS = {42023, 42024}, GRAVE_BARRIER_IDS = {42015, 42014};
    public static int teamBarrierId, npcId;
    public static int getSoulCount() {
        return Inventory.getItem(Items.SOUL_FRAGMENTS.getId()).getStackSize();
    }

    public static boolean start = false, collecting, healer, burying;
    public static boolean needBandages() {
        return !Inventory.contains(Items.BANDAGE.getId());
    }
    public static boolean moveToObelisk() {
        return !isInArea(Areas.SOUL_OBELISK) && !isInArea(Areas.graveList);
    }
    public static boolean isReadyDump() {
        return getSoulCount() >= Random.nextInt(10, 15);
    }
    public static boolean isInLobby() {
        return Widgets.getChild(54853650).isOnScreen();
    }
    public static boolean isInGame() {
        return Widgets.getChild(54788103).isOnScreen();
    }
    public static boolean isInArea(final ArrayList<Area> areaList) {
        for(final Area a : areaList)
            if (a.contains(Players.getLocal()))
                return true;
        return false;
    }
    public static boolean isInArea(final Area a) {
        return a.contains(Players.getLocal());
    }
    public static boolean waitFor(boolean condition, long timeout) {
        final Timer t = new Timer(timeout);
        while(!condition && t.isRunning()) { Task.sleep(50, 100); }
        return condition;
    }

    public static double getRealDistance(Locatable loc) {
        if (loc == null || loc.getLocation() == null) return 8999;
        LocalPath lp = new LocalPath(loc.getLocation());
        if (lp.init()) {
            Tile lT = null;
            double totaldist = 0;
            for (Tile cT : lp.getTilePath().toArray()) {
                totaldist += lT != null ? Calculations.distance(lT, cT) : 0;
                lT = cT;
            }
            return totaldist;
        }
        return 8999;
    }

    public static Timer actionTimer = new Timer(0);

    public static Point getRandomPoint(final Dimension dim) {
        final int w = dim.width, h = dim.height;
        final Point p = new Point(Random.nextInt(Game.getBaseX(), Game.getBaseX() + w), Random.nextInt(Game.getBaseY(), Game.getBaseY() + h));
        return p;
    }

    public static GUI gui;
}
