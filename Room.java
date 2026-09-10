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

    // Call methods to populate and show the room when a new room is created
    public void New() {
        Populate();
        Show();
    }

    // Populate the room with mobs
    public void Populate() {
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

    // Display the mobs in the room
    public void Show() {
        String showRoom = "";
        for (int i = 0; i < mobs.size(); i++) {
            showRoom += (showRoom.equals("")?"":" ") + mobs.get(i).name + (mobAmount <= 1 || mobAmount-1 == i?"":(mobAmount - 2 == i)?" and":",");
        }
        Output.Send((showRoom == "" ? "This room is empty." : "You see: " + showRoom + "."));
    }  

    // Clear the room of mobs and cancel their timers
    public void Clear() {
        for (Mob mob : mobs) {
            System.out.print("Removing " + mob.name + " from room. ");
            if (mob.balances != null) {
                System.out.println("Removed timer for " + mob.name);
                mob.TimerRemove();
            }
        }
        mobs = new ArrayList<Mob>();
    }

    public void Spawn() {
        // Set a random number(mob) from database
        mobRandom = (int)r.nextInt(DB.mobs.length);
        //  Create an object referring to this mob and save it to mobs arraylist
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
