import java.util.ArrayList;
import java.util.Scanner;

public class TodoList {
    static class Task {
        String title;
        String description;
        String dueDate;
        boolean isCompleted;

        Task(String title, String description, String dueDate) {
            this.title = title;
            this.description = description;
            this.dueDate = dueDate;
            this.isCompleted = false;
        }

        @Override
        public String toString() {
            return title + " - " + description + " (Due: " + dueDate + ") - " + (isCompleted ? "Completed" : "Pending");
        }
    }

    private static ArrayList<Task> tasks = new ArrayList<>();

    public static void addTask(String title, String description, String dueDate) {
        tasks.add(new Task(title, description, dueDate));
    }

    public static void editTask(int index, String title, String description, String dueDate) {
        if (index >= 0 && index < tasks.size()) {
            Task task = tasks.get(index);
            task.title = title;
            task.description = description;
            task.dueDate = dueDate;
        }
    }

    public static void deleteTask(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.remove(index);
        }
    }

    public static void markTaskAsCompleted(int index) {
        if (index >= 0 && index < tasks.size()) {
            tasks.get(index).isCompleted = true;
        }
    }

    public static void listTasks() {
        for (int i = 0; i < tasks.size(); i++) {
            System.out.println(i + ": " + tasks.get(i));
        }
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\n1. Add Task");
            System.out.println("2. Edit Task");
            System.out.println("3. Delete Task");
            System.out.println("4. Mark Task as Completed");
            System.out.println("5. List Tasks");
            System.out.println("6. Exit");
            System.out.print("Choose an option: ");
            int choice = scanner.nextInt();
            scanner.nextLine();  // Consume newline

            switch (choice) {
                case 1:
                    System.out.print("Title: ");
                    String title = scanner.nextLine();
                    System.out.print("Description: ");
                    String description = scanner.nextLine();
                    System.out.print("Due Date: ");
                    String dueDate = scanner.nextLine();
                    addTask(title, description, dueDate);
                    break;
                case 2:
                    listTasks();
                    System.out.print("Task number to edit: ");
                    int editIndex = scanner.nextInt();
                    scanner.nextLine();  // Consume newline
                    System.out.print("New Title: ");
                    String newTitle = scanner.nextLine();
                    System.out.print("New Description: ");
                    String newDescription = scanner.nextLine();
                    System.out.print("New Due Date: ");
                    String newDueDate = scanner.nextLine();
                    editTask(editIndex, newTitle, newDescription, newDueDate);
                    break;
                case 3:
                    listTasks();
                    System.out.print("Task number to delete: ");
                    int deleteIndex = scanner.nextInt();
                    deleteTask(deleteIndex);
                    break;
                case 4:
                    listTasks();
                    System.out.print("Task number to mark as completed: ");
                    int completeIndex = scanner.nextInt();
                    markTaskAsCompleted(completeIndex);
                    break;
                case 5:
                    listTasks();
                    break;
                case 6:
                    scanner.close();
                    return;
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}
