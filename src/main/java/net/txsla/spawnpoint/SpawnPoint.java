package net.txsla.spawnpoint;

import org.bukkit.Location;
import org.bukkit.plugin.java.JavaPlugin;

public final class SpawnPoint extends JavaPlugin {
    public static Location spawn;
    public static boolean random;
    public static double radius;
    @Override
    public void onEnable() {
        // Plugin startup logic
        getLogger().info("Plugin Starting");

        saveDefaultConfig();
        getServer().getPluginManager().registerEvents(new Listener(),this);

        spawn = getConfig().getLocation("spawn");
        if (spawn == null) {
            spawn = getServer().getWorld("world").getSpawnLocation();
        }

        random = getConfig().getBoolean("random-spawn.enable");
        if (random) {
            radius = getConfig().getDouble("random-spawn.radius");
        }

        getCommand("setspawn").setExecutor(new SetSpawn(this) );
        getCommand("getspawn").setExecutor(new GetSpawn(this) );
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
        getLogger().warning("plugin shutting down");
    }
}
