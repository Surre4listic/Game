import java.util.Timer;
import java.util.TimerTask;

public class Balances {

    Timer timer;

    public void Start(Double balancetime, Mob mob) {
        this.timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            mob.BalanceReturn();
        }
        }, (long)(balancetime * 1000));

    }

    // Cancel(Remove) timer for balance
    public void Cancel() {
        timer.cancel();
    }
    
}