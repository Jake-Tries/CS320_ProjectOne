/**
 * TaskService.java
 *
 * Created by: Jacob Barker
 * Date: 3/29/2025
 * Course: CS 320: Software Testing, Automation, and Quality Assurance (SNHU)
 *
 * This service manages a collection of Task objects. It provides methods
 * to add, delete, and update tasks in an in-memory data structure.
 *
 * Requirements:
 * - Must store unique tasks by their ID
 * - Must allow updating name, description by ID
 */

package task;

import java.util.HashMap;
import java.util.Map;

public class TaskService {

    // In-memory map keyed by taskId
    private final Map<String, Task> tasks = new HashMap<>();

    /**
     * Adds a new Task, ensuring the ID is unique
     * @param task The task to be added
     * @throws IllegalArgumentException if the task ID already exists
     */
    public void addTask(Task task) {
        if (tasks.containsKey(task.getTaskId())) {
            throw new IllegalArgumentException("Task ID already exists");
        }
        tasks.put(task.getTaskId(), task);
    }

    /**
     * Deletes a Task by ID
     * @param taskId The ID of the task to remove
     * @throws IllegalArgumentException if the taskId doesn't exist
     */
    public void deleteTask(String taskId) {
        if (!tasks.containsKey(taskId)) {
            throw new IllegalArgumentException("Task not found for deletion");
        }
        tasks.remove(taskId);
    }

    /**
     * Updates the name of an existing Task
     * @param taskId  The ID of the Task to update
     * @param newName The new name
     * @throws IllegalArgumentException if task not found or name is invalid
     */
    public void updateName(String taskId, String newName) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found for update");
        }
        task.setName(newName);
    }

    /**
     * Updates the description of an existing Task
     * @param taskId         The ID of the Task to update
     * @param newDescription The new description
     * @throws IllegalArgumentException if task not found or description is invalid
     */
    public void updateDescription(String taskId, String newDescription) {
        Task task = tasks.get(taskId);
        if (task == null) {
            throw new IllegalArgumentException("Task not found for update");
        }
        task.setDescription(newDescription);
    }

    /**
     * Helper method to retrieve a Task by ID
     * @param taskId The ID of the Task
     * @return The Task if found, or null if not
     */
    public Task getTask(String taskId) {
        return tasks.get(taskId);
    }
}
