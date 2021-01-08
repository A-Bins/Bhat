package bhat.bhat;

import bhat.bhat.Commands.ChatRank;
import bhat.bhat.Commands.ChatRankTab;
import bhat.bhat.Events.Chat;
import bhat.bhat.util.Function;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.Bukkit;
import org.bukkit.entity.Player;
import org.bukkit.plugin.java.JavaPlugin;

import java.util.HashMap;
import java.util.UUID;

public final class Bhat extends JavaPlugin {
    private static HashMap<UUID,  String> PlayerRank = new HashMap<>();
    private static Bhat Instance;

    public static Bhat getInstance() {
        return Instance;
    }

    public static  HashMap<UUID,  String> getPlayerRank() {
        return PlayerRank;
    }
    @Override
    public void onEnable() {
        getDataFolder().mkdir();
        Instance = this;
        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Bhat Bins#1004가 만들어써용");
        getCommand("채팅랭크").setExecutor(new ChatRank());
        getCommand("채팅랭크").setTabCompleter(new ChatRankTab());
        getServer().getPluginManager().registerEvents(new Chat(),this);
        Bukkit.getScheduler().runTaskTimerAsynchronously(this , () -> {
            for(Player p : Bukkit.getOnlinePlayers()){
                getPlayerRank().putIfAbsent(p.getUniqueId(), "C");
            }
        }, 1,1);
        Function.loadString(this,PlayerRank,"PlayerRank");

        Bukkit.getScheduler().runTaskTimer(this , () -> {

            Function.save(this,PlayerRank,"PlayerRank");
        }, 20 * 10,20 * 10);
    }

    @Override
    public void onDisable() {

        Bukkit.getConsoleSender().sendMessage(ChatColor.GREEN+"Bhat Bins#1004가 만들어써용");
    }
}
