package net.txsla.spawnpoint;

import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerRespawnEvent;

import static net.txsla.spawnpoint.SpawnPoint.spawn;
import static net.txsla.spawnpoint.SpawnPoint.random;
public class Listener implements org.bukkit.event.Listener {
    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin (PlayerJoinEvent event) {
        if (random) { event.getPlayer().teleport(Random.location() ); return; }
        event.getPlayer().teleport(spawn);
    }
    @EventHandler(priority = EventPriority.HIGHEST)
    void onPlayerRespawn(final PlayerRespawnEvent event) {
        if (random) { event.setRespawnLocation(Random.location()) ; return; }
        event.setRespawnLocation(spawn);
    }
}
