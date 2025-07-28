package org.thematop.lifeSteal;

import org.bukkit.plugin.java.JavaPlugin;
import org.thematop.lifeSteal.Commands.GiveAppleOfNature;
import org.thematop.lifeSteal.Commands.GiveSword;
import org.thematop.lifeSteal.Commands.ToggleGiant;
import org.thematop.lifeSteal.Listeners.EatingListener;
import org.thematop.lifeSteal.Listeners.SwordAbilityListener;

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

        getLogger().severe("Command registered: " + (getCommand("givesword") != null));
    }
}
