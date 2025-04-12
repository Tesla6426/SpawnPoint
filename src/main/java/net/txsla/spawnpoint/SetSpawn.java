package net.txsla.spawnpoint;

import org.bukkit.Location;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class SetSpawn implements CommandExecutor, TabExecutor {
    private final SpawnPoint plugin;

    public SetSpawn(SpawnPoint plugin) { this.plugin = plugin; }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String s, @NotNull String[] arg) {
        Location loc = sender.getServer().getPlayer(sender.getName()).getLocation();
        // set location to player as default

        double[] coords = new double[]{loc.getX(), loc.getY(), loc.getZ()};
        // check if specific location is specified
        try {
            // If not enough
            if (arg.length > 2) {
                if (!arg[0].equals("~")) coords[0] = Double.parseDouble(arg[0]);
                if (!arg[1].equals("~")) coords[1] = Double.parseDouble(arg[1]);
                if (!arg[2].equals("~")) coords[2] = Double.parseDouble(arg[2]);
            }
            sender.sendMessage("§aSpawn set to " + Math.round(coords[0]) + " " + Math.round(coords[1]) + " " + Math.round(coords[2]));
        } catch (Exception e) {
            // try catch in case of invalid input
            sender.sendMessage("§cError getting coordinates!");
            return false;
        }

        // set spawn and save
        SpawnPoint.spawn.set(coords[0], coords[1], coords[2]);
        SpawnPoint.spawn.setYaw(Objects.requireNonNull(sender.getServer().getPlayer(sender.getName())).getYaw());
        SpawnPoint.spawn.setPitch(Objects.requireNonNull(sender.getServer().getPlayer(sender.getName())).getPitch());
        SpawnPoint.spawn.setWorld(Objects.requireNonNull(sender.getServer().getPlayer(sender.getName())).getWorld());
        plugin.getConfig().set("spawn", SpawnPoint.spawn);
        plugin.saveConfig();
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        List<String> tab = new ArrayList<>();
        tab.add("~");
        tab.add("~ ~");
        tab.add("~ ~ ~");
        return tab;
    }
}
