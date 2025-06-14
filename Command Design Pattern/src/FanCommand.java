
class Fan{
    void on()
    {
        System.out.println("Fan On...\n");
    }
    void of(){
        System.out.println("Fan Off...\n");
    }
}

public class FanCommand implements Command{

    private Fan fan;

    public FanCommand()
    {
        fan = new Fan();
    }

    @Override
    public void execute() {
        fan.on();
    }

    @Override
    public void undo() {
        fan.of();
    }
}
