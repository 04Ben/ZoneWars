package ben.zonewars.timer;

import ben.zonewars.Main;
import ben.zonewars.zone.Run;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.Sound;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Countdown {
    private int time;
    private int x;
    private boolean running;
    Run run = new Run();

    public Countdown(int time, boolean running) {
        this.time = time;
        this.running = running;

        run();
    }
    public boolean isRunning() {
        return running;
    }

    public void setRunning(boolean running) {
        this.running = running;
    }

    public int getTime() {
        return time;
    }

    public void setTime(int time) {
        this.time = time;
    }

    public void sendActionBar() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            if(!isRunning()) {
                player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.GREEN + "Waiting for players"));
                continue;
            }
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.BLUE + String.valueOf(time)));

        }
    }
    private void run() {
        new BukkitRunnable() {
            @Override
            public void run() {

                sendActionBar();
                if(!isRunning()) {
                    return;
                }
                if(time == -1) {
                    cancel();
                    playerMessage();
                    switch (x)
                    {
                        case 0:
                            run.startsmall();
                            break;
                        case 1:
                            run.startmiddle();
                            break;
                        case 2:
                            run.startbig();
                            break;
                    }
                    return;
                }
                time--;
            }
        }.runTaskTimer(Main.getInstance(), 20, 20);
    }
    public void setX(int x)
    {
        this.x = x;
    }
    public int getX()
    {
        return x;
    }
    public void playerMessage()
    {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.playSound(player.getLocation(), Sound.BLOCK_NOTE_BLOCK_BIT,1,1);
            player.spigot().sendMessage(ChatMessageType.ACTION_BAR, new TextComponent(ChatColor.RED + "Attention the match starts!"));
        }
    }
}
