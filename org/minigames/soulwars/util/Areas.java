package org.minigames.soulwars.util;

import org.powerbot.core.script.util.Random;
import org.powerbot.game.api.methods.Walking;
import org.powerbot.game.api.wrappers.Area;
import org.powerbot.game.api.wrappers.Tile;

import java.util.ArrayList;

public class Areas {

    public static Tile getRandomTile(final Area a) {
        return a.getTileArray()[Random.nextInt(0, a.getTileArray().length - 1)];
    }

    public static void walkToArea(final Area a) {
        final Tile t = getRandomTile(a);
        if (!t.canReach()) {
            Walking.findPath(t).traverse();
        } else {
            Walking.walk(t);
        }
    }

    public static Area getClosest(final Area area0, final Area area1) {
        double d0, d1;
        d0 = Variables.getRealDistance(area0.getCentralTile());
        d1 = Variables.getRealDistance(area1.getCentralTile());
        if (d0 < d1) return area0; else return area1;
    }

    public final static Area BLUE_LOBBY = new Area(
            new Tile(2199, 2846, 0), new Tile(1816, 3220, 0),
            new Tile(1823, 3220, 0), new Tile(1823, 3230, 0));
    public final static Area RED_LOBBY = new Area(
            new Tile(2219, 2847, 0), new Tile(2220, 2837, 0),
            new Tile(2229, 2837, 0), new Tile(2229, 2846, 0));
    public final static Area BLUE_GRAVE = new Area(
            new Tile(1816, 3230, 0), new Tile(1816, 3220, 0),
            new Tile(1823, 3220, 0), new Tile(1823, 3230, 0));
    public final static Area RED_GRAVE = new Area(
            new Tile(1958, 3235, 0), new Tile(1957, 3234, 0),
            new Tile(1952, 3234, 0), new Tile(1951, 3235, 0),
            new Tile(1951, 3243, 0), new Tile(1952, 3244, 0),
            new Tile(1957, 3244, 0), new Tile(1958, 3243, 0));
    public final static Area WEST_GRAVE = new Area(
            new Tile(2160, 2900, 0), new Tile(2160, 2897, 0),
            new Tile(2163, 2897, 0), new Tile(2163, 2900, 0));
    public final static Area EAST_GRAVE = new Area(
            new Tile(2251, 2927, 0), new Tile(2251, 2924, 0),
            new Tile(2254, 2924, 0), new Tile(2254, 2927, 0));
    public final static Area SOUTH_JELLIES = new Area(
            new Tile(2191, 2897, 0), new Tile(2213, 2897, 0),
            new Tile(2213, 2881, 0), new Tile(2192, 2883, 0));
    public final static Area NORTH_JELLIES = new Area(
            new Tile(2188, 2944, 0), new Tile(2188, 2928, 0),
            new Tile(2195, 2925, 0), new Tile(2222, 2924, 0),
            new Tile(2227, 2937, 0), new Tile(2202, 2944, 0));
    public final static Area RED_PRYE_FEINDS = new Area(
            new Tile(2257, 2900, 0), new Tile(2237, 2900, 0),
            new Tile(2237, 2885, 0), new Tile(2249, 2883, 0),
            new Tile(2257, 2883, 0));
    public final static Area BLUE_PRYE_FEINDS = new Area(
            new Tile(2154, 2937, 0), new Tile(2154, 2918, 0),
            new Tile(2179, 2919, 0), new Tile(2181, 2931, 0),
            new Tile(2181, 2941, 0), new Tile(2163, 2941, 0));
    public final static Area SOUL_OBELISK = new Area(
            new Tile(2199, 2919, 0), new Tile(2198, 2905, 0),
            new Tile(2214, 2903, 0), new Tile(2214, 2919, 0));

    public static ArrayList<Area> graveList = new ArrayList<Area>();

    public static void setHomeGrave() {
        graveList.add(RED_GRAVE);
        graveList.add(BLUE_GRAVE);
    }
}
