
class Mob {

    public String name = "Creature";
    int health = 50;
    int damage = 5;
    double balancetime = 2.0;
    boolean aggressive = false;
    Balances balances = new Balances();

    Mob(String name, int health, int damage, double balancetime, boolean aggressive) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.balancetime = balancetime;
        this.aggressive = aggressive;
    }

    void Attack() {
        if (this.balances.balance) {

            Main.player.health -= this.damage;
            Output.Send(this.name + " attacks you for " + this.damage + ".");
            balances.Start(this.balancetime);

        } else {
            // Should never end up here, and waiting for a solution if this happens.
            System.out.println("PROBLEM!!");
        }
    }


    public void TimerRemove() {
        this.balances.Cancel();
    }

    public void Remove() {
        System.out.println(this.name + " 1has been removed from the room.");
        this.TimerRemove();
        Main.player.room.mobs.remove(this);
        System.out.println(this.name + " 2 has been removed from the room.");
    }
    
}

/*
class Ogre extends Mob {

    Ogre(String name, int health, int damage, double balancetime) {
        super(name, health, damage, balancetime);
    }

    public static void main(String[] args) {
        System.out.println("Name: ");
    }

    void Attack() {
        super.Attack();
        System.out.println("Ogre attacks");
    }

}
*/