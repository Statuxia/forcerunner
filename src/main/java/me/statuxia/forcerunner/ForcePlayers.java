package me.statuxia.forcerunner;

import org.bukkit.Location;
import org.bukkit.util.Vector;

import java.util.HashMap;
import java.util.Map;

public class ForcePlayers {

    private static Map<String, Location> players = new HashMap<>();

    public static void setLocation(String player, Location location) {
        players.put(player, location.clone());
    }

    public static Location getLocation(String player) {
        return players.get(player);
    }

    public static void removeLocation(String player) {
        players.remove(player);
    }
}
