package me.glaremasters.click2sell;

import java.util.HashMap;
import org.bukkit.Bukkit;
import org.bukkit.Material;
import org.bukkit.event.EventHandler;
import org.bukkit.event.block.Action;
import org.bukkit.event.player.PlayerInteractEvent;
import org.bukkit.inventory.ItemStack;

/**
 * Created by GlareMasters on 12/24/2017.
 */
public class Listener implements org.bukkit.event.Listener {

    private HashMap<String, Long> cooldowns = new HashMap<>();

    @EventHandler
    public void onPickaxeInteract(PlayerInteractEvent event) {
        if (!(event.getAction() == Action.RIGHT_CLICK_BLOCK)) {
            return;
        }
        ItemStack pickaxe = new ItemStack(Material.DIAMOND_PICKAXE);

        if (!(event.getPlayer().getInventory().getItemInHand().equals(pickaxe))) {
            return;
        }
        int cooldownTime = 5;
        if (cooldowns.containsKey(event.getPlayer().getName())) {
            long secondsLeft =
                    ((cooldowns.get(event.getPlayer().getName()) / 1000) + cooldownTime) - (
                            System.currentTimeMillis() / 1000);
            if (secondsLeft > 0) {
                Bukkit.dispatchCommand(event.getPlayer(), Main.getInstance().getConfig().getString("command"));

            }
        }
        cooldowns.put(event.getPlayer().getName(), System.currentTimeMillis());
        event.getPlayer().sendMessage("Right click again to sell all!");
    }

}
