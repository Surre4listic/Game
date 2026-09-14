import java.util.Timer;
import java.util.TimerTask;

public class Balances {

    boolean balance = true;
    private Timer timer;

    public void Start(Double balancetime) {
        this.balance = false;
        this.timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            Balances.this.balance = true;
        }
        }, (long)(balancetime * 1000));

    }

    // Cancel(Remove) timer for balance
    public void Cancel() {
        // Make sure there is a timer to cancel, otherwise it will throw an error.
        if (this.timer != null) {
            this.timer.cancel();
        }
    }
    
}