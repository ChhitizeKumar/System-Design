public class CompanionRobot extends Robot{


    public CompanionRobot(WalkableRobot walkBehavior, TalkableRobot talkBehavior, FlyableRobot flyBehavior) {
        super(walkBehavior, talkBehavior, flyBehavior);
    }

    @Override
    public void projection() {
        System.out.println("Displaying friendly companion features...");
    }
}
