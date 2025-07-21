public abstract class MoneyHandler {

    protected MoneyHandler nextHandler;

    public MoneyHandler() {
        this.nextHandler = null;
    }

    public void setNextHandler(MoneyHandler nextHandler){
        this.nextHandler = nextHandler;
    }

    public abstract void dispense(int amount);
}
