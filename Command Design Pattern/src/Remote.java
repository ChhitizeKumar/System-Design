import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class Remote {
    private Command[] commands;
    private boolean[] isPressed;
    private int size;

    public Remote(int n)
    {
        size = n;
        commands = new Command[n];
        isPressed = new boolean[n];

        for (int i = 0; i<n; i++)
        {
            isPressed[i] = false;
            commands[i] = null;
        }
    }

    void setCommand(int idx, Command command)
    {
        commands[idx] = command;
    }

    void pressButton(int idx)
    {
        if(!isPressed[idx])
        {
            commands[idx].execute();
        }
        else{
            commands[idx].undo();
        }
        isPressed[idx] = !isPressed[idx];
    }
}
