package org.thematop.lifeSteal.Commands;

import org.bukkit.attribute.Attribute;
import org.bukkit.attribute.AttributeInstance;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;
import org.jetbrains.annotations.NotNull;
import org.thematop.lifeSteal.Main;


import java.util.Map;

public class ToggleGiant implements CommandExecutor {

    @Override
    public boolean onCommand(@NotNull CommandSender sender, @NotNull Command command, @NotNull String label, @NotNull String[] args) {
        if (!(sender instanceof Player player)) {
            sender.sendMessage("Only players you bit*h");
            return true;
        }


        boolean newState = !Main.giantMode.getOrDefault(player.getUniqueId(), false);

        if (newState) {
            AttributeInstance size = player.getAttribute(Attribute.GENERIC_SCALE);
            if (size != null) {
                size.setBaseValue(6.0);
            }

            AttributeInstance step_height = player.getAttribute(Attribute.GENERIC_STEP_HEIGHT);
            if (step_height != null) {
                step_height.setBaseValue(3.5);
            }

            AttributeInstance Block_range = player.getAttribute(Attribute.PLAYER_BLOCK_INTERACTION_RANGE);
            if (Block_range != null) {
                Block_range.setBaseValue(18.0);
            }

            AttributeInstance Entity_Range = player.getAttribute(Attribute.PLAYER_ENTITY_INTERACTION_RANGE);
            if (Entity_Range != null) {
                Entity_Range.setBaseValue(18.0);
            }

            AttributeInstance move = player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
            if (move != null) {
                move.setBaseValue(0.06);
            }

            AttributeInstance attack_speed = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
            if (attack_speed != null) {
                attack_speed.setBaseValue(3.0);
            }

            AttributeInstance safe_fall = player.getAttribute(Attribute.GENERIC_SAFE_FALL_DISTANCE);
            if (safe_fall != null) {
                safe_fall.setBaseValue(9.0);
            }
        } else {
            AttributeInstance size = player.getAttribute(Attribute.GENERIC_SCALE);
            if (size != null) {
                size.setBaseValue(1.0);
            }

            AttributeInstance step_height = player.getAttribute(Attribute.GENERIC_STEP_HEIGHT);
            if (step_height != null) {
                step_height.setBaseValue(0.6);
            }

            AttributeInstance Block_range = player.getAttribute(Attribute.PLAYER_BLOCK_INTERACTION_RANGE);
            if (Block_range != null) {
                Block_range.setBaseValue(5.0);
            }

            AttributeInstance Entity_Range = player.getAttribute(Attribute.PLAYER_ENTITY_INTERACTION_RANGE);
            if (Entity_Range != null) {
                Entity_Range.setBaseValue(5.0);
            }

            AttributeInstance move = player.getAttribute(Attribute.GENERIC_MOVEMENT_SPEED);
            if (move != null) {
                move.setBaseValue(0.1);
            }

            AttributeInstance attack_speed = player.getAttribute(Attribute.GENERIC_ATTACK_SPEED);
            if (attack_speed != null) {
                attack_speed.setBaseValue(4.0);
            }

            AttributeInstance safe_fall = player.getAttribute(Attribute.GENERIC_SAFE_FALL_DISTANCE);
            if (safe_fall != null) {
                safe_fall.setBaseValue(3.0);
            }
        }

        Main.giantMode.put(player.getUniqueId(), newState);

        player.sendMessage("Giants is now activated: " + newState);

        return true;
    }
}
