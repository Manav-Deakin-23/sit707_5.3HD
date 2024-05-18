package task5_3HD_ontrack;


import java.util.List;
import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;

public class TaskManagerTest {
    private TaskManager taskManager;

    @Before
    public void setUp() {
        taskManager = new TaskManager();
        taskManager.addTask(new Task("1", "Homework 1", "Pending", "2024-05-20", "Complete Chapter 1 exercises"));
        taskManager.addTask(new Task("2", "Assignment 1", "Pending", "2024-05-25", "Write a research paper"));
        taskManager.addTask(new Task("3", "Project 1", "Completed", "2024-06-05", "Develop a web application"));
    }

    @Test
    public void testGetTasksForStudent() {
        List<Task> studentTasks = taskManager.getTasksForStudent("123456");
        Assert.assertEquals(3, studentTasks.size());
    }

    @Test
    public void testFilterTasksByStatus() {
        List<Task> pendingTasks = taskManager.filterTasksByStatus("Pending");
        Assert.assertEquals(2, pendingTasks.size());
    }

    @Test
    public void testUpdateTaskStatus() {
        taskManager.updateTaskStatus("1", "Completed");
        List<Task> studentTasks = taskManager.getTasksForStudent("123456");
        for (Task task : studentTasks) {
            if (task.getTaskId().equals("1")) {
                Assert.assertEquals("Completed", task.getStatus());
            }
        }
    }
}
