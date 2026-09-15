
public class Input {

    private String latestInput;

    private Object[][] commands = {
        // command, description, output, method, partialsearch
        {"move", "Move you into another room.", "You moved into another room.", (Runnable) (() -> this.Move())},
        {"rest", "Rest to generate health.", null, (Runnable) (() -> this.Rest())},
        {"help", "Shows a list of commands.", null, (Runnable) (() -> this.Help())},
        {"look", "Look around the room.", null, (Runnable) (() -> this.Look())},
        {"exit", "Exits the game.", "You have exited the game.", (Runnable) (() -> this.Exit())},
        {"attack", "Attack <creature>.", null, (Runnable) (() -> this.Attack()), null, true}
        };


    public boolean Get(String cmd) {
        
        latestInput = cmd = cmd.toLowerCase();
        for (int i = 0; i < commands.length; i++) {

            // System.out.println(cmd + ":" + commands[i][0]);

            // Check cmd
            if (cmd.equals(commands[i][0]) || (cmd.contains(commands[i][0].toString()) && (boolean)commands[i][5])) {

                // If the command has a message, send it to the player.
                if (commands[i][2] != null) {
                    Output.Send((String)commands[i][2]);
                }
                // Run the command if it has a runnable.
                if (commands[i][3] != null) {
                    ((Runnable)commands[i][3]).run();
                }
                return true;

            }
        }
        Output.Send("Command not found. Type 'help' for a list of commands.");
        return true;
    }

    void Help() {
        String listCommands = "Available commands:";
        for (int i = 0; i < commands.length; i++) {
            listCommands += "\n " + commands[i][0] + " - " + commands[i][1];
        }
        Output.Send(listCommands);
    }

    void Exit() { System.exit(0);}

    void Move() {
        if (!Main.player.sleeping.isBalance) {
            Output.Send("You are resting and cannot move.");
            return;
        } else if (!Main.player.balance.isBalance) {
            Output.Send("You are off balance and cannot move.");
            return;
        }
        Main.player.room.Clear();
        Main.player.room = new Room();
        Main.player.room.New();
    }

    void Look() {
        Main.player.room.Show();
    }

    void Attack() {
        Main.player.GiveDamage(latestInput);
    }

    void Rest() {
        Main.player.new Rest();
    }

}
