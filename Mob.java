import java.util.Timer;

class Mob {

    public String name = "Creature";
    int health = 50;
    int damage = 5;
    double balancetime = 2.0;
    boolean balance = true;
    boolean aggressive = false;
    Balances balanceTimer;
    Timer test;

    Mob(String name, int health, int damage, double balancetime, boolean aggressive) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.balancetime = balancetime;
        this.aggressive = aggressive;
    }

    void Attack() {
        if (this.balance) {
            System.out.println(this.name + " attacks you for " + this.damage + ".");
            this.balance = false;

            balanceTimer = new Balances();
            test = balanceTimer.Start(this.balancetime, this);
        } else { System.out.println("PROBLEM!!");}
    }

    void Balance() {
        this.balance = true;
        this.Attack();
    }

    public void Remove() {
        test.cancel();
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