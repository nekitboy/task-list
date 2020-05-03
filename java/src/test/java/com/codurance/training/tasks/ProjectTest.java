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
        project.addTask(_task.getId());

        Boolean isTask = project.getTasksIds().get(_task.getId());

        project = new Project(_name);
        assertTrue(isTask);
    }

    @Test
    public void getTasks() {
        project.addTask(1);
        project.addTask(2);

        List<Long> tasks = new ArrayList<>(project.getTasksIds().keySet());

        assertEquals(2, tasks.size());
        project = new Project(_name);
    }

    @Test
    public void getTasksEmpty() {

        List<Long> tasks = new ArrayList<>(project.getTasksIds().keySet());

        assertEquals(0, tasks.size());
    }

    @Test
    public void deleteTaskNull() {
        project.addTask(1);
        project.deleteTask(1);
        project.deleteTask(2);
    }
}