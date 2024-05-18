package task5_3HD_ontrack;

import java.util.ArrayList;
import java.util.List;

// Task class to represent a task
class Task {
    private String taskId;
    private String taskName;
    private String status;
    private String deadline;
    private String instructions;

    // Constructor
    public Task(String taskId, String taskName, String status, String deadline, String instructions) {
        this.taskId = taskId;
        this.taskName = taskName;
        this.status = status;
        this.deadline = deadline;
        this.instructions = instructions;
    }

    // Getters
    public String getTaskId() {
        return taskId;
    }

    public String getTaskName() {
        return taskName;
    }

    public String getStatus() {
        return status;
    }

    public String getDeadline() {
        return deadline;
    }

    public String getInstructions() {
        return instructions;
    }
    
    // Setter for status
    public void setStatus(String status) {
        this.status = status;
    }
}

// TaskManager class to manage tasks
class TaskManager {
    private List<Task> tasks;

    // Constructor
    public TaskManager() {
        tasks = new ArrayList<>();
    }

    // Method to add task
    public void addTask(Task task) {
        tasks.add(task);
    }

    // Method to get all tasks for a given student ID
    public List<Task> getTasksForStudent(String studentId) {
        List<Task> studentTasks = new ArrayList<>();
        // Logic to filter tasks for the given student ID
        // For demonstration, returning all tasks
        studentTasks.addAll(tasks);
        return studentTasks;
    }

    // Method to filter tasks by status
    public List<Task> filterTasksByStatus(String status) {
        List<Task> filteredTasks = new ArrayList<>();
        for (Task task : tasks) {
            if (task.getStatus().equals(status)) {
                filteredTasks.add(task);
            }
        }
        return filteredTasks;
    }

    // Method to update task status
    public void updateTaskStatus(String taskId, String status) {
        for (Task task : tasks) {
            if (task.getTaskId().equals(taskId)) {
                task.setStatus(status);
                break;
            }
        }
    }
}

public class TaskManagerApp {
    public static void main(String[] args) {
        // Creating a sample task manager
        TaskManager taskManager = new TaskManager();

        // Adding sample tasks
        taskManager.addTask(new Task("1", "Homework 1", "Pending", "2024-05-20", "Complete Chapter 1 exercises"));
        taskManager.addTask(new Task("2", "Assignment 1", "Pending", "2024-05-25", "Write a research paper"));
        taskManager.addTask(new Task("3", "Project 1", "Completed", "2024-06-05", "Develop a web application"));

        // Retrieving tasks for a student
        List<Task> studentTasks = taskManager.getTasksForStudent("123456");
        System.out.println("Tasks for student 123456:");
        for (Task task : studentTasks) {
            System.out.println(task.getTaskName() + " - " + task.getStatus());
        }

        // Filtering tasks by status
        List<Task> filteredTasks = taskManager.filterTasksByStatus("Pending");
        System.out.println("\nPending tasks:");
        for (Task task : filteredTasks) {
            System.out.println(task.getTaskName() + " - " + task.getStatus());
        }

        // Updating task status
        taskManager.updateTaskStatus("1", "Completed");
        System.out.println("\nUpdated task status:");
        for (Task task : taskManager.getTasksForStudent("123456")) {
            System.out.println(task.getTaskName() + " - " + task.getStatus());
        }
    }
}
