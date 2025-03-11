package data_structure.linked_list.task_scheduler;

public class CircularTaskScheduler {
    private Task head;
    private Task current;

    // Check if the list is empty
    public boolean isEmpty() {
        return head == null;
    }

    // Add a task at the beginning of the list
    public void addTaskAtBeginning(Task task) {
        if (isEmpty()) {
            head = task;
            head.next = head; // Circular reference
            current = head;
        } else {
            Task lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
            task.next = head;
            head = task;
            lastNode.next = head;
        }
    }

    // Add a task at the end of the list
    public void addTaskAtEnd(Task task) {
        if (isEmpty()) {
            head = task;
            head.next = head; // Circular reference
            current = head;
        } else {
            Task lastNode = head;
            while (lastNode.next != head) {
                lastNode = lastNode.next;
            }
            lastNode.next = task;
            task.next = head;
        }
    }

    // Add a task at a specific position
    public void addTaskAtPosition(Task task, int position) {
        if (position < 1) {
            System.out.println("Invalid position. Position should be >= 1.");
            return;
        }
        if (position == 1) {
            addTaskAtBeginning(task);
        } else {
            Task temp = head;
            for (int i = 1; i < position - 1; i++) {
                temp = temp.next;
                if (temp == head) {
                    System.out.println("Position out of range.");
                    return;
                }
            }
            task.next = temp.next;
            temp.next = task;
        }
    }

    // Remove a task by Task ID
    public void removeTaskById(int taskId) {
        if (isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        }
        Task temp = head;
        Task prev = null;
        do {
            if (temp.taskId == taskId) {
                if (temp == head) {
                    Task lastNode = head;
                    while (lastNode.next != head) {
                        lastNode = lastNode.next;
                    }
                    if (head == head.next) {
                        head = null;
                    } else {
                        head = head.next;
                        lastNode.next = head;
                    }
                    if (current == temp) {
                        current = head;
                    }
                } else {
                    prev.next = temp.next;
                    if (current == temp) {
                        current = temp.next;
                    }
                }
                System.out.println("Task with ID " + taskId + " removed.");
                return;
            }
            prev = temp;
            temp = temp.next;
        } while (temp != head);
        System.out.println("Task with ID " + taskId + " not found.");
    }

    // View the current task and move to the next task
    public void viewCurrentTask() {
        if (isEmpty()) {
            System.out.println("No tasks available.");
            return;
        }
        System.out.println("Current Task: " + current);
        current = current.next;
    }

    // Display all tasks in the list
    public void displayAllTasks() {
        if (isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        }
        Task temp = head;
        do {
            System.out.println(temp);
            temp = temp.next;
        } while (temp != head);
    }

    // Search for tasks by priority
    public void searchTasksByPriority(int priority) {
        if (isEmpty()) {
            System.out.println("Task list is empty.");
            return;
        }
        Task temp = head;
        boolean found = false;
        do {
            if (temp.priority == priority) {
                System.out.println(temp);
                found = true;
            }
            temp = temp.next;
        } while (temp != head);
        if (!found) {
            System.out.println("No tasks found with priority " + priority + ".");
        }
    }
}

