package org.thematop.lifeSteal.Commands;

import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;
import org.jetbrains.annotations.NotNull;
import org.thematop.lifeSteal.Items.Sword;

public class GiveSword implements CommandExecutor {
    JavaPlugin plugin;

    public GiveSword(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players");
            return true;
        }

        player.getInventory().addItem(Sword.Swords(plugin));
        player.sendMessage("You have been given an apple of nature");
        return true;
    }
}
