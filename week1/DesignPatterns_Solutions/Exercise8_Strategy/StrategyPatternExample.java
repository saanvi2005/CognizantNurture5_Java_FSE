// Exercise 8: Strategy Pattern
// Scenario: A payment system where the payment method can be selected at runtime.

// ---- Strategy interface ----
interface PaymentStrategy {
    void pay(double amount);
}

// ---- Concrete strategies ----
class CreditCardPayment implements PaymentStrategy {
    private final String cardNumber;

    public CreditCardPayment(String cardNumber) {
        this.cardNumber = cardNumber;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using Credit Card ending in "
                + cardNumber.substring(cardNumber.length() - 4));
    }
}

class PayPalPayment implements PaymentStrategy {
    private final String email;

    public PayPalPayment(String email) {
        this.email = email;
    }

    public void pay(double amount) {
        System.out.println("Paid $" + amount + " using PayPal account " + email);
    }
}

// ---- Context class ----
class PaymentContext {
    private PaymentStrategy strategy;

    public void setStrategy(PaymentStrategy strategy) {
        this.strategy = strategy;
    }

    public void executePayment(double amount) {
        if (strategy == null) {
            throw new IllegalStateException("No payment strategy selected.");
        }
        strategy.pay(amount);
    }
}

// ---- Test class (main) ----
public class StrategyPatternExample {
    public static void main(String[] args) {
        PaymentContext context = new PaymentContext();

        context.setStrategy(new CreditCardPayment("4111111111111234"));
        context.executePayment(120.50);

        context.setStrategy(new PayPalPayment("user@example.com"));
        context.executePayment(45.00);
    }
}
