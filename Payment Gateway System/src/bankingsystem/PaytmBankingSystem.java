package bankingsystem;

import java.util.Random;

public class PaytmBankingSystem implements BankingSystem{

    private Random rand = new Random();

    @Override
    public Boolean processPayment(double amount) {

        int r = rand.nextInt(100);

        return r < 80;
    }
}
