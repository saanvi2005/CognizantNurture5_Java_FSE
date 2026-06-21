// Exercise 7: Observer Pattern
// Scenario: A stock market monitoring application where clients are notified
// whenever stock prices change.

import java.util.ArrayList;
import java.util.List;

// ---- Observer interface ----
interface Observer {
    void update(String stockSymbol, double price);
}

// ---- Subject interface ----
interface Stock {
    void registerObserver(Observer observer);
    void deregisterObserver(Observer observer);
    void notifyObservers();
}

// ---- Concrete subject ----
class StockMarket implements Stock {
    private final List<Observer> observers = new ArrayList<>();
    private String symbol;
    private double price;

    public void registerObserver(Observer observer) {
        observers.add(observer);
    }

    public void deregisterObserver(Observer observer) {
        observers.remove(observer);
    }

    public void notifyObservers() {
        for (Observer observer : observers) {
            observer.update(symbol, price);
        }
    }

    public void setPrice(String symbol, double price) {
        this.symbol = symbol;
        this.price = price;
        System.out.println("\n" + symbol + " price changed to $" + price);
        notifyObservers();
    }
}

// ---- Concrete observers ----
class MobileApp implements Observer {
    public void update(String stockSymbol, double price) {
        System.out.println("[MobileApp] Notification: " + stockSymbol + " is now $" + price);
    }
}

class WebApp implements Observer {
    public void update(String stockSymbol, double price) {
        System.out.println("[WebApp] Notification: " + stockSymbol + " is now $" + price);
    }
}

// ---- Test class (main) ----
public class ObserverPatternExample {
    public static void main(String[] args) {
        StockMarket stockMarket = new StockMarket();

        Observer mobileApp = new MobileApp();
        Observer webApp = new WebApp();

        stockMarket.registerObserver(mobileApp);
        stockMarket.registerObserver(webApp);

        stockMarket.setPrice("AAPL", 195.32);
        stockMarket.setPrice("AAPL", 197.10);

        stockMarket.deregisterObserver(webApp);
        System.out.println("\n(WebApp has unsubscribed)");
        stockMarket.setPrice("AAPL", 199.50);
    }
}
