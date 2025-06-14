
class AC{
    void on()
    {
        System.out.println("AC On...\n");
    }
    void of(){
        System.out.println("AC Off...\n");
    }
}

public class ACCommand implements Command{

    private AC ac = new AC();
    @Override
    public void execute() {
        ac.on();
    }

    @Override
    public void undo() {
        ac.of();
    }
}
