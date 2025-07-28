package org.thematop.lifeSteal.Listeners;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.NamespacedKey;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerItemConsumeEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.thematop.lifeSteal.Main;

public class EatingListener implements Listener {

    private final JavaPlugin plugin;


    public EatingListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerEat(PlayerItemConsumeEvent event) {
        ItemStack item =  event.getItem();
        Player player = event.getPlayer();

        if (!item.hasItemMeta()) return;

        NamespacedKey key = new NamespacedKey(Main.instance, "apple_of_nature");
        ItemMeta meta = item.getItemMeta();
        PersistentDataContainer container = meta.getPersistentDataContainer();

        if (container.has(key, PersistentDataType.INTEGER)) {
            boolean isGiant = Main.giantMode.getOrDefault(player.getUniqueId(), false);
            if (!isGiant) {
                event.setCancelled(true);
                player.sendMessage(Component.text("Only giants can eat this apple", NamedTextColor.RED));
            } else {
                player.sendMessage(Component.text("You have consumed the apple of nature", NamedTextColor.GOLD));

                // add custom abilities here later
            }
        }
    }
}
