import java.util.Timer;
import java.util.TimerTask;

public class Balances {

    boolean isBalance = true;
    private Timer timer;
    Object caller;

    // Start timer for balance
    public void Start(Double balancetime, Object caller) {
        this.isBalance = false;
        this.timer = new Timer();
        timer.schedule(new TimerTask() {
        @Override
        public void run() {
            Balances.this.isBalance = true;
            try {
                caller.getClass().getMethod("Reset").invoke(caller);
            } catch (Exception e) {
                e.printStackTrace();
            }
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