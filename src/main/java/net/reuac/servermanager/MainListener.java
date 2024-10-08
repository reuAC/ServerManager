package net.reuac.servermanager;

import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.PlayerJoinEvent;
import org.bukkit.event.player.PlayerQuitEvent;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

public class MainListener implements Listener {
    static boolean autoVenable;

    static List<Player> playerV = new ArrayList<Player>();
    static public void byer(Player player){
        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2► "+ ServerManager.pluginsName +" | &fFrom &f&nhttps://github.com/reuAC/ServerManager"));
    }
    static public void makePlayerV(){
        for (Player i : Bukkit.getOnlinePlayers()) {
            Iterator<Player> it = playerV.iterator();
            while (it.hasNext()) {
                Player players = it.next();
                if (!i.equals(players)) {
                    i.hidePlayer(players);
                }
            }
        }
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    public void onPlayerJoin(PlayerJoinEvent event) {

        if (!autoVenable){
            makePlayerV();
            return;
        }

        Player player = event.getPlayer();
        if (player.hasPermission("servermanager.v")) {
            event.setJoinMessage("");
            playerV.add(player);
        }
        makePlayerV();

        player.sendMessage(ChatColor.translateAlternateColorCodes('&',"&2► "+ ServerManager.pluginsName +" | &f已为您设置为隐身模式。"));
        byer(player);
    }

    @EventHandler(priority = EventPriority.HIGHEST)
    private void onPlayerQuit(PlayerQuitEvent event) {
        playerV.remove(event.getPlayer());
    }
}
