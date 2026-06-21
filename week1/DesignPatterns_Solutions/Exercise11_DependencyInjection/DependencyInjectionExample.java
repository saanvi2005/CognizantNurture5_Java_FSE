// Exercise 11: Dependency Injection
// Scenario: A customer management application where the service class
// depends on a repository class, wired together via constructor injection.

// ---- Model ----
class Customer {
    private final String id;
    private final String name;

    public Customer(String id, String name) {
        this.id = id;
        this.name = name;
    }

    public String getId() { return id; }
    public String getName() { return name; }
}

// ---- Repository abstraction ----
interface CustomerRepository {
    Customer findCustomerById(String id);
}

// ---- Concrete repository ----
class CustomerRepositoryImpl implements CustomerRepository {
    public Customer findCustomerById(String id) {
        // Simulated data lookup (e.g., would normally query a database)
        System.out.println("Querying database for customer with id: " + id);
        return new Customer(id, "John Doe");
    }
}

// ---- Service class with injected dependency ----
class CustomerService {
    private final CustomerRepository customerRepository;

    // Constructor injection
    public CustomerService(CustomerRepository customerRepository) {
        this.customerRepository = customerRepository;
    }

    public Customer getCustomer(String id) {
        return customerRepository.findCustomerById(id);
    }
}

// ---- Test class (main) ----
public class DependencyInjectionExample {
    public static void main(String[] args) {
        // The dependency is created externally and "injected" into CustomerService
        CustomerRepository repository = new CustomerRepositoryImpl();
        CustomerService customerService = new CustomerService(repository);

        Customer customer = customerService.getCustomer("C123");
        System.out.println("Found customer: " + customer.getName() + " (ID: " + customer.getId() + ")");
    }
}
