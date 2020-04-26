package com.codurance.training.tasks;

import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class TaskTest {
    String _description = "Description";
    boolean _done = false;
    long _id;

    Task task = new Task(_id, _description, _done);

    @Test
    public void getId() {
        long id = task.getId();

        assertEquals(_id, id);
    }

    @Test
    public void getDescription() {
        String description = task.getDescription();

        assertEquals(_description, description);
    }

    @Test
    public void isDone() {
        boolean done = task.isDone();

        assertEquals(_done, done);
    }

    @Test
    public void setDone() {
        task.setDone(!_done);
        assertEquals(!_done, task.isDone());

        task.setDone(_done);
        assertEquals(_done, task.isDone());
    }
}