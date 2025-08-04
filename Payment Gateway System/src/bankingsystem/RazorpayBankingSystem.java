package bankingsystem;

import java.util.Random;

public class RazorpayBankingSystem implements BankingSystem{

    private Random rand = new Random();

    @Override
    public Boolean processPayment(double amount) {

        int r = rand.nextInt();

        return r < 90;

    }
}
