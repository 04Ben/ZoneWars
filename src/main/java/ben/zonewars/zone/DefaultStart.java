package ben.zonewars.zone;

import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Difficulty;
import org.bukkit.GameRule;
import org.bukkit.Sound;
import org.bukkit.entity.Player;

public class DefaultStart {
    public void settings() {
        Bukkit.getWorld("world").setTime(0);
        Bukkit.getWorld("world").setGameRule(GameRule.FALL_DAMAGE, true);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_MOB_SPAWNING, true);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_WEATHER_CYCLE, true);
        Bukkit.getWorld("world").setGameRule(GameRule.FIRE_DAMAGE, true);
        Bukkit.getWorld("world").setDifficulty(Difficulty.HARD);
        Bukkit.getWorld("world").setHardcore(true);
    }
    public void settingsPvP() {
        Bukkit.getWorld("world").setPVP(true);
    }
    public void sendWarning(int x) {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.spigot().sendMessage(ChatMessageType.CHAT, new TextComponent(ChatColor.RED + "Zone " + x + " closes!"));
        }
    }
    public void sendEnde()
    {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.playSound(player.getLocation(), Sound.BLOCK_AMETHYST_BLOCK_FALL,1,1);
            player.spigot().sendMessage(ChatMessageType.CHAT, new TextComponent(ChatColor.RED + "END FIGHT!"));
        }
    }
}
