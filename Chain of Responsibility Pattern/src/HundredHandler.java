public class HundredHandler extends MoneyHandler{
    private int numNotes;

    public HundredHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 100;

        if (notesNeeded > numNotes) {
            notesNeeded = numNotes;
            numNotes = 0;
        } else {
            numNotes -= notesNeeded;
        }

        if (notesNeeded > 0)
            System.out.println("Dispensing " + notesNeeded + " x ₹100 notes.");

        int remainingAmount = amount - (notesNeeded * 100);
        if (remainingAmount > 0) {
            if (nextHandler != null) nextHandler.dispense(remainingAmount);
            else {
                System.out.println("Remaining amount of " + remainingAmount + " cannot be fulfilled (Insufficinet fund in ATM)");
            }
        }
    }
}
