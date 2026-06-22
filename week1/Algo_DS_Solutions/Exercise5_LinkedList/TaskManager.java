class Task {
    int taskId;
    String taskName;
    String status;
    Task next;

    Task(int id, String name, String status) {
        this.taskId = id;
        this.taskName = name;
        this.status = status;
        this.next = null;
    }
}

public class TaskManager {

    static Task head = null;

    static void addTask(int id, String name, String status) {
        Task newTask = new Task(id, name, status);
        if (head == null) {
            head = newTask;
        } else {
            Task temp = head;
            while (temp.next != null) {
                temp = temp.next;
            }
            temp.next = newTask;
        }
        System.out.println("Task added: " + name);
    }

    static void traverse() {
        Task temp = head;
        if (temp == null) {
            System.out.println("No tasks");
            return;
        }
        while (temp != null) {
            System.out.println("ID: " + temp.taskId + " | Task: " + temp.taskName + " | Status: " + temp.status);
            temp = temp.next;
        }
    }

    static Task search(int id) {
        Task temp = head;
        while (temp != null) {
            if (temp.taskId == id) return temp;
            temp = temp.next;
        }
        return null;
    }

    static void deleteTask(int id) {
        if (head == null) return;

        if (head.taskId == id) {
            head = head.next;
            System.out.println("Deleted task " + id);
            return;
        }

        Task prev = head;
        Task curr = head.next;
        while (curr != null) {
            if (curr.taskId == id) {
                prev.next = curr.next;
                System.out.println("Deleted task " + id);
                return;
            }
            prev = curr;
            curr = curr.next;
        }
        System.out.println("Task not found");
    }

    public static void main(String[] args) {
        addTask(1, "Design DB schema", "Pending");
        addTask(2, "Build API", "In Progress");
        addTask(3, "Write tests", "Pending");

        System.out.println("\nAll tasks:");
        traverse();

        Task t = search(2);
        System.out.println("\nSearch result: " + (t != null ? t.taskName : "Not found"));

        deleteTask(2);
        System.out.println("\nAfter deleting task 2:");
        traverse();
    }
}
