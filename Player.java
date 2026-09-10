public class Player {

    String name;
    int health = 1000;
    boolean balance = true;
    int level = 0;

    Input input;
    Commands commands;
    Room room;

    public Player(String name) {
        this.name = name;
        this.input = new Input();
        this.commands = new Commands();
        this.room = new Room();
    }

    void TakeDamage(int amount) {
        String message = "";
        this.health -= amount;
        message = "You have taken " + amount + " damage.";
        if (this.health <= 0) { message += "You have died"; }
        Output.Send(message);
    }

}
