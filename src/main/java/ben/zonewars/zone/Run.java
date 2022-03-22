package ben.zonewars.zone;

import ben.zonewars.Main;
import ben.zonewars.timer.Countdown;

public class Run {
    public void small()
    {
        Countdown countdown = Main.getInstance().getCountdown();
        countdown.setRunning(true);
        countdown.setX(0);

    }
    public void middle() {
        Countdown countdown = Main.getInstance().getCountdown();
        countdown.setRunning(true);
        countdown.setX(1);
    }
    public void big() {
        Countdown countdown = Main.getInstance().getCountdown();
        countdown.setRunning(true);
        countdown.setX(2);
    }

    public void startsmall()
    {
        Small small = new Small();
        small.start();
    }
    public void startmiddle()
    {
        Middle middle = new Middle();
        middle.start();
    }
    public void startbig()
    {
        Big big = new Big();
        big.start();
    }
}
