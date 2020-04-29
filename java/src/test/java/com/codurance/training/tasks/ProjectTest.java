package com.codurance.training.tasks;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;

public class ProjectTest {
    String _name = "Project";
    Project project = new Project(_name);


    @Test
    public void getName() {
        String name = project.getName();
        assertEquals(_name, name);
    }

    @Test
    public void getSetTaskTask() {
        Task _task = new Task(1, "Task", false);
        project.setTask(_task);

        Task task = project.getTask(1);

        project = new Project(_name);
        assertEquals(_task, task);
    }

    @Test
    public void getTasks() {
        project.setTask(new Task(1, "1", false));
        project.setTask(new Task(2, "2", false));

        List<Task> tasks = new ArrayList<>(project.getTasks());

        assertEquals(2, tasks.size());
        project = new Project(_name);
    }

    @Test
    public void getTasksEmpty() {

        List<Task> tasks = new ArrayList<>(project.getTasks());

        assertEquals(0, tasks.size());
    }

    @Test
    public void deleteTaskNull() {
        Task task = project.deleteTask(1);

        assertNull(task);
    }
}