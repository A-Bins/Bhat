package bhat.bhat.Commands;

import bhat.bhat.Bhat;
import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.UUID;

public class ChatRank implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        if (args.length >= 2) {
            if (Bukkit.getPlayer(args[0]) != null) {
                Player p = Bukkit.getPlayer(args[0]);
                UUID uuid = p.getUniqueId();
                String str = args[1];
                if(str.equals("A") |str.equals("C") |str.equals("F")){
                    Bhat.getPlayerRank().put(uuid, str);
                    sender.sendMessage("§c설정이 완료되었습니다! " + p.getName() + "님의 랭크가 "+str+"로 변경되었습니다.");
                }

            }
        }
        return false;
    }
}
