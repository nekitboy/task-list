package com.codurance.training.tasks;

import java.time.LocalDate;

public class Task {
    private final long id;
    private final String description;
    private LocalDate deadline;
    private boolean done;
    protected static long lastId = 0;

    private static long nextId() {
        return ++lastId;
    }

    public Task(long id, String description, boolean done) {
        this.id = id;
        this.description = description;
        this.done = done;
    }

    public Task(String description, boolean done) {
        this.id = nextId();
        this.description = description;
        this.done = done;
    }

    public long getId() {
        return id;
    }

    public String getDescription() {
        return description;
    }

    public boolean isDone() {
        return done;
    }

    public void setDone(boolean done) {
        this.done = done;
    }

    public LocalDate getDeadline() {
        return deadline;
    }

    public void setDeadline(LocalDate deadline) {
        this.deadline = deadline;
    }
}
