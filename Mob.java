
class Mob {

    public String name = "Creature";
    int health = 50;
    int damage = 5;
    double balancetime = 2.0;
    int experience = 10;
    boolean isAggressive = false;
    Balances balances = new Balances();

    Mob(String name, int health, int damage, double balancetime, int experience, boolean aggressive) {
        this.name = name;
        this.health = health;
        this.damage = damage;
        this.balancetime = balancetime;
        this.experience = experience;
        this.isAggressive = aggressive;
    }

    void Attack() {
        if (this.balances.isBalance) {

            Main.player.TakeDamage(this.damage, this.name);
            balances.Start(this.balancetime, this);

        } else {
            // Should never end up here, and waiting for a solution if this happens.
            System.out.println("PROBLEM!! Mob.java");
        }
    }

    public void TimerRemove() {
        this.balances.Cancel();
    }

    public void Remove() {
        this.TimerRemove();
        Main.player.room.mobs.remove(this);
    }

    public void Reset() {
        this.Attack();
    }
    
}