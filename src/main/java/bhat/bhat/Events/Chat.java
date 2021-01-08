package bhat.bhat.Events;

import bhat.bhat.Bhat;
import org.bukkit.Bukkit;
import org.bukkit.ChatColor;
import org.bukkit.entity.Player;
import org.bukkit.event.EventHandler;
import org.bukkit.event.EventPriority;
import org.bukkit.event.Listener;
import org.bukkit.event.player.AsyncPlayerChatEvent;

import java.util.HashMap;
import java.util.UUID;

public class Chat implements Listener {



    @EventHandler(priority = EventPriority.HIGHEST)
    public void onChat(AsyncPlayerChatEvent e){
        Player p = e.getPlayer();
        String str = e.getFormat();
        String strafter = e.getFormat();
        if (Bhat.getPlayerRank().get(p.getUniqueId()).contains("F")){

            strafter = str.replace(e.getMessage()+"","§8"+e.getMessage());

            e.setMessage("§8"+e.getMessage());
        }
        else if(Bhat.getPlayerRank().get(p.getUniqueId()).contains("C")) {

            strafter = str.replace(e.getMessage()+"","§7"+e.getMessage());

            e.setMessage("§7"+e.getMessage());
        }
        if(str.equals(strafter)){

            e.setFormat("§7[" + Bhat.getPlayerRank().get(p.getUniqueId()) + "§7] " + e.getFormat());
        }else{
            e.setFormat("§7[" + Bhat.getPlayerRank().get(p.getUniqueId()) + "§7] " + strafter);
        }



        if (Bhat.getPlayerRank().get(p.getUniqueId()).contains("C") | Bhat.getPlayerRank().get(p.getUniqueId()).contains("A")) {
            for (Player $ : e.getRecipients()) {
                if (Bhat.getPlayerRank().get($.getUniqueId()).contains("F")) {
                    e.getRecipients().remove($);
                }
            }
        } else if (Bhat.getPlayerRank().get(p.getUniqueId()).contains("F")) {
            for (Player $ : e.getRecipients()) {
                if (Bhat.getPlayerRank().get($.getUniqueId()).contains("C") | Bhat.getPlayerRank().get($.getUniqueId()).contains("A")) {

                    e.getRecipients().remove($);
                }
            }
        }

    }
}
