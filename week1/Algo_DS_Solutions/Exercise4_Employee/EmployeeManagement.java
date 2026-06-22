public class EmployeeManagement {

    static int MAX = 10;
    static String[] names = new String[MAX];
    static int[] ids = new int[MAX];
    static String[] positions = new String[MAX];
    static double[] salaries = new double[MAX];
    static int count = 0;

    static void addEmployee(int id, String name, String pos, double sal) {
        if (count >= MAX) {
            System.out.println("Array full!");
            return;
        }
        ids[count] = id;
        names[count] = name;
        positions[count] = pos;
        salaries[count] = sal;
        count++;
        System.out.println("Added employee: " + name);
    }

    static int searchById(int id) {
        for (int i = 0; i < count; i++) {
            if (ids[i] == id) return i;
        }
        return -1;
    }

    static void traverse() {
        System.out.println("All employees:");
        for (int i = 0; i < count; i++) {
            System.out.println("ID: " + ids[i] + " | Name: " + names[i] + " | Pos: " + positions[i] + " | Salary: " + salaries[i]);
        }
    }

    static void deleteEmployee(int id) {
        int idx = searchById(id);
        if (idx == -1) {
            System.out.println("Employee not found");
            return;
        }
        // shift everything left
        for (int i = idx; i < count - 1; i++) {
            ids[i] = ids[i + 1];
            names[i] = names[i + 1];
            positions[i] = positions[i + 1];
            salaries[i] = salaries[i + 1];
        }
        count--;
        System.out.println("Deleted employee with ID " + id);
    }

    public static void main(String[] args) {
        addEmployee(101, "John", "Developer", 75000);
        addEmployee(102, "Sara", "Manager", 90000);
        addEmployee(103, "Mike", "Designer", 65000);

        traverse();

        int idx = searchById(102);
        if (idx != -1) {
            System.out.println("\nFound: " + names[idx] + " at index " + idx);
        }

        deleteEmployee(102);
        System.out.println("\nAfter deletion:");
        traverse();
    }
}
