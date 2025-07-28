package org.thematop.lifeSteal.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.thematop.lifeSteal.Items.Apple_of_nature;

public class GiveAppleOfNature implements CommandExecutor {
    JavaPlugin plugin;
    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("ONLY PLAYERS YOU DAMN CONSOLE");
            return true;
        }

        player.getInventory().addItem(Apple_of_nature.apple_of_nature(plugin));
        player.sendMessage("You have recived the apple of nature");
        return true;
    }
}
