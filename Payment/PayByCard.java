package Payment;

public class PayByCard extends Payment {

    @Override
    public boolean processPayment(double amount) {
        // implement logic
        System.out.println("Amount : " + amount + " has been processed!");
        return true;
    }
}
