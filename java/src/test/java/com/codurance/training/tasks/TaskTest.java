package com.codurance.training.tasks;

import org.hamcrest.CoreMatchers;
import org.junit.Test;

import java.util.ArrayList;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThat;

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

    @Test
    public void nextTaskId() {
        ArrayList<Long> ids = new ArrayList<>();

        ids.add(new Task(_description, _done).getId());
        ids.add(new Task(_description, _done).getId());
        ids.add(new Task(_description, _done).getId());
        ids.add(new Task(_description, _done).getId());

        assertThat(ids, CoreMatchers.hasItems(1L, 2L, 3L, 4L));
    }
}