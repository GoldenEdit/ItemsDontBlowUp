package dev.goldenedit.itemsdontblowup;

import org.bukkit.Material;
import org.bukkit.entity.EntityType;
import org.bukkit.entity.Item;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.EntityDamageEvent;
import org.bukkit.plugin.java.JavaPlugin;

public final class ItemsDontBlowUp extends JavaPlugin implements Listener {

    @Override
    public void onEnable() {
        this.getLogger().info("ItemsDontBlowUp has started");
        this.getLogger().info("https://goldenedit.dev");
        this.getServer().getPluginManager().registerEvents(this, this);

    }
    @EventHandler(priority = EventPriority.LOWEST)
    private void onEventExplosion(final EntityDamageEvent e) {
        if (e.getEntity().getType() != EntityType.DROPPED_ITEM || !(e.getEntity() instanceof Item)) {
            return;
        }
        if (e.getCause() != EntityDamageEvent.DamageCause.BLOCK_EXPLOSION
                && e.getCause() != EntityDamageEvent.DamageCause.ENTITY_EXPLOSION) {
            return;
        }
//        final Material type = ((Item) e.getEntity()).getItemStack().getType();
//        if (type != Material.YOUR_GODLY_MATERIAL) {
//            return;
//        } // Could be used later on if a whitelist of items that can be deleted by explosions were to be added
        e.setCancelled(true);
    }

    @Override
    public void onDisable() {
        // Plugin shutdown logic
    }
}
