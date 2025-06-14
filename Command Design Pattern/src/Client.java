public class Client {
    public static void main(String[] args) {
        Command command1 = new FanCommand();
        Command command2 = new ACCommand();
        Command command3 = new LightCommand();

        Remote remote = new Remote(5);

        remote.setCommand(0, command3);
        remote.setCommand(1, command1);
        remote.setCommand(2, command2);

        remote.pressButton(0);
        remote.pressButton(0);

        remote.pressButton(1);
        remote.pressButton(2);

        remote.pressButton(1);
        remote.pressButton(2);

        remote.pressButton(1);
        remote.pressButton(0);


    }
}