/**
 * Task.java
 *
 * Created by: Jacob Barker
 * Date: 3/24/2025
 * Course: CS 320: Software Testing, Automation, and Quality Assurance (SNHU)
 *
 * This class represents a single Task with an ID, name, and description.
 * It enforces constraints on each field to match the project requirements:
 * - ID: not null, <= 10 chars, non-updatable
 * - name: not null, <= 20 chars
 * - description: not null, <= 50 chars
 */

package task;

public class Task {

    //--------------------------------------------------------------------------
    // Fields
    //--------------------------------------------------------------------------
    private final String taskId;    // Must be <= 10 chars, not null, not updatable
    private String name;            // Must be <= 20 chars, not null
    private String description;     // Must be <= 50 chars, not null

    //--------------------------------------------------------------------------
    // Constructor
    //--------------------------------------------------------------------------
    /**
     * Constructs a Task object, enforcing the following constraints:
     * - taskId: non-null, <= 10 chars
     * - name: non-null, <= 20 chars
     * - description: non-null, <= 50 chars
     *
     * @param taskId      The unique ID for the Task
     * @param name        The name of the Task
     * @param description The Task description
     * @throws IllegalArgumentException if any field is invalid
     */
    public Task(String taskId, String name, String description) {
        if (taskId == null || taskId.length() > 10) {
            throw new IllegalArgumentException("Invalid Task ID");
        }
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid Task name");
        }
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Task description");
        }

        this.taskId = taskId;
        this.name = name;
        this.description = description;
    }

    //--------------------------------------------------------------------------
    // Getters (taskId has no setter)
    //--------------------------------------------------------------------------
    public String getTaskId() {
        return taskId;
    }

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    //--------------------------------------------------------------------------
    // Setters for updatable fields (name, description)
    //--------------------------------------------------------------------------
    public void setName(String name) {
        if (name == null || name.length() > 20) {
            throw new IllegalArgumentException("Invalid Task name");
        }
        this.name = name;
    }

    public void setDescription(String description) {
        if (description == null || description.length() > 50) {
            throw new IllegalArgumentException("Invalid Task description");
        }
        this.description = description;
    }
}
