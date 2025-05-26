abstract public class Robot {
    protected WalkableRobot walkBehavior;
    protected TalkableRobot talkBehavior;
    protected FlyableRobot flyBehavior;

    public Robot(WalkableRobot walkBehavior, TalkableRobot talkBehavior, FlyableRobot flyBehavior) {
        this.walkBehavior = walkBehavior;
        this.talkBehavior = talkBehavior;
        this.flyBehavior = flyBehavior;
    }

    public void fly()
    {
        flyBehavior.fly();
    }

    public void walk()
    {
        walkBehavior.walk();
    }

    public void talk()
    {
        talkBehavior.talk();
    }

    public abstract void projection();
}
