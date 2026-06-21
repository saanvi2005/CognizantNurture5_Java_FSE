// Exercise 6: Proxy Pattern
// Scenario: An image viewer that loads images from a remote server, with lazy
// initialization and caching provided by a proxy.

// ---- Subject interface ----
interface Image {
    void display();
}

// ---- Real subject ----
class RealImage implements Image {
    private final String filename;

    public RealImage(String filename) {
        this.filename = filename;
        loadFromServer();
    }

    private void loadFromServer() {
        System.out.println("Loading " + filename + " from remote server...");
    }

    public void display() {
        System.out.println("Displaying " + filename);
    }
}

// ---- Proxy ----
class ProxyImage implements Image {
    private final String filename;
    private RealImage realImage; // created lazily

    public ProxyImage(String filename) {
        this.filename = filename;
    }

    public void display() {
        if (realImage == null) { // lazy initialization + caching
            realImage = new RealImage(filename);
        } else {
            System.out.println("Using cached image for " + filename);
        }
        realImage.display();
    }
}

// ---- Test class (main) ----
public class ProxyPatternExample {
    public static void main(String[] args) {
        Image image1 = new ProxyImage("photo1.jpg");
        Image image2 = new ProxyImage("photo2.jpg");

        // First call triggers the (simulated) network load
        image1.display();
        System.out.println();

        // Second call on the same proxy uses the cached RealImage
        image1.display();
        System.out.println();

        image2.display();
    }
}
