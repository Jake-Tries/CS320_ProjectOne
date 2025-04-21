/**
 * TaskServiceTest.java
 *
 * Created by: Jacob Barker
 * Date: 3/30/2025
 * Course: CS 320: Software Testing, Automation, and Quality Assurance (SNHU)
 *
 * Unit tests for the TaskService class, ensuring we can add,
 * delete, and update tasks correctly.
 */

package taskTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import task.Task;
import task.TaskService;

class TaskServiceTest {

    @Test
    void testAddTask() {
        TaskService service = new TaskService();
        Task task = new Task("12345", "Laundry", "Wash and fold clothes");
        service.addTask(task);

        assertNotNull(service.getTask("12345"));
        assertEquals("Laundry", service.getTask("12345").getName());
    }

    @Test
    void testAddTaskDuplicateId() {
        TaskService service = new TaskService();
        Task task1 = new Task("12345", "Homework", "Complete assignment");
        Task task2 = new Task("12345", "Errands", "Buy groceries");

        service.addTask(task1);
        assertThrows(IllegalArgumentException.class, () -> {
            service.addTask(task2);
        });
    }

    @Test
    void testDeleteTask() {
        TaskService service = new TaskService();
        Task task = new Task("11111", "Read", "Finish novel");
        service.addTask(task);

        service.deleteTask("11111");
        assertNull(service.getTask("11111"));
    }

    @Test
    void testDeleteTaskNotFound() {
        TaskService service = new TaskService();
        assertThrows(IllegalArgumentException.class, () -> {
            service.deleteTask("DoesNotExist");
        });
    }

    @Test
    void testUpdateName() {
        TaskService service = new TaskService();
        Task task = new Task("AAAAA", "Old Name", "Description");
        service.addTask(task);

        service.updateName("AAAAA", "New Name");
        assertEquals("New Name", service.getTask("AAAAA").getName());
    }

    @Test
    void testUpdateDescription() {
        TaskService service = new TaskService();
        Task task = new Task("ZZZZZ", "Title", "Old desc");
        service.addTask(task);

        service.updateDescription("ZZZZZ", "New updated description");
        assertEquals("New updated description", service.getTask("ZZZZZ").getDescription());
    }
}
