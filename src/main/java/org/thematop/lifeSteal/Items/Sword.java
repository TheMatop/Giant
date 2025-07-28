package org.thematop.lifeSteal.Items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.enchantments.Enchantment;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.thematop.lifeSteal.Main;

public class Sword {
    public static ItemStack Swords(JavaPlugin plugin) {
        ItemStack sword = ItemStack.of(Material.DIAMOND_SWORD);
        ItemMeta meta = sword.getItemMeta();
        Component displayName = Component.text("Sword of amazingnase", NamedTextColor.AQUA);

        if(meta !=null)
        {
            meta.displayName(displayName);
            meta.addEnchant(Enchantment.SHARPNESS, 5, true);

            NamespacedKey key = new NamespacedKey(Main.instance, "custom_sword");
            meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 1);

            sword.setItemMeta(meta);
        }
        return sword;
    }
}
