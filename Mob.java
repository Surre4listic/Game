
class Mob {

    public String name = "Creature";
    int health = 50;
    int damage = 5;
    double balancetime = 2.0;
    boolean balance = true;
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
        if (this.balance) {

            Main.player.health -= this.damage;
            this.balance = false;
            Output.Send(this.name + " attacks you for " + this.damage + ".");

            balances.Start(this.balancetime, this);

        } else {
            // Should never end up here, and waiting for a solution if this happens.
            System.out.println("PROBLEM!!");
        }
    }

    void BalanceReturn() {
        this.balance = true;
        this.Attack();
    }

    public void TimerRemove() {
        this.balances.Cancel();
    }

    public void Remove() {
        this.TimerRemove();
        Main.player.room.mobs.remove(this);
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