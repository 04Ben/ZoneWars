package ben.zonewars;

import ben.zonewars.commands.Commands;
import ben.zonewars.timer.Countdown;
import ben.zonewars.timer.Timer;
import org.bukkit.*;
import org.bukkit.plugin.java.JavaPlugin;
import org.bukkit.scoreboard.Scoreboard;
import org.bukkit.scoreboard.ScoreboardManager;

public final class Main extends JavaPlugin {
    private static Main instance;
    private Timer timer;
    private Countdown countdown;

    @Override
    public void onLoad() {
        instance = this;
    }
    @Override
    public void onEnable() {
        // Plugin startup logic
        timer = new Timer(false, 0);
        countdown = new Countdown(10, false);
        onStart();
        getCommand("zonewars").setExecutor(new Commands());
    }

    @Override
    public void onDisable() {
        // Plugin shutdown login
    }

    public static Main getInstance() {
        return instance;
    }
    public Timer getTimer() {
        return timer;
    }

    public Countdown getCountdown() {
        return countdown;
    }
    public void onStart() {
        WorldBorder border = Bukkit.getWorld("world").getWorldBorder();
        WorldBorder borderNether = Bukkit.getWorld("world_nether").getWorldBorder();
        border.setCenter(Bukkit.getWorld("world").getSpawnLocation());
        borderNether.setCenter(Bukkit.getWorld("world_nether").getSpawnLocation());
        border.setSize(50);
        borderNether.setSize(50);
        Bukkit.getWorld("world").setPVP(false);
        Bukkit.getWorld("world").setGameRule(GameRule.FALL_DAMAGE, false);
        //Bukkit.getWorld("world").setGameRule(GameRule.DO_MOB_SPAWNING, false);
        Bukkit.getWorld("world").setGameRule(GameRule.DO_WEATHER_CYCLE, false);
        Bukkit.getWorld("world").setGameRule(GameRule.FIRE_DAMAGE, false);
        Bukkit.getWorld("world").setDifficulty(Difficulty.PEACEFUL);
        Bukkit.getWorld("world").setHardcore(true);
        ScoreboardManager manager = Bukkit.getScoreboardManager();
        Scoreboard bord = manager.getNewScoreboard();
        Bukkit.getOnlinePlayers().forEach(player ->{
            player.setGameMode(GameMode.SURVIVAL);
        });
    }
}
