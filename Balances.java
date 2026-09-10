import java.util.Timer;
import java.util.TimerTask;

public class Balances {

    Timer Start(Double balancetime, Mob mob) {

        Timer timer1 = new Timer();
        timer1.schedule(new TimerTask() {
        @Override
        public void run() {
            mob.Balance();
        }
        }, (long)(balancetime * 1000));

        return timer1;

    }
    
}
