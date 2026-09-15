
public class Player {

    String name;
    int health = 1000;
    int healthMax = 1000;
    int experience = 0;
    Balances balance;
    Balances sleeping;

    Input input;
    Room room;

    public Player(String name) {
        this.name = name;
        this.input = new Input();
        this.room = new Room();
        this.balance = new Balances();
        this.sleeping = new Balances();
    }

    void TakeDamage(int amount, String source) {
        String message = "";
        this.health -= amount;
        message = "You have taken " + amount + " damage from " + source + ".";
        if (this.health <= 0) { message += " You have died"; }
        Output.Send(message);
    }

    void GiveDamage(String latestInput) {

        // Check if the player is balanced before allowing them to attack.
        if (!balance.isBalance) {
            Output.Send("You are off balance and cannot attack.");
            return;
        }

        
        // Calculate damage based on player level.
        // int damage = 100 + (level * 5);
        int damage = 100 + (int)Math.floor(Math.sqrt(this.experience) / 10) * 5;

        // Check for mobs in the room and if the player has specified a mob to attack.
        for (Mob mob : Main.player.room.mobs) {

            if (mob.name.toLowerCase().equals(latestInput.replace("attack ", "").toLowerCase()) && mob.health > 0) {

                balance.Start(1.5, this);
                mob.health -= damage;
                if (mob.health <= 0) {
                    this.experience += mob.experience;
                    mob.Remove();
                }
                Output.Send("You attacked " + mob.name + " for " + damage + (mob.health <= 0  ? " and it falls helplessly to the ground dead.\n You have gained " + mob.experience + " experience." : "."));
                return;
            }
        }

        Output.Send("Can't find " + latestInput.replace("attack ", "") + " to attack.");

    }

    /*
    public void Rest() {
        if (!sleeping.balance) {
            Output.Send("You are already resting.");
            return;
        }
        sleeping.Start(5.0, this);
        Output.Send("You sit down to rest and regenerate health.");

        private void Reset() {
            Output.Send("You have finished resting and regenerated 100 health.");
            Main.player.health += 100;
        }

    }
    */

    // Testar objekt istället för metod.
    public class Rest {

        public Rest() {
            // Check if we can rest
            if (!Main.player.sleeping.isBalance) {
                Output.Send("You are already resting.");
                return;
            } else if (Main.player.health >= Main.player.healthMax) {
                Output.Send("You are already at full health.");
                return;
            }
            // Start resting and set a timer to reset after 5 seconds.
            Main.player.sleeping.Start(5.0, this);
            Output.Send("You sit down to rest and regenerate health.");
        }

        public void Reset() {
            int restAmount = (Main.player.health + 100 >= Main.player.healthMax ? Main.player.healthMax - Main.player.health : 100);
            Main.player.health += restAmount;
            Main.player.sleeping.isBalance = true;
            Output.Send("You have finished resting and regenerated " + restAmount + " health.");
        }
    }

    public void Reset() {
        Output.Send("Balance is back.");
    }

}
