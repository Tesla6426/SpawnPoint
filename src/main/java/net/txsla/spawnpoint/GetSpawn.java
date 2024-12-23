package net.txsla.spawnpoint;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabExecutor;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

import static net.txsla.spawnpoint.SpawnPoint.spawn;

public class GetSpawn implements CommandExecutor, TabExecutor {
    private final SpawnPoint plugin;
    public GetSpawn(SpawnPoint plugin) { this.plugin = plugin; }
    @Override
    public boolean onCommand(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        commandSender.sendMessage(
                "§9SpawnX: " + spawn.getX() +
                   "\n§9SpawnY: " + spawn.getY() +
                   "\n§9SpawnZ: " + spawn.getZ() +
                   "\n§9SpawnYaw: " + spawn.getYaw() +
                   "\n§9SpawnPitch: " + spawn.getPitch() +
                   "\n§9Random?: " + SpawnPoint.random +
                   "\n§9SpawnRadius: "+ SpawnPoint.radius
        );
        return true;
    }

    @Override
    public @Nullable List<String> onTabComplete(@NotNull CommandSender commandSender, @NotNull Command command, @NotNull String s, @NotNull String[] strings) {
        return null;
    }
}
