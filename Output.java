public class Output {

    public static void Send(String msg) {
        System.out.println(" " + msg);
        System.out.println(" H: " + Main.player.health + " <" + (Main.player.balance ? "B":"-") + ">");
    }

}
