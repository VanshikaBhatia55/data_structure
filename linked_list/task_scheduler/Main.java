package data_structure.linked_list.task_scheduler;

public class Main {
    public static void main(String[] args) {
        CircularTaskScheduler scheduler = new CircularTaskScheduler();

        // Adding tasks
        scheduler.addTaskAtBeginning(new Task(1, "Task A", 2, "2023-12-01"));
        scheduler.addTaskAtEnd(new Task(2, "Task B", 1, "2023-12-05"));
        scheduler.addTaskAtPosition(new Task(3, "Task C", 3, "2023-12-10"), 2);

        // Display all tasks
        System.out.println("All Tasks:");
        scheduler.displayAllTasks();

        // View current task and move to the next
        System.out.println("\nViewing Current Task:");
        scheduler.viewCurrentTask();
        scheduler.viewCurrentTask();

        // Search tasks by priority
        System.out.println("\nTasks with Priority 2:");
        scheduler.searchTasksByPriority(2);

        // Remove a task by ID
        System.out.println("\nRemoving Task with ID 2:");
        scheduler.removeTaskById(2);
        scheduler.displayAllTasks();
    }
}