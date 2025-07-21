public class FiveHundredHandler extends MoneyHandler{
    private int numNotes;

    public FiveHundredHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount / 500;

        if (notesNeeded > numNotes) {
            notesNeeded = numNotes;
            numNotes = 0;
        } else {
            numNotes -= notesNeeded;
        }

        if (notesNeeded > 0)
            System.out.println("Dispensing " + notesNeeded + " x ₹500 notes.");

        int remainingAmount = amount - (notesNeeded * 500);
        if (remainingAmount > 0) {
            if (nextHandler != null) nextHandler.dispense(remainingAmount);
            else {
                System.out.println("Remaining amount of " + remainingAmount + " cannot be fulfilled (Insufficinet fund in ATM)");
            }
        }
    }
}
