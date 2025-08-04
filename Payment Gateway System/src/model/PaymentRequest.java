package model;

public class PaymentRequest {
    public String sender;
    public String receiver;
    public Double amount;
    public String currency;

    public PaymentRequest(String sender, String receiver, Double amount, String currency) {
        this.sender = sender;
        this.receiver = receiver;
        this.amount = amount;
        this.currency = currency;
    }
}
