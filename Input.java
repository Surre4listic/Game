

public class Input {

    public boolean Get(String cmd) {
        cmd = cmd.toLowerCase();
        for (int i = 0; i < Main.player.commands.list.length; i++) {
            if (cmd.equals(Main.player.commands.list[i][0])) {

                // If the command has a message, send it to the player.
                if (Main.player.commands.list[i][2] != null) {
                    Output.Send((String)Main.player.commands.list[i][2]);
                }
                // Run the command if it has a runnable.
                if (Main.player.commands.list[i][3] != null) {
                    ((Runnable) Main.player.commands.list[i][3]).run();
                }
                return true;
            }
        }
        Output.Send("Command not found. Type 'help' for a list of commands.");
        return true;
    }

}
