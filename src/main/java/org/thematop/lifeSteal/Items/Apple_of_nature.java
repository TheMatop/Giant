package org.thematop.lifeSteal.Items;

import net.kyori.adventure.text.Component;
import net.kyori.adventure.text.format.NamedTextColor;
import net.kyori.adventure.text.format.TextDecoration;
import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemRarity;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.meta.ItemMeta;
import org.bukkit.inventory.meta.components.FoodComponent;
import org.bukkit.persistence.PersistentDataType;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.potion.PotionEffect;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;
import org.thematop.lifeSteal.Main;

import java.util.List;
import java.util.Map;

public class Apple_of_nature {
    public static ItemStack apple_of_nature(JavaPlugin plugin) {
        ItemStack apple = new ItemStack(Material.APPLE);
        ItemMeta meta = apple.getItemMeta();
        Component displyname = Component.text("Apple of nature", NamedTextColor.GREEN)
                .decoration(TextDecoration.ITALIC, false);

        if(meta != null)
        {
            meta.displayName(displyname);
            meta.setRarity(ItemRarity.RARE);

            NamespacedKey key = new NamespacedKey(Main.instance, "apple_of_nature");
            meta.getPersistentDataContainer().set(key, PersistentDataType.INTEGER, 1);

            apple.setItemMeta(meta);
        }
        return apple;
    }
}
