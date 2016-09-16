package com.intriqued.EpicHelp;

import java.io.File;
import java.util.List;
import java.util.logging.Logger;
import org.bukkit.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.configuration.file.FileConfiguration;
import org.bukkit.configuration.file.FileConfigurationOptions;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

public class EpicHelp
  extends JavaPlugin
{
  public void onEnable()
  {
    getLogger().info(getConfig().getString("Prefix") + "has been Enabled.");
    if (!new File(getDataFolder(), "config.yml").exists()) {
      getConfig().options().copyDefaults(true);
    }
    saveConfig();
  }
  
  public void onDisable()
  {
    getLogger().info(getConfig().getString("Prefix") + "has been Disabled.");
  }
  
  public boolean onCommand(CommandSender sender, Command cmd, String label, String[] args)
  {
      if (!(sender instanceof Player))
        sender.sendMessage("Only players can run this command!");
        return true;
      {
    List<String> list = getConfig().getStringList("Lines");
    for (String playerlist : list) {
      Player player = (Player)sender;
      if (cmd.getName().equalsIgnoreCase("epicinfo")) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', playerlist));
      }
      if (cmd.getName().equalsIgnoreCase("?")) {
        player.sendMessage(ChatColor.translateAlternateColorCodes('&', playerlist));
      }
    }
    return true;
  }
}
