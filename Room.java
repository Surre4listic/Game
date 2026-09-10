import java.util.ArrayList;
import java.util.Random;

public class Room {

    String name;
    String desc;

    // Set random number of mobs in this room
    Random r = new Random();
    int mobAmount = (int)r.nextInt(5);
    int mobRandom;
    ArrayList<Mob> mobs = new ArrayList<Mob>();

    public Room() {
    
    }

    public void New() {
        Populate();
        Show();
    }

    public void Show() {
        String showRoom = "";
        for (int i = 0; i < mobs.size(); i++) {
            showRoom += (showRoom.equals("")?"":" ") + mobs.get(i).name + (mobAmount <= 1 || mobAmount-1 == i?"":(mobAmount - 2 == i)?" and":",");
        }
        Output.Send((showRoom == "" ? "This room was empty." : "You see: " + showRoom + "."));
    }   

    public void Populate() {
        // Clear list of mobs
        for (Mob mob : mobs) {
            if (mob.balanceTimer != null) {
                mob.Remove();;
            }
        }
        mobs = new ArrayList<Mob>();
        // Loop through and spawn mobs in room.
        for (int i = 1; i <= mobAmount; i++) {
           Spawn();
        }
        // Check for aggressive creatures
        for (Mob mob : mobs) {
            if (mob.aggressive && mob.balance) {
                mob.Attack();
            }
        }
    }

    public void Spawn() {
        // Set a random number(mob) from database
        mobRandom = (int)r.nextInt(DB.mobs.length);
        //  Create an object referring to thise mob and save it to mobs arraylist
        mobs.add(
            new Mob(
                (String)DB.mobs[mobRandom][0], 
                (int)DB.mobs[mobRandom][1], 
                (int)DB.mobs[mobRandom][2], 
                (double)DB.mobs[mobRandom][3], 
                (boolean)DB.mobs[mobRandom][4])
            );
    }
    
}
