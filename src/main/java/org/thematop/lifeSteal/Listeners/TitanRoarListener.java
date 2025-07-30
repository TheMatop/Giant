package org.thematop.lifeSteal.Listeners;

import org.bukkit.Location;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.Sound;
import org.bukkit.entity.Entity;
import org.bukkit.entity.Pig;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;
import org.bukkit.persistence.PersistentDataContainer;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.util.Vector;

import java.util.Collection;
import java.util.Objects;

public class TitanRoarListener implements Listener {

    private final JavaPlugin plugin;

    public TitanRoarListener(JavaPlugin plugin) {
        this.plugin = plugin;
    }

    @EventHandler
    public void onPlayerRightClick(PlayerInteractEvent event) {



        Action action = event.getAction();

        if (action != Action.RIGHT_CLICK_AIR && action != Action.RIGHT_CLICK_BLOCK) return;

        Player player = event.getPlayer();
        ItemStack item = player.getInventory().getItemInMainHand();

        if (item != null && item.getType() == Material.WIND_CHARGE && player.getCooldown(Material.WIND_CHARGE) == 0) {
            event.setCancelled(true);
            titanRoar(player.getLocation());
            player.setCooldown(Material.WIND_CHARGE, 100);
            player.sendMessage("Wind");
        }


    }

    public void titanRoar(Location giantLocation) {
        double radius = 10.0;

        Collection<Entity> nearbyEntites = giantLocation.getWorld().getNearbyEntities(giantLocation, radius, radius, radius);

        for (Entity entity : nearbyEntites) {
            if (entity instanceof Pig pig) {
                Vector knockback = pig.getLocation().toVector().subtract(giantLocation.toVector()).normalize().multiply(2);

                knockback.setY(0.5);

                pig.setVelocity(knockback);
            }
        }

        giantLocation.getWorld().playSound(giantLocation, Sound.ENTITY_ENDER_DRAGON_GROWL, 2.0f, 1.0f);
    }

}
