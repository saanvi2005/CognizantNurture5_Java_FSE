// Exercise 5: Decorator Pattern
// Scenario: A notification system that can send via multiple channels dynamically.

// ---- Component interface ----
interface Notifier {
    void send(String message);
}

// ---- Concrete component ----
class EmailNotifier implements Notifier {
    public void send(String message) {
        System.out.println("Sending EMAIL: " + message);
    }
}

// ---- Abstract decorator ----
abstract class NotifierDecorator implements Notifier {
    protected final Notifier wrappee;

    public NotifierDecorator(Notifier wrappee) {
        this.wrappee = wrappee;
    }

    public void send(String message) {
        wrappee.send(message);
    }
}

// ---- Concrete decorators ----
class SMSNotifierDecorator extends NotifierDecorator {
    public SMSNotifierDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SMS: " + message);
    }
}

class SlackNotifierDecorator extends NotifierDecorator {
    public SlackNotifierDecorator(Notifier wrappee) {
        super(wrappee);
    }

    @Override
    public void send(String message) {
        super.send(message);
        System.out.println("Sending SLACK message: " + message);
    }
}

// ---- Test class (main) ----
public class DecoratorPatternExample {
    public static void main(String[] args) {
        // Plain email
        Notifier emailOnly = new EmailNotifier();

        // Email + SMS
        Notifier emailAndSms = new SMSNotifierDecorator(new EmailNotifier());

        // Email + SMS + Slack
        Notifier allChannels = new SlackNotifierDecorator(
                new SMSNotifierDecorator(new EmailNotifier()));

        System.out.println("-- Email only --");
        emailOnly.send("Server restarted.");

        System.out.println("-- Email + SMS --");
        emailAndSms.send("High CPU usage detected.");

        System.out.println("-- Email + SMS + Slack --");
        allChannels.send("Production deployment complete.");
    }
}
