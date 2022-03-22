package ben.zonewars.zone;

import ben.zonewars.Main;
import ben.zonewars.timer.Timer;
import net.md_5.bungee.api.ChatColor;
import net.md_5.bungee.api.ChatMessageType;
import net.md_5.bungee.api.chat.TextComponent;
import org.bukkit.Bukkit;
import org.bukkit.WorldBorder;
import org.bukkit.entity.Player;
import org.bukkit.scheduler.BukkitRunnable;

public class Big {
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
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(1000);
        sendMessage1();
        BukkitRunnable runnable1 = new BukkitRunnable() {
            @Override
            public void run() {
                if (zeit >= 1800) //30Minuten -> 1800
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
    public void zone2() {
        zeit = 0;
        defaultStart.settingsPvP();
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(500, 240);
        BukkitRunnable runnable1 = new BukkitRunnable() {
            @Override
            public void run() {
                if (zeit >= 900) //15Minuten -> 900
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
        border.setSize(250, 120); //120 Sekunden
        senMessage2();
        BukkitRunnable runnable1 = new BukkitRunnable() {
            @Override
            public void run() {
                if (zeit >= 600) //10Minuten -> 600
                {
                    cancel();
                    defaultStart.sendWarning(3);
                    zone4();
                }
                zeit++;
            }
        };
        runnable1.runTaskTimer(Main.getInstance(), 0, 20);
    }

    public void zone4()
    {
        zeit = 0;
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(100, 90);
        BukkitRunnable runnable3 = new BukkitRunnable() {
            @Override
            public void run() {
                if(zeit >= 300) //5Minuten -> 300
                {
                    cancel();
                    defaultStart.sendWarning(4);
                    zone5();
                }
                zeit++;
            }
        };
        runnable3.runTaskTimer(Main.getInstance(), 0, 20);
    }
    public void zone5()
    {
        zeit = 0;
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(50, 60);
        BukkitRunnable runnable4 = new BukkitRunnable() {
            @Override
            public void run() {
                if(zeit >= 180) //3Minuten -> 180
                {
                    cancel();
                    defaultStart.sendWarning(5);
                    zone6();
                }
                zeit++;
            }
        };
        runnable4.runTaskTimer(Main.getInstance(), 0, 20);
    }
    public void zone6()
    {
        zeit = 0;
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(25, 30);
        BukkitRunnable runnable5 = new BukkitRunnable() {
            @Override
            public void run() {
                if(zeit >= 120) //2Minuten -> 120
                {
                    cancel();
                    defaultStart.sendWarning(6);
                    zone7();
                }
                zeit++;
            }
        };
        runnable5.runTaskTimer(Main.getInstance(), 0, 20);
    }
    public void zone7()
    {
        zeit =0;
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        border.setSize(10,30);
        BukkitRunnable runnable6 = new BukkitRunnable() {
            @Override
            public void run() {
                if (zeit >= 90) //1Minuten -> 60
                {
                    cancel();
                    defaultStart.sendWarning(7);
                    zone8();
                }
                zeit++;
            }
        };
        runnable6.runTaskTimer(Main.getInstance(),0,20);
    }
    public void zone8 ()
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
            player.spigot().sendMessage(ChatMessageType.CHAT, new TextComponent(ChatColor.GREEN + "WorldBorder-Size: 1000"));
            player.spigot().sendMessage(ChatMessageType.CHAT, new TextComponent(ChatColor.GREEN + "30 minutes reparation time!"));
            continue;
        }
    }
    public void senMessage2() {
        for (Player player : Bukkit.getOnlinePlayers()) {
            player.spigot().sendMessage(ChatMessageType.CHAT, new TextComponent(ChatColor.RED + "Attention PvP is on now!"));
            player.spigot().sendMessage(ChatMessageType.CHAT, new TextComponent(ChatColor.RED + "20 minutes to the next zone"));
            continue;
        }
    }
}
