public class Main {
    public static void main(String[] args) {
        Robot robot1 = new CompanionRobot(new NormalWalk(), new NoTalk(), new NoFly());
        robot1.walkBehavior.walk();
        robot1.flyBehavior.fly();
        robot1.walkBehavior.walk();
        robot1.projection();

        System.out.println("--------------------");

        Robot robot2 = new WorkerRobot(new Nowalk(), new NoTalk(), new NormalFly());
        robot2.walk();
        robot2.talk();
        robot2.fly();
        robot2.projection();
    }
}