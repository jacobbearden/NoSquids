package com.aefonix.nosquids;

import org.bukkit.entity.Entity;
import org.bukkit.entity.Squid;
import org.bukkit.event.EventHandler;
import org.bukkit.event.Listener;
import org.bukkit.event.entity.CreatureSpawnEvent;
import org.bukkit.event.entity.CreatureSpawnEvent.SpawnReason;
import org.bukkit.plugin.java.JavaPlugin;

public class NoSquids extends JavaPlugin implements Listener {
  @Override
  public void onEnable() {
    this.getServer().getPluginManager().registerEvents(this, this);
  }

  @Override
  public void onDisable() {}

  @EventHandler
  public void onCreatureSpawn(CreatureSpawnEvent event) {
    if (!event.isCancelled()) {
      Entity entity = event.getEntity();

      if (entity instanceof Squid) {
        SpawnReason reason = event.getSpawnReason();

        if (reason == SpawnReason.NATURAL) {
          event.setCancelled(true);
        }
      }
    }
  }
}
