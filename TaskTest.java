/**
 * TaskTest.java
 *
 * Created by: Jacob Barker
 * Date: 3/30/2025
 * Course: CS 320: Software Testing, Automation, and Quality Assurance (SNHU)
 *
 * Unit tests for the Task class, verifying that constraints
 * (e.g., null checks, length limits) are enforced.
 */

package taskTest;

import static org.junit.jupiter.api.Assertions.*;
import org.junit.jupiter.api.Test;
import task.Task;

class TaskTest {

    @Test
    void testValidTask() {
        Task task = new Task("12345", "Do Homework", "Complete math assignment");
        assertEquals("12345", task.getTaskId());
        assertEquals("Do Homework", task.getName());
        assertEquals("Complete math assignment", task.getDescription());
    }

    @Test
    void testTaskIdTooLong() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345678901", "Name", "Desc");
        });
    }

    @Test
    void testTaskIdNull() {
        assertThrows(IllegalArgumentException.class, () -> {
            new Task(null, "Name", "Desc");
        });
    }

    @Test
    void testNameTooLong() {
        String longName = "ABCDEFGHIJKLMNOPQRSTUV"; // 22 chars
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", longName, "Short description");
        });
    }

    @Test
    void testDescriptionTooLong() {
        String longDesc = "This description is definitely more than fifty characters in length, so it fails.";
        assertThrows(IllegalArgumentException.class, () -> {
            new Task("12345", "Name", longDesc);
        });
    }

    @Test
    void testSetNameValid() {
        Task task = new Task("A1B2C", "Original", "Desc");
        task.setName("Changed");
        assertEquals("Changed", task.getName());
    }

    @Test
    void testSetNameInvalid() {
        Task task = new Task("OK123", "Valid", "Testing");
        assertThrows(IllegalArgumentException.class, () -> {
            task.setName(null);
        });
    }

    @Test
    void testSetDescriptionValid() {
        Task task = new Task("X5678", "Feed Cat", "Desc");
        task.setDescription("New description");
        assertEquals("New description", task.getDescription());
    }
}
