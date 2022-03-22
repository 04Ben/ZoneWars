package ben.zonewars.commands;

import ben.zonewars.Main;
import ben.zonewars.timer.Countdown;
import ben.zonewars.timer.Timer;
import ben.zonewars.zone.Run;
import net.md_5.bungee.api.ChatColor;
import org.bukkit.command.Command;
import org.bukkit.command.CommandExecutor;
import org.bukkit.command.CommandSender;
import org.bukkit.entity.Player;

import java.util.Locale;

public class Commands implements CommandExecutor {
    @Override
    public boolean onCommand(CommandSender sender, Command command, String label, String[] args) {
        Timer timer = Main.getInstance().getTimer();
        Countdown countdown = Main.getInstance().getCountdown();
        Player player = (Player) sender;
        if(timer.isRunning() || countdown.isRunning()) {
            player.sendMessage(ChatColor.RED + "The match already started!");
        } else {

            if (args.length > 0) {
                Run run = new Run();
                args[0] = args[0].toLowerCase(Locale.ROOT);
                switch (args[0]) {
                    case "start":
                        if (args.length != 2) {
                            startMessage(player);
                        } else {
                            args[1] = args[1].toLowerCase(Locale.ROOT);
                            switch (args[1]) {
                                case "small":
                                    run.small();
                                    break;
                                case "middle":
                                    run.middle();
                                    break;
                                case "big":
                                    run.big();
                                    break;
                                default:
                                    startMessage(player);
                                    break;
                            }
                        }
                        break;
                    case "creator":
                        player.sendMessage(ChatColor.GREEN + "This plugin is programmed by beeeenane");
                        break;
                    default:
                        defaultMessage(player);
                        break;
                }
                return true;
            }
            return false;
        }
        return true;
    }
    private void defaultMessage(Player sender)
    {
        sender.sendMessage(ChatColor.RED  + "/zonewars <start | creator> [<small | middle | big>]");
    }
    private void startMessage(Player sender) {
        sender.sendMessage(ChatColor.RED + "/zonewars <start> [<small | middle | big>]");
    }
}
