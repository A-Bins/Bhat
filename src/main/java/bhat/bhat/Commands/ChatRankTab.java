package bhat.bhat.Commands;

import org.bukkit.Bukkit;
import org.bukkit.command.Command;
import org.bukkit.command.CommandSender;
import org.bukkit.command.TabCompleter;
import org.bukkit.command.TabExecutor;
import org.bukkit.entity.Player;
import org.bukkit.util.StringUtil;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class ChatRankTab implements TabCompleter {
    @Override
    public List<String> onTabComplete(CommandSender sender, Command command, String label, String[] args) {
        List<String> completions = new ArrayList<>();
        List<String> commands = new ArrayList<>();
        if (args.length == 1) {
            for (Player p : Bukkit.getOnlinePlayers()) {
                commands.add(p.getName());

                StringUtil.copyPartialMatches(args[0], commands, completions);
            }
        }else{
            commands.add("A");
            commands.add("C");
            commands.add("F");

            StringUtil.copyPartialMatches(args[1], commands, completions);
        }

        Collections.sort(completions);
        return completions;
    }

}
