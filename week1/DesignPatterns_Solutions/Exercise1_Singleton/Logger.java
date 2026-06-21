// Exercise 1: Singleton Pattern
// Scenario: A logging utility class that must have only one instance.

public class Logger {

    // The single instance, created lazily and thread-safely
    private static volatile Logger instance;

    // Private constructor prevents external instantiation
    private Logger() {
        System.out.println("Logger instance created.");
    }

    // Public global access point (thread-safe double-checked locking)
    public static Logger getInstance() {
        if (instance == null) {
            synchronized (Logger.class) {
                if (instance == null) {
                    instance = new Logger();
                }
            }
        }
        return instance;
    }

    public void log(String message) {
        System.out.println("[LOG] " + message);
    }

    // ---- Test class (main) ----
    public static void main(String[] args) {
        Logger logger1 = Logger.getInstance();
        Logger logger2 = Logger.getInstance();

        logger1.log("Application started.");
        logger2.log("Fetching data...");

        System.out.println("logger1 == logger2 ? " + (logger1 == logger2));
        System.out.println("Same instance hash: " + logger1.hashCode() + " / " + logger2.hashCode());
    }
}
