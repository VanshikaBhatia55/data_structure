package data_structure.linked_list.task_scheduler;

public class Task {
    int taskId;
    String taskName;
    int priority;
    String dueDate;
    Task next;

    // Constructor
    public Task(int taskId, String taskName, int priority, String dueDate) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.priority = priority;
        this.dueDate = dueDate;
        this.next = null;
    }

    @Override
    public String toString() {
        return "Task ID: " + taskId + ", Task Name: " + taskName + ", Priority: " + priority + ", Due Date: " + dueDate;
    }
}