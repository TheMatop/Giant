package org.thematop.lifeSteal;

import org.bukkit.Material;
import org.bukkit.NamespacedKey;
import org.bukkit.inventory.ItemStack;
import org.bukkit.inventory.ShapedRecipe;
import org.bukkit.plugin.java.JavaPlugin;
import org.thematop.lifeSteal.Commands.GiveAppleOfNature;
import org.thematop.lifeSteal.Commands.GiveSword;
import org.thematop.lifeSteal.Commands.ToggleGiant;
import org.thematop.lifeSteal.Items.Apple_of_nature;
import org.thematop.lifeSteal.Listeners.EatingListener;
import org.thematop.lifeSteal.Listeners.SwordAbilityListener;
import org.thematop.lifeSteal.Listeners.TitanRoarListener;

import java.util.HashMap;
import java.util.Map;
import java.util.UUID;

public class Main extends JavaPlugin {
    public static Main instance;
    public static Map<UUID, Boolean> giantMode = new HashMap<>();

    @Override
    public void onEnable() {
        instance = this;

        getCommand("givesword").setExecutor(new GiveSword(this));
        getCommand("ToggleGiant").setExecutor(new ToggleGiant());
        getCommand("GiveAppleOfNature").setExecutor(new GiveAppleOfNature());
        getServer().getPluginManager().registerEvents(new SwordAbilityListener(this), this);
        getServer().getPluginManager().registerEvents(new EatingListener(this), this);
        getServer().getPluginManager().registerEvents(new TitanRoarListener(this), this);

        getLogger().severe("Command registered: " + (getCommand("givesword") != null));

        NamespacedKey key = new NamespacedKey(this, "apple_of_nature");
        ItemStack item = new ItemStack(Apple_of_nature.apple_of_nature(this));

        ShapedRecipe AppleOfNature = new ShapedRecipe(key, item);
        AppleOfNature.shape("AAA", "ABA", "AAA");
        AppleOfNature.setIngredient('A', Material.OAK_SAPLING);
        AppleOfNature.setIngredient('B', Material.APPLE);

        getServer().addRecipe(AppleOfNature);
    }
}
