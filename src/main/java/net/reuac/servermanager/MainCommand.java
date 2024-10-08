package net.reuac.servermanager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.GameMode;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

public class MainCommand implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender commandSender, Command command, String s, String[] args) {
        if (commandSender instanceof Player) {
            Player player = (Player) commandSender;
            if (args.length == 1 && args[0].equalsIgnoreCase("v")) {
                if (player.hasPermission("servermanager.v")) {
                    if (MainListener.playerV.contains(player)){
                        for (Player i : Bukkit.getOnlinePlayers()) {
                            i.showPlayer(player);
                        }
                        MainListener.playerV.remove(player);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2► "+ ServerManager.pluginsName +" | &f已为您取消隐身模式。"));
                    }else {
                        MainListener.playerV.add(player);
                        MainListener.makePlayerV();
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2► "+ ServerManager.pluginsName +" | &f已为您设置为隐身模式。"));
                    }
                }else {
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2► "+ ServerManager.pluginsName +" | &c您无权执行该指令。"));
                }
                MainListener.byer(player);
            }else if (args.length == 1 && args[0].equalsIgnoreCase("gm")){
                if (player.hasPermission("servermanager.gm")) {
                    if (player.getGameMode().equals(GameMode.SURVIVAL)){
                        player.setGameMode(GameMode.SPECTATOR);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2► "+ ServerManager.pluginsName +" | &f已为您设置为观察者模式。"));
                    }else{
                        player.setGameMode(GameMode.SURVIVAL);
                        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2► "+ ServerManager.pluginsName +" | &f已为您设置为生存模式。"));
                    }
                }else{
                    player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2► "+ ServerManager.pluginsName +" | &c您无权执行该指令。"));
                }
                MainListener.byer(player);
            }else if (player.hasPermission("servermanager.gm") || player.hasPermission("servermanager.v")) {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2► "+ ServerManager.pluginsName +" | &f/servermanager gm &a用于切换观察者/生存模式"));
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2► "+ ServerManager.pluginsName +" | &f/servermanager v &a用于开关隐身模式"));
            }else {
                player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2► "+ ServerManager.pluginsName +" | &c您无权执行该指令。"));
            }
        }else {
            ServerManager.main.reloadConfig();
            ServerManager.main.loadConfig();
            System.out.println("[ServerManager] 插件已重新加载。");
        }
        return false;
    }
}
