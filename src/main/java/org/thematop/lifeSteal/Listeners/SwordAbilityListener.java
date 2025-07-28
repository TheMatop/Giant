package org.thematop.lifeSteal.Listeners;

import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.Objects;

public class SwordAbilityListener implements Listener {

    private final JavaPlugin plugin;

    public SwordAbilityListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {

        if (!(event.getAction() == Action.RIGHT_CLICK_AIR || event.getAction() ==  Action.RIGHT_CLICK_BLOCK)) {
            return;
        }

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (!item.hasItemMeta()) return;

        PersistentDataContainer container = item.getItemMeta().getPersistentDataContainer();
        NamespacedKey key = new NamespacedKey(plugin, "custom_sword");

        if (container.has(key, PersistentDataType.INTEGER)) {
            player.sendMessage("You activated Thunder Slash!");
            player.getWorld().strikeLightning(Objects.requireNonNull(player.getTargetBlockExact(50)).getLocation());
        }
    }

}
