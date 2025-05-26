public class WorkerRobot extends Robot{
    public WorkerRobot(WalkableRobot walkBehavior, TalkableRobot talkBehavior, FlyableRobot flyBehavior) {
        super(walkBehavior, talkBehavior, flyBehavior);
    }

    @Override
    public void projection() {
        System.out.println("Displaying worker efficiency stats...");
    }
}
