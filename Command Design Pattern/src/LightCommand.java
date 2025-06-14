
class Light{
    void on()
    {
        System.out.println("Light On...\n");
    }
    void of(){
        System.out.println("Light Off...\n");
    }
}

public class LightCommand implements Command{
    private Light light;

    public LightCommand() {
        this.light = new Light();
    }

    @Override
    public void execute() {
        light.on();
    }

    @Override
    public void undo() {
        light.of();
    }
}
