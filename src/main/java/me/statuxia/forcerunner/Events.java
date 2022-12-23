package me.statuxia.forcerunner;

import org.bukkit.Location;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.entity.EntityDamageByEntityEvent;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerMoveEvent;
import org.bukkit.event.player.PlayerQuitEvent;
import org.bukkit.util.Vector;

public class Events implements Listener {

    @EventHandler
    public void onEnter(PlayerJoinEvent event) {
        if (!event.getPlayer().getInventory().contains(ForceFeather.forceFeather)) {
            event.getPlayer().getInventory().addItem(ForceFeather.forceFeather);
        }
    }

    @EventHandler
    public void onFall(EntityDamageEvent event) {
        if (!event.getCause().equals(EntityDamageEvent.DamageCause.FALL) &&
                !event.getCause().equals(EntityDamageEvent.DamageCause.FLY_INTO_WALL)) {
            return;
        }
        if (!(event.getEntity() instanceof Player player)) {
            return;
        }
        if (player.getInventory().contains(ForceFeather.forceFeather) || player.getInventory().getItemInOffHand().equals(ForceFeather.forceFeather)) {
            event.setCancelled(true);
        }
    }

    @EventHandler
    public void onClick(PlayerInteractEvent event) {
        if (event.getAction().equals(Action.RIGHT_CLICK_AIR) ||
                event.getAction().equals(Action.RIGHT_CLICK_BLOCK)) {
            Player player = event.getPlayer();
            Location v1 = ForcePlayers.getLocation(player.getName());
            if (v1 == null) {
                return;
            }
            Location v2 = player.getLocation();
            Vector result = v2.toVector().clone().multiply(1.2).subtract(v1.toVector().multiply(1.2)).multiply(1.2);
            if (result.length() <= 0 || result.length() >= 2) {
                return;
            }
            player.setVelocity(result);
        }
    }

    @EventHandler
    public void onMove(PlayerMoveEvent event) {
        ForcePlayers.setLocation(event.getPlayer().getName(), event.getFrom());
    }

    @EventHandler
    public void onLeft(PlayerQuitEvent event) {
        ForcePlayers.removeLocation(event.getPlayer().getName());
    }
}
