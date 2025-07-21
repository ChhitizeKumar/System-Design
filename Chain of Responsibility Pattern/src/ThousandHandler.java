public class ThousandHandler extends MoneyHandler{

    private int numNotes;

    public ThousandHandler(int numNotes) {
        this.numNotes = numNotes;
    }

    @Override
    public void dispense(int amount) {
        int notesNeeded = amount/1000;

        if(notesNeeded > numNotes)
            notesNeeded = numNotes;
        else
            numNotes -= notesNeeded;

        if(notesNeeded > 0)
            System.out.println("Dispensing " + notesNeeded + " x ₹1000 notes.");

        int amtRem = amount - (notesNeeded*1000);

        if(amtRem > 0)
        {
            if(nextHandler != null){
                nextHandler.dispense(amtRem);
            }

            else{
                System.out.println("Remaining amount of " + amtRem + " cannot be fulfilled (Insufficinet fund in ATM)");
            }
        }
    }
}
