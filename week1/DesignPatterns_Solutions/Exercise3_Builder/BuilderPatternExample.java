// Exercise 3: Builder Pattern
// Scenario: Build complex Computer objects with multiple optional parts.

class Computer {
    // Required
    private final String cpu;
    private final String ram;
    // Optional
    private final String storage;
    private final String gpu;
    private final boolean hasWifi;
    private final boolean hasBluetooth;

    private Computer(Builder builder) {
        this.cpu = builder.cpu;
        this.ram = builder.ram;
        this.storage = builder.storage;
        this.gpu = builder.gpu;
        this.hasWifi = builder.hasWifi;
        this.hasBluetooth = builder.hasBluetooth;
    }

    @Override
    public String toString() {
        return "Computer{" +
                "cpu='" + cpu + '\'' +
                ", ram='" + ram + '\'' +
                ", storage='" + storage + '\'' +
                ", gpu='" + gpu + '\'' +
                ", hasWifi=" + hasWifi +
                ", hasBluetooth=" + hasBluetooth +
                '}';
    }

    public static class Builder {
        // Required
        private final String cpu;
        private final String ram;
        // Optional - default values
        private String storage = "256GB SSD";
        private String gpu = "Integrated Graphics";
        private boolean hasWifi = false;
        private boolean hasBluetooth = false;

        public Builder(String cpu, String ram) {
            this.cpu = cpu;
            this.ram = ram;
        }

        public Builder storage(String storage) {
            this.storage = storage;
            return this;
        }

        public Builder gpu(String gpu) {
            this.gpu = gpu;
            return this;
        }

        public Builder wifi(boolean hasWifi) {
            this.hasWifi = hasWifi;
            return this;
        }

        public Builder bluetooth(boolean hasBluetooth) {
            this.hasBluetooth = hasBluetooth;
            return this;
        }

        public Computer build() {
            return new Computer(this);
        }
    }
}

// ---- Test class (main) ----
public class BuilderPatternExample {
    public static void main(String[] args) {
        Computer basic = new Computer.Builder("Intel i3", "8GB")
                .build();

        Computer gamingPc = new Computer.Builder("Intel i9", "32GB")
                .storage("2TB NVMe SSD")
                .gpu("NVIDIA RTX 4090")
                .wifi(true)
                .bluetooth(true)
                .build();

        System.out.println("Basic configuration: " + basic);
        System.out.println("Gaming configuration: " + gamingPc);
    }
}
