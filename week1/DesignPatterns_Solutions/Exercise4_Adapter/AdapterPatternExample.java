// Exercise 4: Adapter Pattern
// Scenario: Integrate multiple third-party payment gateways with different interfaces.

// ---- Target interface (what our app expects) ----
interface PaymentProcessor {
    void processPayment(double amount);
}

// ---- Adaptee classes (third-party gateways, incompatible interfaces) ----
class StripeGateway {
    public void makeStripePayment(double amountInDollars) {
        System.out.println("Processing $" + amountInDollars + " via Stripe.");
    }
}

class PayPalGateway {
    public void sendPayPalPayment(double usdAmount) {
        System.out.println("Processing $" + usdAmount + " via PayPal.");
    }
}

// ---- Adapter classes ----
class StripeAdapter implements PaymentProcessor {
    private final StripeGateway stripeGateway;

    public StripeAdapter(StripeGateway stripeGateway) {
        this.stripeGateway = stripeGateway;
    }

    public void processPayment(double amount) {
        stripeGateway.makeStripePayment(amount);
    }
}

class PayPalAdapter implements PaymentProcessor {
    private final PayPalGateway payPalGateway;

    public PayPalAdapter(PayPalGateway payPalGateway) {
        this.payPalGateway = payPalGateway;
    }

    public void processPayment(double amount) {
        payPalGateway.sendPayPalPayment(amount);
    }
}

// ---- Test class (main) ----
public class AdapterPatternExample {
    public static void main(String[] args) {
        PaymentProcessor stripe = new StripeAdapter(new StripeGateway());
        PaymentProcessor payPal = new PayPalAdapter(new PayPalGateway());

        stripe.processPayment(49.99);
        payPal.processPayment(19.99);
    }
}
