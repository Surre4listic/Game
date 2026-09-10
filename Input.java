import java.util.ArrayList;

public class Input {

    private String latestInput;

    private Object[][] commands = {
        // command, description, output, method, partialsearch
        {"move", "Move you into another room.", "You moved into another room.", (Runnable) (() -> this.Move())},
        {"help", "Shows a list of commands.", null, (Runnable) (() -> this.Help())},
        {"exit", "Exits the game.", "You have exited the game.", (Runnable) (() -> this.Exit())},
        {"attack", "Attack <creature>.", null, (Runnable) (() -> this.Attack()), null, true}
        };


    public boolean Get(String cmd) {
        
        latestInput = cmd = cmd.toLowerCase();
        for (int i = 0; i < commands.length; i++) {

            System.out.println(cmd + ":" + commands[i][0]);

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
        Main.player.room.Clear();
        Main.player.room = new Room();
        Main.player.room.New();
    }


    void Attack() {

        ArrayList<Mob> asdf = Main.player.room.mobs;  
        for (int i = 0; i < 0; i++) {
            
        }


        for (Mob mob : Main.player.room.mobs) {

            if (mob.name.toLowerCase().equals(latestInput.replace("attack ", "").toLowerCase()) && mob.health > 0) {

                Output.Send("You attacked " + mob.name + (mob.health <= 0  ? " and it falls helplessly to the ground dead." : "."));
                System.out.println("Health before: " + mob.health);
                mob.health -= Main.player.GiveDamage();
                System.out.println("Health after: " + mob.health);
                if (mob.health <= 0) { mob.Remove(); }
                break;
            } else {
                Output.Send("Can't find " + latestInput.replace("attack ", "") + " to attack.");
            }
        }
    }



}
