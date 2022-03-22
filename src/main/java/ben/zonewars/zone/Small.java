package ben.zonewars.zone;

import ben.zonewars.Main;
import ben.zonewars.timer.Timer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.GameMode;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Small {
    private int zeit;
    DefaultStart defaultStart = new DefaultStart();
    Timer timer = Main.getInstance().getTimer();
    public void start() {
        timer.setRunning(true);
        defaultStart.settings();
        zone1();
    }
    public void zone1() {
        zeit = 0;
        Player1();
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(200);
        sendMessage1();
        BukkitRunnable runnable1 = new BukkitRunnable() {
            @Override
            public void run() {
                if (zeit >= 300) // 5Minuten -> 300
                {
                    cancel();
                    defaultStart.sendWarning(1);
                    zone2();
                }
                zeit++;
            }
        };
        runnable1.runTaskTimer(Main.getInstance(), 0, 20);
    }

    public void zone2()
    {
        zeit = 0;
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(100, 90); //90 Sekunden
        defaultStart.settingsPvP();
        senMessage2();
        BukkitRunnable runnable1 = new BukkitRunnable() {
            @Override
            public void run() {
                if (zeit >= 180) //3Minuten -> 180
                {
                    cancel();
                    defaultStart.sendWarning(2);
                    zone3();
                }
                zeit++;
            }
        };
        runnable1.runTaskTimer(Main.getInstance(), 0, 20);
    }
    public void zone3()
    {
        zeit = 0;
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(50, 60);
        BukkitRunnable runnable4 = new BukkitRunnable() {
            @Override
            public void run() {
                if(zeit >= 120) //2Minuten -> 120
                {
                    cancel();
                    defaultStart.sendWarning(3);
                    zone4();
                }
                zeit++;
            }
        };
        runnable4.runTaskTimer(Main.getInstance(), 0, 20);
    }
    public void zone4()
    {
        zeit = 0;
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(25, 30);
        BukkitRunnable runnable5 = new BukkitRunnable() {
            @Override
            public void run() {
                if(zeit >= 60)  //1Minuten -> 60
                {
                    cancel();
                    defaultStart.sendWarning(4);
                    zone5();
                }
                zeit++;
            }
        };
        runnable5.runTaskTimer(Main.getInstance(), 0, 20);
    }
    public void zone5()
    {
        zeit =0;
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(10,15);
        BukkitRunnable runnable6 = new BukkitRunnable() {
            @Override
            public void run() {
                if (zeit >= 30) //1Minuten -> 60
                {
                    cancel();
                    defaultStart.sendWarning(5);
                    zone6();
                }
                zeit++;
            }
        };
        runnable6.runTaskTimer(Main.getInstance(),0,20);
    }
    public void zone6()
    {
        zeit = 0;
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(0, 15);
        BukkitRunnable runnable7 = new BukkitRunnable() {
            @Override
            public void run() {
                if(zeit >= 30) //30Sekunden -> 30
                {
                    cancel();
                    defaultStart.sendEnde();
                }
                zeit++;
            }
        };
        runnable7.runTaskTimer(Main.getInstance(), 0, 20);
    }

    public void sendMessage1() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.spigot().sendMessage(ChatMessageType.CHAT, new TextComponent(ChatColor.GREEN + "WorldBorder-Size: 100"));
            player.spigot().sendMessage(ChatMessageType.CHAT, new TextComponent(ChatColor.GREEN + "5 minutes Preparation time!"));
            continue;
        }
    }
    public void senMessage2() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.spigot().sendMessage(ChatMessageType.CHAT, new TextComponent(ChatColor.RED + "Attention PvP is on now!"));
            player.spigot().sendMessage(ChatMessageType.CHAT, new TextComponent(ChatColor.RED + "3 minutes to the next zone"));
            continue;
        }
    }
    public void Player1()
    {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.setGameMode(GameMode.SURVIVAL);
            continue;
        }
    }
}
