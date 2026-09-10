

public class Commands {

    public Object[][] list = {
        {"move", "Move you into another room.", "You moved into another room.", (Runnable) (() -> this.Move())},
        {"help", "Shows a list of commands.", null, (Runnable) (() -> this.Help())},
        {"exit", "Exits the game.", "You have exited the game.", (Runnable) (() -> this.Exit())}
    };

    void Help() {
        String listCommands = "Available commands:";
        for (int i = 0; i < this.list.length; i++) {
            listCommands += "\n " + this.list[i][0] + " - " + this.list[i][1];
        }
        Output.Send(listCommands);
    }

    void Exit() { System.exit(0);}

    void Move() {
        Main.player.room = new Room();
        Main.player.room.New();
    }

}